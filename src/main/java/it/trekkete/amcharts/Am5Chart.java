package it.trekkete.amcharts;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Am5Chart implements Am5Component{

    protected String baseJs =
            "var root = am5.Root.new(\"[[CHART_DIV_ID]]\");\n" +
            "var chart = root.container.children.push(\n" +
            "  am5xy.[[CHART_TYPE]].new(root, {})\n" +
            ");";

    protected List<Am5Component> components;

    protected String id;
    protected String type;

    protected String data;

    public Am5Chart() {
        this.id = "chart_" + UUID.randomUUID();
        this.components = new ArrayList<Am5Component>();
    }

    public void add(Am5Component component) {
        components.add(component);
    }

    public void remove(Am5Component component) {
        components.remove(component);
    }

    public void add(Am5Component... components) {
        this.components.addAll(List.of(components));
    }

    public List<Am5Component> getComponents() {
        return components;
    }

    public String render() {

        String total = baseJs
                .replace("[[CHART_DIV_ID]]", this.id)
                .replace("[[CHART_TYPE]]", this.type);

        for (Am5Component component : components) {
            total += component.render();
        }

        return total;
    }
}
