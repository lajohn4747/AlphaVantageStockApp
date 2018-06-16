package com.example.johnla.alphavantagestockapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by johnla on 6/16/18.
 */

public class StockPointInfo {
    @SerializedName("1. open")
    @Expose
    private String openValue;
    @SerializedName("2. high")
    @Expose
    private String highValue;
    @SerializedName("3. low")
    @Expose
    private String lowValue;
    @SerializedName("4. close")
    @Expose
    private String closeValue;
    @SerializedName("5. volume")
    @Expose
    private String volumeValue;

    public String getOpenValue() {
        return openValue;
    }

    public String getHighValue() {
        return highValue;
    }

    public String getLowValue() {
        return lowValue;
    }

    public String getCloseValue() {
        return closeValue;
    }

    public String getVolumeValue() {
        return volumeValue;
    }
}
