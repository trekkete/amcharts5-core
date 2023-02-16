package it.trekkete.amcharts.component.control.cursor;

import it.trekkete.amcharts.component.Am5Component;

import java.util.UUID;

public abstract class Cursor extends Am5Component {

    public Cursor() {
        super();
        this.id = UUID.randomUUID();
        this.name = "cursor_" + id;

        this.baseJs =
                """
                var [[CURSOR_NAME]] = am5xy.[[CURSOR_TYPE]].new(root, {
                  [[AM5_COMPONENT_PROPERTIES]]
                });
                chart.set("cursor", [[CURSOR_NAME]]);""";
    }

    public String render() {
        return super.render()
                .replace("[[CURSOR_NAME]]", getEscapedName())
                .replace("[[CURSOR_TYPE]]", getCursorType());
    }

    public abstract String getCursorType();
}
