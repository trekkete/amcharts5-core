package it.trekkete.amcharts.charts;

import it.trekkete.amcharts.Am5Chart;
import it.trekkete.amcharts.components.axis.Axis;
import it.trekkete.amcharts.components.axis.AxisRenderer;
import it.trekkete.amcharts.components.axis.CategoryAxis;
import it.trekkete.amcharts.components.axis.ValueAxis;
import it.trekkete.amcharts.components.controls.Legend;
import it.trekkete.amcharts.components.controls.XYCursor;
import it.trekkete.amcharts.components.series.ColumnSeries;

public class Am5BarChart extends Am5Chart {

    public Am5BarChart() {
        super();

        AxisRenderer yAxisRenderer = new AxisRenderer(Axis.Direction.Y);
        ValueAxis yAxis = new ValueAxis(Axis.Direction.Y, yAxisRenderer);
        this.add(yAxisRenderer, yAxis);

        AxisRenderer xAxisRenderer = new AxisRenderer(Axis.Direction.X);
        CategoryAxis xAxis = new CategoryAxis(Axis.Direction.X, xAxisRenderer, "category");
        this.add(xAxisRenderer, xAxis);

        ColumnSeries series = new ColumnSeries();
        series.setxAxis(xAxis);
        series.setyAxis(yAxis);
        series.set("categoryXField", "category");
        series.set("valueYField", "value");

        this.add(series);

        this.add(new Legend());
        this.add(new XYCursor());
    }

    @Override
    public String getType() {
        return "XYChart";
    }
}
