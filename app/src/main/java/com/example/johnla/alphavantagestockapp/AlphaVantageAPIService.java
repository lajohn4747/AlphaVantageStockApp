package com.example.johnla.alphavantagestockapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by johnla on 6/16/18.
 */

public interface AlphaVantageAPIService {
    @GET("/query?function=TIME_SERIES_DAILY&symbol=MSFT")
    Call<DailyResponse> getStockData(@Query("apikey") String apiKey);
}
