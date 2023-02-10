package it.trekkete.amcharts.charts;

import it.trekkete.amcharts.Am5;

public class Am5SlicedChart extends Am5Chart{
    @Override
    public String getType() {
        return "Am5SlicedChart";
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.PERCENT;
    }
}
