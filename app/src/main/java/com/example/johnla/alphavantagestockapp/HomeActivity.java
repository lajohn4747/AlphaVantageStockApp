package com.example.johnla.alphavantagestockapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d("JOHN", "STAART");
        AlphaVantageAPIService service = RetrofitClient.getClient(BASE_URL).create(AlphaVantageAPIService.class);
        Log.d("JOHN",service.getStockData("demo").request().toString());
        service.getStockData("demo").enqueue(new Callback<DailyResponse>() {
            @Override
            public void onResponse(Call<DailyResponse> call, Response<DailyResponse> response) {

                if(response.isSuccessful()) {
                    Log.d("JOHN", "success");
                    HashMap<String, StockPointInfo> data = response.body().getDailyResults();
                    Log.d("JOHN", "got body");
                    for (Map.Entry<String, StockPointInfo> entry : data.entrySet()) {
                        Log.d("JOHN", entry.getKey());
                        Log.d("JOHN", entry.getValue().getLowValue());
                    }
                }
            }

            @Override
            public void onFailure(Call<DailyResponse> call, Throwable t) {
                Log.d("JOHN", "FAILURE");
            }
        });
    }


    public static final String BASE_URL = "https://www.alphavantage.co";
}
