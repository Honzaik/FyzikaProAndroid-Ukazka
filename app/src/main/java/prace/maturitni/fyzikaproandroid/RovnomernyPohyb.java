package prace.maturitni.fyzikaproandroid;

import android.graphics.Color;
import android.util.Log;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class RovnomernyPohyb {

    private float rychlost;
    private float cas;

    public RovnomernyPohyb(float rychlost, float cas){
        this.rychlost = rychlost;
        this.cas = cas;
    }

    public LineData generateLineData(int type){
        ArrayList<String> XValues = generateXValues();
        ArrayList<Entry> YValues = generateYValues(type);
        ArrayList<LineDataSet> dataset = generateDataSet(YValues, type);
        return new LineData(XValues, dataset);
    }

    private ArrayList<String> generateXValues(){
        ArrayList<String> XValues = new ArrayList<String>();
        int pocetIteraci = (int) Math.ceil(cas/0.05);
        for(int i = 0; i <= pocetIteraci; i++){
            String xValue = String.valueOf(Math.ceil((cas / pocetIteraci)*i*100)/100);
            XValues.add(xValue);
        }
        return XValues;
    }

    private ArrayList<Entry> generateYValues(int type){
        ArrayList<Entry> YValues = new ArrayList<Entry>();
        int pocetIteraci = (int) Math.ceil(cas/0.05);
        for(int i = 0; i <= pocetIteraci; i++){
            Entry yValue = new Entry(0,0);
            if(type == 0) yValue = new Entry(rychlost, i); //rychlost
            if(type == 1){
                yValue = new Entry(rychlost * ((float)i / (float)pocetIteraci) * cas, i); //draha
                Log.d("FYZ", (rychlost * (((float)i / (float)pocetIteraci) * cas)) + "");
            }
            if(type == 2) yValue = new Entry(0, i); //zrychleni
            YValues.add(yValue);
            }
        return YValues;
    }

    private ArrayList<LineDataSet> generateDataSet(ArrayList<Entry> YValues, int type){
        ArrayList<LineDataSet> datasets = new ArrayList<LineDataSet>();
        String name = "";
        if(type == 0) name = "Rychlost na čase";
        if(type == 1) name = "Dráha na čase";
        if(type == 2) name = "Zrychlení na čase";
        LineDataSet dataset = new LineDataSet(YValues, name);
        dataset.setDrawCircles(false);
        dataset.setDrawValues(false);

        if(type == 0) dataset.setColor(Color.BLUE);
        if(type == 1) dataset.setColor(Color.MAGENTA);
        if(type == 2) dataset.setColor(Color.YELLOW);
        dataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        datasets.add(dataset);
        return datasets;
    }
}
