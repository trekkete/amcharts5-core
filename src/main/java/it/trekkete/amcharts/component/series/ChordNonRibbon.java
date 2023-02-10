package it.trekkete.amcharts.component.series;

public class ChordNonRibbon extends FlowSeries{

    public ChordNonRibbon() {
        super();
    }

    public ChordNonRibbon(String sourceIdField, String targetIdField, String valueField) {
        super(sourceIdField, targetIdField, valueField);
    }

    @Override
    public String getType() {
        return "ChordNonRibbon";
    }

    public void setLinkType(String linkType) {
        set("linkType", linkType);
    }
}
