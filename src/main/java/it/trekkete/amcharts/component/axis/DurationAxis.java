package it.trekkete.amcharts.component.axis;

import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;

public class DurationAxis extends Axis{

    public DurationAxis(Direction direction, AxisRenderer renderer) {
        super(direction, renderer);

        set("baseUnit", "hour");
    }

    public void setBaseUnit(String baseUnit) {
        set("baseUnit", baseUnit);
    }

    @Override
    public String getType() {
        return "DurationAxis";
    }
}
