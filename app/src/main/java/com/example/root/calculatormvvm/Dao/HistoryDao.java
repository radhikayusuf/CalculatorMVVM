package com.example.root.calculatormvvm.Dao;

/**
 * Created by Varokah on 10/6/2016.
 */

public class HistoryDao {
    public String History;

    public HistoryDao(String history) {
        History = history;
    }

    public String getHistory() {
        return History;
    }

    public void setHistory(String history) {
        History = history;
    }
}
