package com.example.root.calculatormvvm.Adapter;

import android.support.v7.app.AppCompatActivity;

import com.example.root.calculatormvvm.Dao.HistoryDao;
import com.example.root.calculatormvvm.R;
import com.example.root.calculatormvvm.ViewModel.HistoryVM;
import com.example.root.calculatormvvm.databinding.CardHistoryBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by Varokah on 10/6/2016.
 */

public class MainActivityAdapter extends GitsAdapter<HistoryDao,HistoryVM,CardHistoryBinding> {

    public MainActivityAdapter(List<HistoryDao> collection) {
        super(collection);
    }

    @Override
    public HistoryVM createViewModel(AppCompatActivity activity, CardHistoryBinding binding, HistoryDao item, int position) {
        return new HistoryVM(activity,binding,item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.card_history;
    }

    @Override
    public void render(CardHistoryBinding binding, HistoryVM viewModel, HistoryDao item) {
        binding.setHis(viewModel);
    }

    @Override
    public void onRowClick(HistoryDao data, int position) {
    }
}
