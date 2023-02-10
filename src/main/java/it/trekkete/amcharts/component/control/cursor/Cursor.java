package it.trekkete.amcharts.component.control.cursor;

import it.trekkete.amcharts.component.Am5Component;

public abstract class Cursor extends Am5Component {

    public Cursor() {
        super();

        this.baseJs =
                """
                chart.set("cursor", am5xy.[[CURSOR_TYPE]].new(root, {
                  [[AM5_COMPONENT_PROPERTIES]]
                }));""";
    }

    public String render() {
        return super.render()
                .replace("[[CURSOR_TYPE]]", getCursorType());
    }

    public abstract String getCursorType();
}
