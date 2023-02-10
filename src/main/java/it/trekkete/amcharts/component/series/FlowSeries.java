package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.Am5;

public abstract class FlowSeries extends Series{

    protected String sourceIdField;
    protected String targetIdField;
    protected String valueField;

    public FlowSeries() {}

    public FlowSeries(String sourceIdField, String targetIdField, String valueField) {
        setSourceIdField(sourceIdField);
        setTargetIdField(targetIdField);
        setValueField(valueField);
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.FLOW;
    }

    public String getSourceIdField() {
        return sourceIdField;
    }

    public void setSourceIdField(String sourceIdField) {
        this.sourceIdField = sourceIdField;

        set("sourceIdField", sourceIdField);
    }

    public String getTargetIdField() {
        return targetIdField;
    }

    public void setTargetIdField(String targetIdField) {
        this.targetIdField = targetIdField;

        set("targetIdField", targetIdField);
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;

        set("valueField", valueField);
    }
}
