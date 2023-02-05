package it.trekkete.amcharts.components.series;

public class ColumnSeries extends Series{

    public String render() {

        return baseJs
                .replace("[[SERIES_CLASS_NAME]]", this.getClass().getSimpleName())
                .replace("[[SERIES_NAME]]", name)
                .replace("[[SERIES_X_AXIS]]", xAxis.getName())
                .replace("[[SERIES_Y_AXIS]]", yAxis.getName())
                .replace("[[SERIES_X_VALUE_FIELD]]", valueXField)
                .replace("[[SERIES_Y_VALUE_FIELD]]", valueYField);
    }
}
