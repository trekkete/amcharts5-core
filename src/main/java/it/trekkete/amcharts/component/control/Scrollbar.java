package it.trekkete.amcharts.component.control;

import it.trekkete.amcharts.Am5;
import it.trekkete.amcharts.component.Am5Component;

import java.util.UUID;

public class Scrollbar extends Am5Component {

    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    private Orientation orientation;

    public Scrollbar(Orientation orientation) {
        super();

        this.id = UUID.randomUUID();
        this.name = "scrollbar_" + id;
        this.orientation = orientation;

        this.baseJs = """
                var [[SCROLLBAR_NAME]] = [[AM5_COMPONENT_LIBRARY]].[[SCROLLBAR_TYPE]].new(root, {
                  orientation: "[[SCROLLBAR_ORIENTATION]]",
                  [[AM5_COMPONENT_PROPERTIES]]
                });""";
    }

    public String getType() {
        return "Scrollbar";
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    protected String getLibrary() {
        return Am5.Library.COMMON;
    }

    @Override
    public String render() {
        return super.render()
                .replace("[[SCROLLBAR_NAME]]", getEscapedName())
                .replace("[[SCROLLBAR_TYPE]]", getType())
                .replace("[[SCROLLBAR_ORIENTATION]]", getOrientation().name().toLowerCase());
    }
}
