package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.Am5;
import it.trekkete.amcharts.component.axis.Axis;

public class LineSeries extends XYSeries {

    @Override
    protected String getLibrary() {
        return Am5.Library.XY;
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
