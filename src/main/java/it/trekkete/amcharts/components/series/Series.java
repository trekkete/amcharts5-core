package it.trekkete.amcharts.components.series;

import it.trekkete.amcharts.Am5Component;
import it.trekkete.amcharts.components.axis.Axis;

import java.util.UUID;

public abstract class Series implements Am5Component {

    protected String baseJs =
            "var [[SERIES_NAME]] = chart.series.push(\n" +
            "  am5xy.[[SERIES_CLASS_NAME]].new(root, {\n" +
            "    name: \"[[SERIES_NAME]]\",\n" +
            "    xAxis: [[SERIES_X_AXIS]],\n" +
            "    yAxis: [[SERIES_Y_AXIS]],\n" +
            "    valueYField: \"[[SERIES_Y_VALUE_FIELD]]\",\n" +
            "    valueXField: \"[[SERIES_X_VALUE_FIELD]]\"\n" +
            "  })\n" +
            ");\n" +
            "[[SERIES_NAME]].data.setAll(data);";

    protected UUID id;

    protected String name;
    protected Axis xAxis;
    protected Axis yAxis;
    protected String valueXField;
    protected String valueYField;

    public Series() {
        this.id = UUID.randomUUID();
        this.name = "series_" + id;
    }
}
