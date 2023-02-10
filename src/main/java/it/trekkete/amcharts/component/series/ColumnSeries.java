package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.Am5;
import it.trekkete.amcharts.component.axis.Axis;

public class ColumnSeries extends XYSeries {

    @Override
    protected String getLibrary() {
        return Am5.Library.XY;
    }

    public ColumnSeries(Axis xAxis, Axis yAxis) {
        super(xAxis, yAxis);
    }

    @Override
    public String getType() {
        return "ColumnSeries";
    }
}
