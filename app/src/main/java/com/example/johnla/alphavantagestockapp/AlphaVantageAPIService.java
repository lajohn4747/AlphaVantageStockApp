package com.example.johnla.alphavantagestockapp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by johnla on 6/16/18.
 */
//"/query?function=TIME_SERIES_DAILY&symbol=AAPL&apikey={api_key}"
public interface AlphaVantageAPIService {
    @GET("/query?function=TIME_SERIES_DAILY&symbol=MSFT")
    Call<DailyResponse> getStockData(@Query("apikey") String apiKey);
}
