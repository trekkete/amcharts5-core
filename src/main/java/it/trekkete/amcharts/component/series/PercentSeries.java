package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.Am5;

public abstract class PercentSeries extends Series{

    protected String categoryField;
    protected String valueField;

    public PercentSeries() {
    }

    public PercentSeries(String categoryField, String valueField) {
        setCategoryField(categoryField);
        setValueField(valueField);
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.PERCENT;
    }

    public String getValueField() {
        return valueField;
    }

    public void setValueField(String valueField) {
        this.valueField = valueField;

        set("valueField", valueField);
    }

    public String getCategoryField() {
        return categoryField;
    }

    public void setCategoryField(String categoryField) {
        this.categoryField = categoryField;

        set("categoryField", categoryField);
    }
}
