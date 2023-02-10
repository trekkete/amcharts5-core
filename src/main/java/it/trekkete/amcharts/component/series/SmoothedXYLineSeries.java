package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public class SmoothedXYLineSeries extends LineSeries{

    public SmoothedXYLineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "SmoothedXYLineSeries";
    }
}
