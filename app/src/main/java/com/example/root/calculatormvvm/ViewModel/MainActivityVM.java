package com.example.root.calculatormvvm.ViewModel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;

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

    public MainActivityAdapter adapter;
    public LinearLayoutManager layoutManager;
    public Button.OnClickListener btn;
    public ObservableString obs = new ObservableString("");
    ConvertIdtoString convertIdtoString = new ConvertIdtoString();
    DetectInputType detectInputType = new DetectInputType();
    MathOprator mo = new MathOprator();
    boolean op = true;
    String operation = "", num_buff="", num_after="";
    int pos_op= 0;
    List<HistoryDao> historyDaos = new ArrayList<>();

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
                            System.out.println("check point 1");
                            double hasil = mo.oprasiKali(Double.parseDouble(num_buff), Double.parseDouble(obs.getValue().substring(pos_op, obs.getValue().length())));
                            historyDaos.add(new HistoryDao(num_buff+(operation.equals("*") ? "x" : operation)+obs.getValue().substring(pos_op, obs.getValue().length()) + " = " +String.valueOf(hasil)));
                            obs.setValue(String.valueOf(hasil));
                            System.out.println(historyDaos.get(0).getHistory());
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
                }else if(hasilType.equals("his")){

                }else if(hasilType.equals("del")){
                        obs.setValue(obs.getValue().length() > 0 ? obs.getValue().substring(0 , obs.getValue().length()-1) : "");
                }else if(hasilType.equals("res")){

                }
            }
        };
        adapter = new MainActivityAdapter(historyDaos);
        layoutManager = new LinearLayoutManager(context);
    }
}
