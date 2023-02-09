package it.trekkete.amcharts;

import it.trekkete.amcharts.components.axis.Axis;
import it.trekkete.amcharts.components.axis.AxisRenderer;
import it.trekkete.amcharts.components.axis.DateAxis;
import it.trekkete.amcharts.components.axis.ValueAxis;
import it.trekkete.amcharts.components.series.*;
import org.junit.Assert;
import org.junit.Test;

public class Am5SeriesTest {

    @Test
    public void testGetType() {

        Series columnSeries = new ColumnSeries();
        Series lineSeries = new LineSeries();
        Series stepLineSeries = new StepLineSeries();
        Series pieSeries = new PieSeries();

        Assert.assertEquals("ColumnSeries", columnSeries.getType());
        Assert.assertEquals("LineSeries", lineSeries.getType());
        Assert.assertEquals("StepLineSeries", stepLineSeries.getType());
        Assert.assertEquals("PieSeries", pieSeries.getType());
    }

    @Test
    public void testGetAxes() {

        Axis xAxis = new DateAxis(new AxisRenderer(Axis.Direction.X), "week");
        Axis yAxis = new ValueAxis(new AxisRenderer(Axis.Direction.Y));

        Series lineSeries = new LineSeries();

        Assert.assertNull(lineSeries.getxAxis());
        Assert.assertNull(lineSeries.getyAxis());

        lineSeries.setxAxis(xAxis);
        lineSeries.setyAxis(yAxis);

        Assert.assertEquals(xAxis, lineSeries.getxAxis());
        Assert.assertEquals(yAxis, lineSeries.getyAxis());

        Assert.assertTrue(lineSeries.render().contains("xAxis: " + xAxis.getEscapedName()));
        Assert.assertTrue(lineSeries.render().contains("yAxis: " + yAxis.getEscapedName()));

        lineSeries = new LineSeries(xAxis, yAxis);

        Assert.assertTrue(lineSeries.render().contains("xAxis: " + xAxis.getEscapedName()));
        Assert.assertTrue(lineSeries.render().contains("yAxis: " + yAxis.getEscapedName()));

        Series columnSeries = new ColumnSeries(xAxis, yAxis);

        Assert.assertTrue(columnSeries.render().contains("xAxis: " + xAxis.getEscapedName()));
        Assert.assertTrue(columnSeries.render().contains("yAxis: " + yAxis.getEscapedName()));
    }

    @Test
    public void testSetValueField() {
        Axis xAxis = new DateAxis(new AxisRenderer(Axis.Direction.X), "week");
        Axis yAxis = new ValueAxis(new AxisRenderer(Axis.Direction.Y));
        LineSeries lineSeries = new LineSeries(xAxis, yAxis);

        lineSeries.setValueXField("date");
        lineSeries.setValueYField("value");

        Assert.assertTrue(lineSeries.render().contains("valueXField: \"date\""));
        Assert.assertTrue(lineSeries.render().contains("valueYField: \"value\""));

        LineSeries stepLineSeries = new StepLineSeries(xAxis, yAxis);

        stepLineSeries.setValueXField("date");
        stepLineSeries.setValueYField("value");

        Assert.assertTrue(stepLineSeries.render().contains("valueXField: \"date\""));
        Assert.assertTrue(stepLineSeries.render().contains("valueYField: \"value\""));

        Assert.assertEquals("date", stepLineSeries.get("valueXField"));
        Assert.assertEquals("value", stepLineSeries.get("valueYField"));
        Assert.assertNull(stepLineSeries.get("absentKey"));
    }

    @Test
    public void testDisplayName() {
        Series series = new LineSeries();

        Assert.assertEquals(series.getName(), series.getDisplayName());

        series.setDisplayName("testDisplayName");

        Assert.assertEquals("testDisplayName", series.getDisplayName());
    }

    @Test
    public void testPieSeries() {

        PieSeries pieSeries = new PieSeries();

        Assert.assertNull(pieSeries.get("categoryField"));
        Assert.assertNull(pieSeries.get("valueField"));

        pieSeries.setCategoryField("category");
        pieSeries.setValueField("value");

        Assert.assertEquals("category", pieSeries.get("categoryField"));
        Assert.assertEquals("value", pieSeries.get("valueField"));

        pieSeries = new PieSeries("category", "value");

        Assert.assertEquals("category", pieSeries.get("categoryField"));
        Assert.assertEquals("value", pieSeries.get("valueField"));
    }
}
