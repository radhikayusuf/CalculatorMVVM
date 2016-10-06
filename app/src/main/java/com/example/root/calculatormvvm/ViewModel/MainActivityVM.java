package com.example.root.calculatormvvm.ViewModel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.root.calculatormvvm.Adapter.MainActivityAdapter;
import com.example.root.calculatormvvm.Dao.HistoryDao;
import com.example.root.calculatormvvm.Function.ConvertIdtoString;
import com.example.root.calculatormvvm.Function.DetectInputType;
import com.example.root.calculatormvvm.Function.MathOprator;
import com.example.root.calculatormvvm.ObservableString;


import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 06/10/16.
 */

public class MainActivityVM extends GitsVM{

    public boolean isGone = false;
    public MainActivityAdapter adapter;
    public LinearLayoutManager layoutManager;
    public Button.OnClickListener btn;
    public ObservableString obs = new ObservableString("",false);
    ConvertIdtoString convertIdtoString = new ConvertIdtoString();
    DetectInputType detectInputType = new DetectInputType();
    MathOprator mo = new MathOprator();
    boolean op = true;
    String operation = "", num_buff="", num_after="";
    int pos_op= 0;
    List<HistoryDao> historyDaos = new ArrayList<>();
    double hasilAkhir = 0;

    public MainActivityVM(Context context) {
        super(context);
        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasilID = convertIdtoString.convertIdtoString(v);
                String hasilType = detectInputType.detectInputType(hasilID);

                if(hasilType.equals("num")){
                    obs.setValue(obs.getValue()+hasilID);
                }else if(hasilType.equals("op")){
                        if(op == false){
                            hasilAkhir = hitung(operation, Double.parseDouble(num_buff), Double.parseDouble(obs.getValue().substring(pos_op, obs.getValue().length())));
                            obs.setValue(String.valueOf(hasilAkhir));
                            System.out.println(historyDaos.get(0).getHistory());
                            op = true;
                        }else{
                            operation = hasilID;
                            num_buff = obs.getValue();
                            obs.setValue(obs.getValue()+hasilID);
                            op = false;
                            pos_op = obs.getValue().length();
                            System.out.println("check point "+hasilID+" ke "+obs.getValue().length());
                        }
                }else if(hasilType.equals("clear")){
                        obs.setValue("");
                        pos_op = 0;
                        operation = "";
                        op = true;
                }else if(hasilType.equals("his")){
                        isGone = isGone != true ? true : false;
                        obs.setGone(isGone);
                }else if(hasilType.equals("del")){
                        obs.setValue(obs.getValue().length() > 0 ? obs.getValue().substring(0 , obs.getValue().length()-1) : "");
                }else if(hasilType.equals("res")){
                    if(!operation.isEmpty()){
                        hasilAkhir = hitung(operation, Double.parseDouble(num_buff), Double.parseDouble(obs.getValue().substring(pos_op, obs.getValue().length())));
                        obs.setValue(String.valueOf(hasilAkhir));
                        op = true;
                    }else if(obs.getValue().charAt(obs.getValue().length()) == '+' || obs.getValue().charAt(obs.getValue().length()) == '-' || obs.getValue().charAt(obs.getValue().length()) == '*' || obs.getValue().charAt(obs.getValue().length()) == '/'){
                        obs.setValue(obs.getValue().substring(0,obs.getValue().length() -1));

                    }

                }
            }
        };
        adapter = new MainActivityAdapter(historyDaos);
        layoutManager = new LinearLayoutManager(context);
    }


    public Double hitung(String o, double num1, double num2){
        double hasil = 0;

        if (o.equals("*")){
            hasil = mo.oprasiKali(num1, num2);
        }else if (o.equals("/")){
            hasil = mo.oprasiBagi(num1, num2);
        }else if (o.equals("+")){
            hasil = mo.oprasiTambah(num1, num2);
        }else if (o.equals("-")){
            hasil = mo.oprasiKurang(num1, num2);
        }

        historyDaos.add(0, new HistoryDao(num1+" "+(operation.equals("*") ? "x" : operation)+" "+num2+ " = " +String.valueOf(hasil)));
        adapter.notifyDataSetChanged();
        operation = "";
        return hasil;
    }

    @BindingAdapter({"layout_visible"})
    public void onLayoutVisblityChange(RelativeLayout layout , String isGone){
        if(isGone.equalsIgnoreCase("true")){
            layout.setVisibility(View.GONE);
        }else {
            layout.setVisibility(View.VISIBLE);
        }
    }
}
