package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public class RadarLineSeries extends LineSeries{

    public RadarLineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "RadarLineSeries";
    }
}
