package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public class RadarColumnSeries extends LineSeries{

    public RadarColumnSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "RadarColumnSeries";
    }
}
