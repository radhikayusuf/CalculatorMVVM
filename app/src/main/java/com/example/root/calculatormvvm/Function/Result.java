package com.example.root.calculatormvvm.Function;

/**
 * Created by Varokah on 10/6/2016.
 */

public class Result {
    public static String resultToString(Double res){
        String result = String.valueOf(res);
        int i = result.length();
        for(i = result.length()-1;i > 0;i--){
            if(result.charAt(i) == '0' && result.charAt(i-1) == '.'){
                    result = result.substring(0,result.length()-2);
                    break;
            }
        }
        return result;
    }
}
