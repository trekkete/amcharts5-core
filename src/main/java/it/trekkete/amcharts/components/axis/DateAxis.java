package it.trekkete.amcharts.components.axis;

import com.google.gson.Gson;
import org.bson.Document;

public class DateAxis extends Axis {

    private String timeUnit;
    private Integer count;

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
