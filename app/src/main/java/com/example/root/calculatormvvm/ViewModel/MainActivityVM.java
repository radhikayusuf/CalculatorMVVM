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
    public ObservableString observableString = new ObservableString("");
    ConvertIdtoString convertIdtoString = new ConvertIdtoString();
    DetectInputType detectInputType = new DetectInputType();


    public MainActivityVM(Context context) {
        super(context);
        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hasilID = convertIdtoString.convertIdtoString(v);
                String hasilType = detectInputType.detectInputType(hasilID);

                if(hasilType.equals("num")){
                    observableString.setValue(observableString.getValue()+hasilID);
                }else if(hasilType.equals("op")){
                    observableString.setValue(observableString.getValue()+hasilID);
                }else if(hasilType.equals("clear")){

                }else if(hasilType.equals("his")){

                }else if(hasilType.equals("del")){

                }else if(hasilType.equals("res")){

                }
            }
        };
    }
}
