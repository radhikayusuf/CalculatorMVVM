package com.example.root.calculatormvvm.ViewModel;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.example.root.calculatormvvm.ObservableString;


import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by root on 06/10/16.
 */

public class MainActivityVM extends GitsVM{

    public Button.OnClickListener btn;
    public ObservableString observableString = new ObservableString("");

    public MainActivityVM(Context context) {
        super(context);
        btn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }
}
