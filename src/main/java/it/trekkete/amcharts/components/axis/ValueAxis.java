package it.trekkete.amcharts.components.axis;

public class ValueAxis extends Axis{

    private String baseJs =
            "var [[AXIS_NAME]] = chart.[[AXIS_DIRECTION]].push(\n" +
            "  am5xy.ValueAxis.new(root, {\n" +
            "    renderer: am5xy.[[AXIS_RENDERER_DIRECTION]].new(root, {})\n" +
            "  })\n" +
            ");";

    public String render() {
        return baseJs
                .replace("[[AXIS_NAME]]", getName())
                .replace("[[AXIS_DIRECTION]]", getDirection().equals(Direction.X) ? "xAxes" : "yAxes")
                .replace("[[AXIS_RENDERER_DIRECTION]]", getDirection().equals(Direction.X) ? "AxisRendererX" : "AxisRendererY");
    }
}
