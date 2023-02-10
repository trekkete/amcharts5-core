package it.trekkete.amcharts.component.axis.renderer;

import it.trekkete.amcharts.Am5;

public class AxisRendererCircular extends AxisRenderer {

    @Override
    public String getType() {
        return "AxisRendererCircular";
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.RADAR;
    }

}
