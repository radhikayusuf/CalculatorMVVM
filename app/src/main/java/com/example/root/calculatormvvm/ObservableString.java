package com.example.root.calculatormvvm;

/**
 * Created by root on 06/10/16.
 */

public class ObservableString {
    public String value;

    public ObservableString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
