package it.trekkete.amcharts.component.series;

public class Chord extends FlowSeries {

    public Chord() {
        super();
    }

    public Chord(String sourceIdField, String targetIdField, String valueField) {
        super(sourceIdField, targetIdField, valueField);
    }

    @Override
    public String getType() {
        return "Chord";
    }
}
