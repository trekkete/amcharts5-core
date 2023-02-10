package it.trekkete.amcharts;

import it.trekkete.amcharts.charts.Am5Chart;
import it.trekkete.amcharts.charts.Am5PieChart;
import it.trekkete.amcharts.charts.Am5XYChart;
import it.trekkete.amcharts.component.control.cursor.Cursor;
import it.trekkete.amcharts.component.control.Legend;
import it.trekkete.amcharts.component.control.Scrollbar;
import it.trekkete.amcharts.component.control.cursor.XYCursor;
import it.trekkete.amcharts.component.data.Am5DataItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Am5ChartsTest {

    @Test
    public void testGetType() {

        Am5Chart custom = new Am5Chart() {
            @Override
            protected String getLibrary() {
                return Am5.Library.RADAR;
            }

            @Override
            public String getType() {
                return "RadarChart";
            }
        };

        Am5Chart xyChart = new Am5XYChart();
        Am5Chart pieChart = new Am5PieChart();

        Assert.assertEquals("XYChart", xyChart.getType());
        Assert.assertEquals("PieChart", pieChart.getType());
        Assert.assertEquals("RadarChart", custom.getType());
    }

    @Test
    public void testComponents() {

        Am5Chart chart = new Am5XYChart();

        Legend legend = new Legend();
        Scrollbar scrollbar = new Scrollbar(Scrollbar.Orientation.HORIZONTAL);
        Cursor cursor = new XYCursor();

        chart.add(legend);

        Assert.assertTrue(chart.getComponents().contains(legend));

        chart.remove(legend);

        Assert.assertTrue(chart.getComponents().isEmpty());

        chart.add(scrollbar, cursor);

        Assert.assertEquals(2, chart.getComponents().size());
    }

    @Test
    public void testSetData() {

        Am5Chart chart = new Am5XYChart();

        List<Am5DataItem> dataItems = new ArrayList<>();
        dataItems.add(new Am5DataItem("category", "Italy").append("value", 5));

        Assert.assertNull(chart.getData());

        chart.setData(dataItems);

        Assert.assertEquals("[{\"category\":\"Italy\",\"value\":5}]", chart.getData());
    }
}
