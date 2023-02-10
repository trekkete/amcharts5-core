package it.trekkete.amcharts.component.axis.renderer;

import it.trekkete.amcharts.Am5;

public class AxisRendererY extends AxisRenderer{

    @Override
    protected String getLibrary() {
        return Am5.Library.XY;
    }

    @Override
    public String getType() {
        return "AxisRendererY";
    }
}
