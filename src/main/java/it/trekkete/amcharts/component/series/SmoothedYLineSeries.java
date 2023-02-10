package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public class SmoothedYLineSeries extends LineSeries{
    public SmoothedYLineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "SmoothedYLineSeries";
    }
}
