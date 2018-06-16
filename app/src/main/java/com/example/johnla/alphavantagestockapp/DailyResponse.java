package com.example.johnla.alphavantagestockapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by johnla on 6/16/18.
 */


public class DailyResponse {
    @SerializedName("Time Series (Daily)")
    @Expose
    private HashMap<String, StockPointInfo> dailyResults;


    public HashMap<String, StockPointInfo> getDailyResults() {
        return dailyResults;
    }
}
