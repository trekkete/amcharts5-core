package it.trekkete.amcharts.component.axis;

import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;

public class GaplessDateAxis extends DateAxis {

    public GaplessDateAxis(Direction direction, AxisRenderer renderer, String timeUnit) {
        super(direction, renderer, timeUnit);
    }

    @Override
    public String getType() {
        return "GaplessDateAxis";
    }
}
