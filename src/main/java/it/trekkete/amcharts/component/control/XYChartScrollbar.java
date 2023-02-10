package it.trekkete.amcharts.component.control;

import it.trekkete.amcharts.Am5;

public class XYChartScrollbar extends Scrollbar {

    public XYChartScrollbar(Orientation orientation) {
        super(orientation);

        set("height", 50);
    }

    public void setHeight(int height) {
        set("height", height);
    }

    @Override
    public String getType() {
        return "XYChartScrollbar";
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.XY;
    }
}
