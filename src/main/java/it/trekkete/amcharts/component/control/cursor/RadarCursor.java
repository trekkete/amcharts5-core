package it.trekkete.amcharts.component.control.cursor;

import it.trekkete.amcharts.Am5;

public class RadarCursor extends Cursor{
    @Override
    protected String getLibrary() {
        return Am5.Library.RADAR;
    }

    @Override
    public String getCursorType() {
        return "RadarCursor";
    }
}
