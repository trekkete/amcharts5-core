package it.trekkete.amcharts.component.axis;

import it.trekkete.amcharts.Am5;
import it.trekkete.amcharts.component.Am5Component;
import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;

import java.util.UUID;

public abstract class Axis extends Am5Component {

    public enum Direction {
        X,
        Y
    }

    protected Direction direction;
    protected AxisRenderer renderer;

    public Axis(Direction direction, AxisRenderer renderer) {
        super();
        this.id = UUID.randomUUID();
        this.name = "axis_" + id;
        this.renderer = renderer;
        this.direction = direction;

        this.baseJs =
                """
                var [[AM5_AXIS_NAME]] = chart.[[AM5_AXIS_DIRECTION]].push(
                  am5xy.[[AM5_AXIS_TYPE]].new(root, {
                    renderer: [[AM5_AXIS_RENDERER]],
                    [[AM5_COMPONENT_PROPERTIES]]
                  })
                );""";

        if (direction.equals(Direction.X)) {
            this.baseJs += "[[AM5_AXIS_NAME]].data.setAll(data);";
        }
    }

    public abstract String getType();

    public Direction getDirection() {
        return direction;
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.XY;
    }

    @Override
    public String render() {
        return super.render()
                .replace("[[AM5_AXIS_NAME]]", getEscapedName())
                .replace("[[AM5_AXIS_TYPE]]", getType())
                .replace("[[AM5_AXIS_RENDERER]]", renderer.getEscapedName())
                .replace("[[AM5_AXIS_DIRECTION]]", getDirection().equals(Direction.X) ? "xAxes" : "yAxes");
    }
}
