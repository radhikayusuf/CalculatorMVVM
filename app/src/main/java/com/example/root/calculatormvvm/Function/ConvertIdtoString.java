package com.example.root.calculatormvvm.Function;

import android.view.View;

import com.example.root.calculatormvvm.R;

/**
 * Created by Varokah on 10/6/2016.
 */

public class ConvertIdtoString {
    public String convertIdtoString(View v){
        switch (v.getId()){
            case R.id.btn0: return "0";
            case R.id.btn1: return "1";
            case R.id.btn2: return "2";
            case R.id.btn3: return "3";
            case R.id.btn4: return "4";
            case R.id.btn5: return "5";
            case R.id.btn6: return "6";
            case R.id.btn7: return "7";
            case R.id.btn8: return "8";
            case R.id.btn9: return "9";
            case R.id.btnBagi: return "/";
            case R.id.btnPlus: return "+";
            case R.id.btnMin: return "-";
            case R.id.btnKali: return "*";
            case R.id.btnEquals: return "=";
            case R.id.btnDot: return ".";
            case R.id.btnDel: return "del";
            case R.id.btnClearHis: return "chis";
            case R.id.btnClose: return "close";
            case R.id.btnClear: return "clear";
            case R.id.btnHis: return "his";
            default: return "none";
        }
    }
}
