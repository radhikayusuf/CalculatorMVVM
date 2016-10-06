package com.example.root.calculatormvvm.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import com.example.root.calculatormvvm.Dao.HistoryDao;
import com.example.root.calculatormvvm.databinding.CardHistoryBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by Varokah on 10/6/2016.
 */

public class HistoryVM extends GitsRowVM<HistoryDao,CardHistoryBinding>{
    ObservableField<String> bHistoryName = new ObservableField<>();
    public HistoryVM(Context context, CardHistoryBinding binding, HistoryDao data) {
        super(context, binding, data);
        bHistoryName.set(data.getHistory());

    }
}
