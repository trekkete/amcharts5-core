package it.trekkete.amcharts.component.series;

public class FunnelSeries extends PercentSeries{

    public FunnelSeries() {
    }

    public FunnelSeries(String categoryField, String valueField) {
        super(categoryField, valueField);
    }

    @Override
    public String getType() {
        return "FunnelSeries";
    }
}
