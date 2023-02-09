package it.trekkete.amcharts.components.series;

import it.trekkete.amcharts.components.axis.Axis;

public class StepLineSeries extends LineSeries{

    public StepLineSeries() {
        super();
    }

    public StepLineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "StepLineSeries";
    }
}
