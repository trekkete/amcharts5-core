package it.trekkete.amcharts.components.controls;

import it.trekkete.amcharts.Am5Component;

import java.util.UUID;

public class Legend implements Am5Component {

    private String baseJs =
            "var [[LEGEND_NAME]] = chart.children.push(am5.Legend.new(root, {}));\n" +
                    "[[LEGEND_NAME]].data.setAll(chart.series.values);";

    private UUID id;
    private String name;

    public Legend() {
        this.id = UUID.randomUUID();
        this.name = "legend_" + id;
    }

    public String render() {
        return baseJs
                .replace("[[LEGEND_NAME]]", name);
    }
}
