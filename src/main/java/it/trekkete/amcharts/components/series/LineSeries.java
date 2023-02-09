package it.trekkete.amcharts.components.series;

import it.trekkete.amcharts.components.axis.Axis;

public class LineSeries extends Series {

    public LineSeries() {
        super();
    }

    public LineSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "LineSeries";
    }

    public void setValueXField(String valueXField) {
        set("valueXField", valueXField);
    }

    public void setValueYField(String valueYField) {
        set("valueYField", valueYField);
    }
}
