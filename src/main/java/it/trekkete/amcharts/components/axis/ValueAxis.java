package it.trekkete.amcharts.components.axis;

public class ValueAxis extends Axis{

    public ValueAxis(Direction direction, AxisRenderer renderer) {
        super(direction, renderer);
    }

    @Override
    public String getType() {
        return "ValueAxis";
    }

    public String render() {
        return super.render();
    }
}
