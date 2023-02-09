package it.trekkete.amcharts.components.controls;

import it.trekkete.amcharts.components.Am5Component;

import java.util.UUID;

public class Scrollbar extends Am5Component {

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    private Orientation orientation;
    private String type;

    public Scrollbar(Orientation orientation) {
        super();

        this.id = UUID.randomUUID();
        this.name = "legend_" + id;

        this.baseJs = """
                var [[SCROLLBAR_NAME]] = am5.[[SCROLLBAR_TYPE]].new(root, {
                  orientation: "[[SCROLLBAR_ORIENTATION]]",
                  [[AM5_COMPONENT_PROPERTIES]]
                });""";
    }

    public String getType() {
        return type;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String render() {
        return super.render()
                .replace("[[SCROLLBAR_NAME]]", getEscapedName())
                .replace("[[SCROLLBAR_TYPE]]", getType())
                .replace("[[SCROLLBAR_ORIENTATION]]", getOrientation().name().toLowerCase());
    }
}
