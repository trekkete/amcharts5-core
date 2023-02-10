package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public class StepLineSeries extends LineSeries{

    public StepLineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "StepLineSeries";
    }
}
