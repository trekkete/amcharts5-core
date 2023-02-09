package it.trekkete.amcharts.components.axis;

import org.bson.Document;

public class CategoryDateAxis extends CategoryAxis{

    public CategoryDateAxis(AxisRenderer renderer, String categoryField) {
        super(renderer, categoryField);

        setBaseInterval("day", 1);
    }

    public void setBaseInterval(String timeUnit, int count) {
        set("baseInterval", new Document("timeUnit", timeUnit).append("count", count));
    }

    @Override
    public String getType() {
        return "CategoryDateAxis";
    }
}
