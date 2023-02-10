package it.trekkete.amcharts;

import it.trekkete.amcharts.component.axis.Axis;
import it.trekkete.amcharts.component.axis.DateAxis;
import it.trekkete.amcharts.component.axis.ValueAxis;
import it.trekkete.amcharts.component.axis.renderer.AxisRendererX;
import it.trekkete.amcharts.component.axis.renderer.AxisRendererY;
import it.trekkete.amcharts.component.series.*;
import org.junit.Assert;
import org.junit.Test;

public class Am5SeriesTest {

    @Test
    public void testGetType() {

        Axis xAxis = new DateAxis(Axis.Direction.X, new AxisRendererX(), "week");
        Axis yAxis = new ValueAxis(Axis.Direction.Y, new AxisRendererY());

        Series columnSeries = new ColumnSeries(xAxis, yAxis);
        Series lineSeries = new LineSeries(xAxis, yAxis);
        Series stepLineSeries = new StepLineSeries(xAxis, yAxis);
        Series pieSeries = new PieSeries();

        Assert.assertEquals("ColumnSeries", columnSeries.getType());
        Assert.assertEquals("LineSeries", lineSeries.getType());
        Assert.assertEquals("StepLineSeries", stepLineSeries.getType());
        Assert.assertEquals("PieSeries", pieSeries.getType());
    }

    @Test
    public void testGetAxes() {

        Axis xAxis = new DateAxis(Axis.Direction.X, new AxisRendererX(), "week");
        Axis yAxis = new ValueAxis(Axis.Direction.Y, new AxisRendererY());

        XYSeries lineSeries = new LineSeries(xAxis, yAxis);

        Assert.assertEquals(xAxis, lineSeries.getxAxis());
        Assert.assertEquals(yAxis, lineSeries.getyAxis());

        Assert.assertTrue(lineSeries.render().contains("xAxis: " + xAxis.getEscapedName()));
        Assert.assertTrue(lineSeries.render().contains("yAxis: " + yAxis.getEscapedName()));

        Series columnSeries = new ColumnSeries(xAxis, yAxis);

        Assert.assertTrue(columnSeries.render().contains("xAxis: " + xAxis.getEscapedName()));
        Assert.assertTrue(columnSeries.render().contains("yAxis: " + yAxis.getEscapedName()));

        xAxis = new DateAxis(Axis.Direction.X, new AxisRendererX(), "week");
        yAxis = new ValueAxis(Axis.Direction.Y, new AxisRendererY());

        lineSeries.setxAxis(xAxis);
        lineSeries.setyAxis(yAxis);

        Assert.assertTrue(lineSeries.render().contains("xAxis: " + xAxis.getEscapedName()));
        Assert.assertTrue(lineSeries.render().contains("yAxis: " + yAxis.getEscapedName()));


    }

    @Test
    public void testSetValueField() {
        Axis xAxis = new DateAxis(Axis.Direction.X, new AxisRendererX(), "week");
        Axis yAxis = new ValueAxis(Axis.Direction.Y, new AxisRendererY());

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
        Axis xAxis = new DateAxis(Axis.Direction.X, new AxisRendererX(), "week");
        Axis yAxis = new ValueAxis(Axis.Direction.Y, new AxisRendererY());

        Series series = new LineSeries(xAxis, yAxis);

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

    @Test
    public void testPercentSeries() {

        PercentSeries series = new PieSeries("category", "value");

        Assert.assertEquals("category", series.getCategoryField());
        Assert.assertEquals("value", series.getValueField());

        series.setCategoryField("another");
        series.setValueField("eulav");

        Assert.assertEquals("another", series.getCategoryField());
        Assert.assertEquals("eulav", series.getValueField());

        series = new PictorialStackedSeries("category", "value", "M53.5,476c0,14,6.833,21,20.5");
        series.setDisplayName("TestName");
        String result =
                "var " + series.getEscapedName() + " = chart.series.push(\n" +
                        "  am5percent.PictorialStackedSeries.new(root, {\n" +
                        "    name: \"TestName\",\n" +
                        "    categoryField: \"category\",valueField: \"value\",svgPath: \"M53.5,476c0,14,6.833,21,20.5\"\n" +
                        "  })\n" +
                        ");\n" +
                        series.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, series.render());
    }

    @Test
    public void testFlowSeries() {

        FlowSeries flowSeries = new Chord();

        Assert.assertEquals("Chord", flowSeries.getType());

        flowSeries.setDisplayName("TestName");
        flowSeries.setSourceIdField("from");
        flowSeries.setTargetIdField("to");
        flowSeries.setValueField("value");

        Assert.assertEquals("from", flowSeries.getSourceIdField());
        Assert.assertEquals("to", flowSeries.getTargetIdField());
        Assert.assertEquals("value", flowSeries.getValueField());

        flowSeries = new ChordDirected("from", "to", "value");
        flowSeries.setDisplayName("TestName");

        String result =
                "var " + flowSeries.getEscapedName() + " = chart.series.push(\n" +
                "  am5flow.ChordDirected.new(root, {\n" +
                "    name: \"TestName\",\n" +
                "    sourceIdField: \"from\",targetIdField: \"to\",valueField: \"value\"\n" +
                "  })\n" +
                ");\n" +
                flowSeries.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, flowSeries.render());

        ChordNonRibbon another = new ChordNonRibbon("from", "to", "value");
        another.setLinkType("curve");
        another.setDisplayName("TestName");

        result =
                "var " + another.getEscapedName() + " = chart.series.push(\n" +
                        "  am5flow.ChordNonRibbon.new(root, {\n" +
                        "    name: \"TestName\",\n" +
                        "    sourceIdField: \"from\",targetIdField: \"to\",valueField: \"value\",linkType: \"curve\"\n" +
                        "  })\n" +
                        ");\n" +
                        another.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, another.render());
    }
}
