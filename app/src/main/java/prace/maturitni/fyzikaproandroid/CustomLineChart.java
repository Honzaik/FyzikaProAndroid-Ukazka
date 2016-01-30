package prace.maturitni.fyzikaproandroid;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;

public class CustomLineChart extends LineChart{
    public CustomLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.LTGRAY);
        setDrawGridBackground(true);
        this.setDrawBorders(true);
        this.setTouchEnabled(true);
        this.setScaleEnabled(true);
        this.setAutoScaleMinMaxEnabled(true);
        this.setHardwareAccelerationEnabled(true);;

        XAxis xAxis = this.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAvoidFirstLastClipping(true);

        getAxisRight().setEnabled(false);
    }
}
