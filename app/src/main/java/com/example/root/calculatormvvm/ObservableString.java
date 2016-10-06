package com.example.root.calculatormvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by root on 06/10/16.
 */

public class ObservableString extends BaseObservable {
    public String value;

    public ObservableString(String value) {
        this.value = value;
    }

    @Bindable
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }
}
