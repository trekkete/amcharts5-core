package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.axis.Axis;

public abstract class XYSeries extends Series {

    protected Axis xAxis;
    protected Axis yAxis;

    public XYSeries(Axis xAxis, Axis yAxis) {
        super();

        setxAxis(xAxis);
        setyAxis(yAxis);
    }

    public Axis getxAxis() {
        return xAxis;
    }

    public void setxAxis(Axis xAxis) {
        this.xAxis = xAxis;

        set("xAxis", xAxis.getEscapedName(), true);
    }

    public Axis getyAxis() {
        return yAxis;
    }

    public void setyAxis(Axis yAxis) {
        this.yAxis = yAxis;

        set("yAxis", yAxis.getEscapedName(), true);
    }
}
