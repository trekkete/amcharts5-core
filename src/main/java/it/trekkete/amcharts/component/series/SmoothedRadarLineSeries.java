package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public class SmoothedRadarLineSeries extends SmoothedXLineSeries{
    public SmoothedRadarLineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "SmoothedRadarLineSeries";
    }
}
