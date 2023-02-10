package it.trekkete.amcharts;

import it.trekkete.amcharts.component.axis.*;
import it.trekkete.amcharts.component.axis.renderer.AxisRenderer;
import it.trekkete.amcharts.component.axis.renderer.AxisRendererX;
import it.trekkete.amcharts.component.axis.renderer.AxisRendererY;
import org.junit.Assert;
import org.junit.Test;

public class Am5AxisTest {

    @Test
    public void testRendererRender() {

        AxisRenderer axisRenderer = new AxisRendererY();

        String name = axisRenderer.getEscapedName();

        String result = "var " + name + " = am5xy.AxisRendererY.new(root, {\n" +
                "  \n" +
                "});\n";

        Assert.assertEquals(result, axisRenderer.render());
    }

    @Test
    public void testAxisGetType() {

        AxisRenderer axisRenderer = new AxisRendererY();

        Axis axis = new Axis(Axis.Direction.X, axisRenderer) {
            @Override
            public String getType() {
                return "DateAxis";
            }
        };

        Axis dateAxis = new DateAxis(Axis.Direction.X, axisRenderer, "week");
        Axis categoryAxis = new CategoryAxis(Axis.Direction.X, axisRenderer, "category");
        Axis categoryDateAxis = new CategoryDateAxis(Axis.Direction.X, axisRenderer, "category");
        Axis valueAxis = new ValueAxis(Axis.Direction.X, axisRenderer);
        Axis durationAxis = new DurationAxis(Axis.Direction.X, axisRenderer);
        Axis gaplessDateAxis = new GaplessDateAxis(Axis.Direction.X, axisRenderer, "hour");

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

        AxisRenderer yAxisRenderer = new AxisRendererY();
        AxisRenderer xAxisRenderer = new AxisRendererX();

        Axis axis = new Axis(Axis.Direction.Y, yAxisRenderer) {
            @Override
            public String getType() {
                return "DateAxis";
            }
        };

        Axis dateAxis = new DateAxis(Axis.Direction.X, xAxisRenderer, "week");

        Assert.assertEquals(Axis.Direction.Y, axis.getDirection());
        Assert.assertEquals(Axis.Direction.X, dateAxis.getDirection());

    }

    @Test
    public void testDateAxisOnXAxesRender() {

        AxisRenderer axisRenderer = new AxisRendererX();
        Axis dateAxis = new DateAxis(Axis.Direction.X, axisRenderer, "week");

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

        AxisRenderer axisRenderer = new AxisRendererY();
        Axis dateAxis = new DateAxis(Axis.Direction.Y, axisRenderer, "week");

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

        AxisRenderer axisRenderer = new AxisRendererY();
        DateAxis dateAxis = new DateAxis(Axis.Direction.Y, axisRenderer, "week");

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

        AxisRenderer axisRenderer = new AxisRendererY();
        DateAxis dateAxis = new DateAxis(Axis.Direction.Y, axisRenderer, "week");

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

        AxisRenderer axisRenderer = new AxisRendererX();
        CategoryAxis categoryAxis = new CategoryAxis(Axis.Direction.X, axisRenderer, "category");

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

        AxisRenderer axisRenderer = new AxisRendererX();
        CategoryDateAxis categoryDateAxis = new CategoryDateAxis(Axis.Direction.X, axisRenderer, "category");

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

        AxisRenderer axisRenderer = new AxisRendererX();
        ValueAxis valueAxis = new ValueAxis(Axis.Direction.X, axisRenderer);

        String result = "var " + valueAxis.getEscapedName() + " = chart.xAxes.push(\n" +
                "  am5xy.ValueAxis.new(root, {\n" +
                "    renderer: " + axisRenderer.getEscapedName() + ",\n" +
                "    \n" +
                "  })\n" +
                ");" + valueAxis.getEscapedName() + ".data.setAll(data);";

        Assert.assertEquals(result, valueAxis.render());
    }
}
