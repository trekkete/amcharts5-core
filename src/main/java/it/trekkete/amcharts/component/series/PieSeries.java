package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.Am5;

public class PieSeries extends PercentSeries{

    public PieSeries() {
        super();
    }

    public PieSeries(String categoryField, String valueField) {
        super(categoryField, valueField);
    }

    @Override
    public String getType() {
        return "PieSeries";
    }
}
