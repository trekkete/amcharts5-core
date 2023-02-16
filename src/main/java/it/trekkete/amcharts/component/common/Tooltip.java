package it.trekkete.amcharts.component.common;

import it.trekkete.amcharts.Am5;
import it.trekkete.amcharts.component.Am5Component;

import java.util.UUID;

public class Tooltip extends Am5Component {

    private String tooltip;

    public Tooltip(String tooltip) {
        super();
        this.id = UUID.randomUUID();
        this.name = "tooltip_" + id;
        this.tooltip = tooltip;

        this.baseJs =
                """
                var [[TOOLTIP_NAME]] = am5.Tooltip.new(root, {
                  labelText: "[[TOOLTIP_TEXT]]",
                  [[AM5_COMPONENT_PROPERTIES]]
                });""";

    }

    @Override
    protected String getLibrary() {
        return Am5.Library.COMMON;
    }

    @Override
    public String render() {
        return super.render()
                .replace("[[TOOLTIP_NAME]]", getEscapedName())
                .replace("[[TOOLTIP_TEXT]]", tooltip);
    }
}
