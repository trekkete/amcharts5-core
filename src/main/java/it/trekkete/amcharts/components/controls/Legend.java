package it.trekkete.amcharts.components.controls;

import it.trekkete.amcharts.components.Am5Component;

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
                [[LEGEND_NAME]].data.setAll(chart.series.values);
                """;
    }

    public String render() {
        return super.render()
                .replace("[[LEGEND_NAME]]", getName());
    }
}
