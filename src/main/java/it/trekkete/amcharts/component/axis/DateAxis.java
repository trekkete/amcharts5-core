package it.trekkete.amcharts.component.axis;

import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;
import org.bson.Document;

public class DateAxis extends Axis {

    protected String timeUnit;
    protected Integer count;

    public DateAxis(Direction direction, AxisRenderer renderer, String timeUnit) {
        super(direction, renderer);
        this.timeUnit = timeUnit;
        this.count = 1;

        setTimeUnit(timeUnit);
    }

    public void setTimeUnit(String timeUnit) {
        set("baseInterval", new Document("timeUnit", timeUnit).append("count", count));
    }

    public void setCount(Integer count) {
        set("baseInterval", new Document("timeUnit", timeUnit).append("count", count));
    }

    @Override
    public String getType() {
        return "DateAxis";
    }
}
