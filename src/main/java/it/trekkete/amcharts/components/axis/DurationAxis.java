package it.trekkete.amcharts.components.axis;

public class DurationAxis extends Axis{

    public DurationAxis(AxisRenderer renderer) {
        super(renderer);

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
