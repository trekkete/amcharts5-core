package it.trekkete.amcharts.components.axis;

public class ValueAxis extends Axis{

    public ValueAxis(AxisRenderer renderer) {
        super(renderer);
    }

    @Override
    public String getType() {
        return "ValueAxis";
    }

    public String render() {
        return super.render();
    }
}
