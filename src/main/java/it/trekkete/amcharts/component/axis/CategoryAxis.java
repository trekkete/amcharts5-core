package it.trekkete.amcharts.component.axis;

import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;

public class CategoryAxis extends Axis {

    private String categoryField;

    public CategoryAxis(Direction direction, AxisRenderer renderer, String categoryField) {
        super(direction, renderer);
        this.categoryField = categoryField;

        set("categoryField", categoryField);
    }

    @Override
    public String getType() {
        return "CategoryAxis";
    }

    public String render() {
        return super.render();
    }
}
