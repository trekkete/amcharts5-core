package it.trekkete.amcharts.component.axis;

import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;

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
