package it.trekkete.amcharts.components.axis;

public class GaplessDateAxis extends DateAxis {

    public GaplessDateAxis(AxisRenderer renderer, String timeUnit) {
        super(renderer, timeUnit);
    }

    @Override
    public String getType() {
        return "GaplessDateAxis";
    }
}
