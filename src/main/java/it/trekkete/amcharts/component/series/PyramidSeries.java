package it.trekkete.amcharts.component.series;

public class PyramidSeries extends PercentSeries{

    public PyramidSeries() {
    }

    public PyramidSeries(String categoryField, String valueField) {
        super(categoryField, valueField);
    }

    @Override
    public String getType() {
        return "PiramidSeries";
    }
}
