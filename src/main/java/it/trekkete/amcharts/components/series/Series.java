package it.trekkete.amcharts.components.series;

import it.trekkete.amcharts.components.Am5Component;
import it.trekkete.amcharts.components.Am5Property;
import it.trekkete.amcharts.components.axis.Axis;

import java.util.List;
import java.util.UUID;

public abstract class Series extends Am5Component {

    protected Axis xAxis;
    protected Axis yAxis;
    protected List<Am5Property> properties;
    protected String displayName;

    public Series() {
        super();

        this.id = UUID.randomUUID();
        this.name = "series_" + id;

        this.baseJs =
                """
                var [[SERIES_NAME]] = chart.series.push(
                  am5xy.[[SERIES_CLASS_NAME]].new(root, {
                    name: "[[SERIES_DISPLAY_NAME]]",
                    xAxis: [[SERIES_X_AXIS]],
                    yAxis: [[SERIES_Y_AXIS]],
                    [[AM5_COMPONENT_PROPERTIES]]
                  })
                );
                [[SERIES_NAME]].data.setAll(data);
                """;
    }

    public abstract String getType();

    public Axis getxAxis() {
        return xAxis;
    }

    public void setxAxis(Axis xAxis) {
        this.xAxis = xAxis;
    }

    public Axis getyAxis() {
        return yAxis;
    }

    public void setyAxis(Axis yAxis) {
        this.yAxis = yAxis;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String render() {

        return super.render()
                .replace("[[SERIES_CLASS_NAME]]", getType())
                .replace("[[SERIES_NAME]]", getName())
                .replace("[[SERIES_DISPLAY_NAME]]", getDisplayName())
                .replace("[[SERIES_X_AXIS]]", xAxis.getName())
                .replace("[[SERIES_Y_AXIS]]", yAxis.getName());
    }
}
