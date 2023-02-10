package it.trekkete.amcharts.component.series;

public class ChordDirected extends FlowSeries{

    public ChordDirected() {
    }

    public ChordDirected(String sourceIdField, String targetIdField, String valueField) {
        super(sourceIdField, targetIdField, valueField);
    }

    @Override
    public String getType() {
        return "ChordDirected";
    }
}
