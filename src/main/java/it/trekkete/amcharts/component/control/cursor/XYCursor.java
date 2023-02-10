package it.trekkete.amcharts.component.control.cursor;

import it.trekkete.amcharts.Am5;

public class XYCursor extends Cursor{

    public XYCursor() {
        super();
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.XY;
    }

    @Override
    public String getCursorType() {
        return "XYCursor";
    }
}
