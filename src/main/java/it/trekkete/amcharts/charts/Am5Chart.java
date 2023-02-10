package it.trekkete.amcharts.charts;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.trekkete.amcharts.component.Am5Component;
import it.trekkete.amcharts.component.Am5Renderable;
import it.trekkete.amcharts.component.data.Am5DataItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Am5Chart extends Am5Component {

    protected List<Am5Renderable> components;
    protected String data;

    public Am5Chart() {
        super();

        this.id = UUID.randomUUID();
        this.name = "chart_" + id;
        this.components = new ArrayList<>();

        this.baseJs =
                """
                var root = am5.Root.new("[[AM5_CHART_DIV_ID]]");
                var chart = root.container.children.push(
                  [[AM5_COMPONENT_LIBRARY]].[[AM5_CHART_TYPE]].new(root, {
                    [[AM5_COMPONENT_PROPERTIES]]
                  })
                );
                
                var data = [[AM5_CHART_DATA]];
                """;
    }

    public abstract String getType();

    public String getData() {
        return this.data;
    }

    public List<Am5DataItem> getStructuredData() {

        if (this.data == null)
            return null;

        return new Gson().fromJson(this.data, new TypeToken<List<Am5DataItem>>(){}.getType());
    }

    public void setData(List<Am5DataItem> data) {
        this.data = new Gson().toJson(data);
    }

    public void add(Am5Renderable component) {
        components.add(component);
    }

    public void remove(Am5Renderable component) {
        components.remove(component);
    }

    public void add(Am5Renderable... components) {
        this.components.addAll(List.of(components));
    }

    public List<Am5Renderable> getComponents() {
        return components;
    }

    public String render() {

        String total = super.render()
                .replace("[[AM5_CHART_DIV_ID]]", getEscapedName())
                .replace("[[AM5_CHART_TYPE]]", getType())
                .replace("[[AM5_CHART_DATA]]", this.data);

        for (Am5Renderable component : components) {
            total += component.render();
        }

        return total;
    }

    public void raw(String rawJs) {
        this.baseJs += rawJs;
    }
}
