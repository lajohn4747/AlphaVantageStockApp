package com.example.johnla.alphavantagestockapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity implements RetrofitClient.RetrofitListener{

    public static final String TAG = HomeActivity.class.getSimpleName();
    public static final String BASE_URL = "https://www.alphavantage.co";

    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mLineChart = (LineChart)findViewById(R.id.example_chart);
        mLineChart.getXAxis().setValueFormatter(new DateValueFormatter());

        fetchData(this);
    }

    private void fetchData(final RetrofitClient.RetrofitListener listener) {
        final List<Entry> entries = new ArrayList<>();
        AlphaVantageAPIService service = RetrofitClient.getDailyClient(BASE_URL).create(AlphaVantageAPIService.class);
        service.getStockData("demo").enqueue(new Callback<DailyResponse>() {
            @Override
            public void onResponse(Call<DailyResponse> call, Response<DailyResponse> response) {

                if(response.isSuccessful()) {
                    StockDailyInfo stockDailyInfo = response.body().getDailyResults();
                    for(StockData dayData : stockDailyInfo.getDailyInfoList()) {
                        float time = Long.valueOf(dayData.getDate().getTime()).floatValue();
                        Float value = dayData.getStockValue(StockData.StockValue.CLOSE);
                        entries.add(new Entry(time, value));
                    }
                    listener.onData(entries);
                } else {
                    Log.w(TAG, "Response was not successful");
                }
            }

            @Override
            public void onFailure(Call<DailyResponse> call, Throwable t) {
                Log.w(TAG, "AlphaVantageAPI Service Call Failed");
            }
        });
    }

    @Override
    public void onData(List<Entry> entries) {
        LineDataSet dataSet = new LineDataSet(entries, "MSFT");
        mLineChart.setData(new LineData(dataSet));
        mLineChart.invalidate();
    }
}
