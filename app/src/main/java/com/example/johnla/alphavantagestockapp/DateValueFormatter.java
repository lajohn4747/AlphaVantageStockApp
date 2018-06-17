package com.example.johnla.alphavantagestockapp;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by johnla on 6/16/18.
 */

public class DateValueFormatter implements IAxisValueFormatter {
    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        Date parsedDate = new Date(Float.valueOf(value).longValue());
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
        return formatter.format(parsedDate);
    }
}
