package com.example.root.calculatormvvm.ViewModel;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.root.calculatormvvm.Function.ConvertIdtoString;
import com.example.root.calculatormvvm.Function.DetectInputType;
import com.example.root.calculatormvvm.ObservableString;


import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 06/10/16.
 */

public class MainActivityVM extends GitsVM{

    public Button.OnClickListener btn;
    public ObservableString obs = new ObservableString("");
    ConvertIdtoString convertIdtoString = new ConvertIdtoString();
    DetectInputType detectInputType = new DetectInputType();
    boolean op = true;

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
                    int x = obs.getValue().length() - 1;
                        if(op == false){
                            System.out.println("check point 1");
                        }else{
                            obs.setValue(obs.getValue()+hasilID);
                            op = false;
                            System.out.println("check point");
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
    }
}
