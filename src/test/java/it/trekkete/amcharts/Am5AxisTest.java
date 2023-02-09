package it.trekkete.amcharts;

import it.trekkete.amcharts.components.axis.*;
import org.junit.Assert;
import org.junit.Test;

public class Am5AxisTest {

    @Test
    public void testRendererGetDirection() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.Y);

        Assert.assertEquals(Axis.Direction.Y, axisRenderer.getDirection());
    }

    @Test
    public void testRendererRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.Y);

        String name = axisRenderer.getEscapedName();

        String result = "var " + name + " = am5xy.AxisRendererY.new(root, {\n" +
                "  \n" +
                "});\n";

        Assert.assertEquals(result, axisRenderer.render());
    }

    @Test
    public void testAxisGetType() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.Y);

        Axis axis = new Axis(axisRenderer) {
            @Override
            public String getType() {
                return "DateAxis";
            }
        };

        Axis dateAxis = new DateAxis(axisRenderer, "week");
        Axis categoryAxis = new CategoryAxis(axisRenderer, "category");
        Axis categoryDateAxis = new CategoryDateAxis(axisRenderer, "category");
        Axis valueAxis = new ValueAxis(axisRenderer);
        Axis durationAxis = new DurationAxis(axisRenderer);
        Axis gaplessDateAxis = new GaplessDateAxis(axisRenderer, "hour");

        Assert.assertEquals("DateAxis", axis.getType());
        Assert.assertEquals("DateAxis", dateAxis.getType());
        Assert.assertEquals("CategoryAxis", categoryAxis.getType());
        Assert.assertEquals("CategoryDateAxis", categoryDateAxis.getType());
        Assert.assertEquals("ValueAxis", valueAxis.getType());
        Assert.assertEquals("DurationAxis", durationAxis.getType());
        Assert.assertEquals("GaplessDateAxis", gaplessDateAxis.getType());

    }

    @Test
    public void testAxisGetDirection() {

        AxisRenderer yAxisRenderer = new AxisRenderer(Axis.Direction.Y);
        AxisRenderer xAxisRenderer = new AxisRenderer(Axis.Direction.X);

        Axis axis = new Axis(yAxisRenderer) {
            @Override
            public String getType() {
                return "DateAxis";
            }
        };

        Axis dateAxis = new DateAxis(xAxisRenderer, "week");

        Assert.assertEquals(Axis.Direction.Y, axis.getDirection());
        Assert.assertEquals(Axis.Direction.X, dateAxis.getDirection());

    }

    @Test
    public void testDateAxisOnXAxesRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.X);
        Axis dateAxis = new DateAxis(axisRenderer, "week");

        String result = "var " + dateAxis.getEscapedName() + " = chart.xAxes.push(\n" +
                "  am5xy.DateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    baseInterval: {\"timeUnit\":\"week\",\"count\":1}\n" +
                "  })\n" +
                ");" + dateAxis.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, dateAxis.render());
    }

    @Test
    public void testDateAxisOnYAxesRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.Y);
        Axis dateAxis = new DateAxis(axisRenderer, "week");

        String result = "var " + dateAxis.getEscapedName() + " = chart.yAxes.push(\n" +
                "  am5xy.DateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    baseInterval: {\"timeUnit\":\"week\",\"count\":1}\n" +
                "  })\n" +
                ");";

        Assert.assertEquals(result, dateAxis.render());
    }

    @Test
    public void testDateAxisTimeUnitRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.Y);
        DateAxis dateAxis = new DateAxis(axisRenderer, "week");

        String result = "var " + dateAxis.getEscapedName() + " = chart.yAxes.push(\n" +
                "  am5xy.DateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    baseInterval: {\"timeUnit\":\"week\",\"count\":1}\n" +
                "  })\n" +
                ");";

        Assert.assertEquals(result, dateAxis.render());

        dateAxis.setTimeUnit("day");

        result = "var " + dateAxis.getEscapedName() + " = chart.yAxes.push(\n" +
                "  am5xy.DateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    baseInterval: {\"timeUnit\":\"day\",\"count\":1}\n" +
                "  })\n" +
                ");";

        Assert.assertEquals(result, dateAxis.render());
    }

    @Test
    public void testDateAxisCountRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.Y);
        DateAxis dateAxis = new DateAxis(axisRenderer, "week");

        String result = "var " + dateAxis.getEscapedName() + " = chart.yAxes.push(\n" +
                "  am5xy.DateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    baseInterval: {\"timeUnit\":\"week\",\"count\":1}\n" +
                "  })\n" +
                ");";

        Assert.assertEquals(result, dateAxis.render());

        dateAxis.setCount(5);

        result = "var " + dateAxis.getEscapedName() + " = chart.yAxes.push(\n" +
                "  am5xy.DateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    baseInterval: {\"timeUnit\":\"week\",\"count\":5}\n" +
                "  })\n" +
                ");";

        Assert.assertEquals(result, dateAxis.render());
    }

    @Test
    public void testCategoryAxisRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.X);
        CategoryAxis categoryAxis = new CategoryAxis(axisRenderer, "category");

        String result = "var " + categoryAxis.getEscapedName() + " = chart.xAxes.push(\n" +
                "  am5xy.CategoryAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    categoryField: \"category\"\n" +
                "  })\n" +
                ");" + categoryAxis.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, categoryAxis.render());
    }

    @Test
    public void testCategoryDateAxisRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.X);
        CategoryDateAxis categoryDateAxis = new CategoryDateAxis(axisRenderer, "category");

        String result = "var " + categoryDateAxis.getEscapedName() + " = chart.xAxes.push(\n" +
                "  am5xy.CategoryDateAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    categoryField: \"category\",baseInterval: {\"timeUnit\":\"day\",\"count\":1}\n" +
                "  })\n" +
                ");" + categoryDateAxis.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, categoryDateAxis.render());
    }

    @Test
    public void testValueAxisRender() {

        AxisRenderer axisRenderer = new AxisRenderer(Axis.Direction.X);
        ValueAxis valueAxis = new ValueAxis(axisRenderer);

        String result = "var " + valueAxis.getEscapedName() + " = chart.xAxes.push(\n" +
                "  am5xy.ValueAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    \n" +
                "  })\n" +
                ");" + valueAxis.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, valueAxis.render());
    }
}
