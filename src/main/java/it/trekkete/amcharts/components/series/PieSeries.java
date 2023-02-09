package it.trekkete.amcharts.components.series;

public class PieSeries extends Series{

    public PieSeries() {
        super();
    }

    public PieSeries(String categoryField, String valueField) {
        super();

        set("categoryField", categoryField);
        set("valueField", valueField);
    }

    public void setCategoryField(String categoryField) {
        set("categoryField", categoryField);
    }

    public void setValueField(String valueField) {
        set("valueField", valueField);
    }

    @Override
    public String getType() {
        return "PieSeries";
    }
}
