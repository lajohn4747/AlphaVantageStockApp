package com.example.johnla.alphavantagestockapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by johnla on 6/16/18.
 */

public class StockDailyInfo {
    private ArrayList<StockData> dailyInfoList;

    public StockDailyInfo() {
       dailyInfoList = new ArrayList<>();
    }

    public void addDay(StockData stockData) {
        dailyInfoList.add(stockData);
    }

    public ArrayList<StockData> getDailyInfoList() {
        return dailyInfoList;
    }
}
