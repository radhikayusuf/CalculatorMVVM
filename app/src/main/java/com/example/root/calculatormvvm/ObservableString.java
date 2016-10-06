package com.example.root.calculatormvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by root on 06/10/16.
 */

public class ObservableString extends BaseObservable {
    public String value;
    public boolean isGone;

    public ObservableString(String value, boolean isGone) {
        this.value = value;
        this.isGone = isGone;
    }

    @Bindable
    public boolean isGone() {
        return isGone;
    }

    public void setGone(boolean gone) {
        isGone = gone;
        notifyPropertyChanged(BR.isGone);
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
