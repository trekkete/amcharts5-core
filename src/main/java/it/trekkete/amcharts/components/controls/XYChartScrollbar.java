package it.trekkete.amcharts.components.controls;

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
}
