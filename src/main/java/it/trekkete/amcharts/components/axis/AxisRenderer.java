package it.trekkete.amcharts.components.axis;

import it.trekkete.amcharts.components.Am5Component;

import java.util.UUID;

public class AxisRenderer extends Am5Component {

    private Axis.Direction direction;

    public AxisRenderer(Axis.Direction direction) {
        super();
        this.id = UUID.randomUUID();
        this.name = "renderer_" + id;
        this.direction = direction;

        this.baseJs =
                """
                var [[AM5_RENDERER_NAME]] = am5xy.[[AXIS_RENDERER_DIRECTION]].new(root, {
                  [[AM5_COMPONENT_PROPERTIES]]
                });
                """;
    }

    public Axis.Direction getDirection() {
        return direction;
    }

    @Override
    public String render() {
        return super.render()
                .replace("[[AM5_RENDERER_NAME]]", getEscapedName())
                .replace("[[AXIS_RENDERER_DIRECTION]]", getDirection().equals(Axis.Direction.X) ? "AxisRendererX" : "AxisRendererY");
    }
}
