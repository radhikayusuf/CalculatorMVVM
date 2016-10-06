package com.example.root.calculatormvvm.Function;

/**
 * Created by Varokah on 10/6/2016.
 */

public class DetectInputType {
    public String detectInputType(String string){
        switch (string){
            case "1": return "num";
            case "2": return "num";
            case "3": return "num";
            case "4": return "num";
            case "5": return "num";
            case "6": return "num";
            case "7": return "num";
            case "8": return "num";
            case "9": return "num";
            case "0": return "num";
            case "+": return "op";
            case "-": return "op";
            case "*": return "op";
            case "/": return "op";
            case "=": return "res";
            case "clear": return "clear";
            case "his": return "his";
            case "chis": return "chis";
            case "close": return "his";
            case "del": return "del";
            case ".": return "num";
            default:return "none";
        }
    }
}
