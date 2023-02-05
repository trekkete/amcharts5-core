package it.trekkete.amcharts.components.controls;

import it.trekkete.amcharts.Am5Component;

public abstract class Cursor implements Am5Component {

    private String baseJs =
            "chart.set(\"cursor\", am5xy.[[CURSOR_TYPE]].new(root, {}));";

    public String render() {
        return baseJs
                .replace("[[CURSOR_TYPE]]", getCursorType());
    }

    protected String getCursorType() {
        return null;
    }
}
