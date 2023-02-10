package it.trekkete.amcharts.charts;

import it.trekkete.amcharts.Am5;

public class Am5PieChart extends Am5Chart{

    @Override
    public String getType() {
        return "PieChart";
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.PERCENT;
    }
}
