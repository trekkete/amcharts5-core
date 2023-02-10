package it.trekkete.amcharts.component.control;

import it.trekkete.amcharts.Am5;
import it.trekkete.amcharts.component.Am5Component;

import java.util.UUID;

public class Legend extends Am5Component {

    public Legend() {
        super();

        this.id = UUID.randomUUID();
        this.name = "legend_" + id;

        this.baseJs =
                """
                var [[LEGEND_NAME]] = chart.children.push(am5.Legend.new(root, {
                  [[AM5_COMPONENT_PROPERTIES]]
                }));
                [[LEGEND_NAME]].data.setAll(chart.series.values);""";
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.COMMON;
    }

    public String render() {
        return super.render()
                .replace("[[LEGEND_NAME]]", getEscapedName());
    }
}
