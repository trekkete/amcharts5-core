package it.trekkete.amcharts.component.series;

import it.trekkete.amcharts.component.Am5Component;
import it.trekkete.amcharts.component.Am5Property;
import it.trekkete.amcharts.component.axis.Axis;

import java.util.List;
import java.util.UUID;

public abstract class Series extends Am5Component {

    protected String displayName;

    public Series() {
        super();
        this.id = UUID.randomUUID();
        this.name = "series_" + id;
        this.displayName = this.name;

        this.baseJs =
                """
                var [[SERIES_NAME]] = chart.series.push(
                  [[AM5_COMPONENT_LIBRARY]].[[SERIES_CLASS_NAME]].new(root, {
                    name: "[[SERIES_DISPLAY_NAME]]",
                    [[AM5_COMPONENT_PROPERTIES]]
                  })
                );
                [[SERIES_NAME]].data.setAll(data);""";
    }

    public abstract String getType();

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
                .replace("[[SERIES_NAME]]", getEscapedName())
                .replace("[[SERIES_DISPLAY_NAME]]", getDisplayName());
    }
}
