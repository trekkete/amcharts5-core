package it.trekkete.amcharts.component.axis.renderer;

import it.trekkete.amcharts.Am5;

public class AxisRendererRadial extends AxisRenderer {

    @Override
    protected String getLibrary() {
        return Am5.Library.RADAR;
    }

    @Override
    public String getType() {
        return "AxisRendererRadial";
    }
}
