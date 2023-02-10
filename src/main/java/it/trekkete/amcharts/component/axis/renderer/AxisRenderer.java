package it.trekkete.amcharts.component.axis.renderer;

import it.trekkete.amcharts.component.Am5Component;

import java.util.UUID;

public abstract class AxisRenderer extends Am5Component {

    public AxisRenderer() {
        super();
        this.id = UUID.randomUUID();
        this.name = "renderer_" + id;

        this.baseJs =
                """
                var [[AM5_RENDERER_NAME]] = [[AM5_COMPONENT_LIBRARY]].[[AXIS_RENDERER_TYPE]].new(root, {
                  [[AM5_COMPONENT_PROPERTIES]]
                });
                """;
    }

    public abstract String getType();

    @Override
    public String render() {
        return super.render()
                .replace("[[AM5_RENDERER_NAME]]", getEscapedName())
                .replace("[[AXIS_RENDERER_TYPE]]", getType());
    }
}
