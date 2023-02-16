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

    protected List<Am5Component> components;
    protected String data;
    protected String themes;

    private String extra;

    public Am5Chart() {
        super();

        this.id = UUID.randomUUID();
        this.name = "chart_" + id;
        this.components = new ArrayList<>();
        this.data = "[]";
        this.themes = "";
        this.extra = "";

        this.baseJs =
                """
                var root = am5.Root.new("[[AM5_CHART_DIV_ID]]");
                var chart = root.container.children.push(
                  [[AM5_COMPONENT_LIBRARY]].[[AM5_CHART_TYPE]].new(root, {
                    [[AM5_COMPONENT_PROPERTIES]]
                  })
                );
                
                var data = [[AM5_CHART_DATA]];
                
                [[AM5_THEMES]]
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

    public void setThemes(String... themes) {

        StringBuilder sb = new StringBuilder("root.setThemes([");
        for (String theme : themes) {
            sb.append("am5themes_").append(theme).append(".new(root),");
        }
        sb.deleteCharAt(sb.length() - 1).append("]);");

        this.themes = sb.toString();
    }

    public void setData(List<Am5DataItem> data) {
        this.data = new Gson().toJson(data);
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

        StringBuilder total = new StringBuilder(super.render()
                .replace("[[AM5_CHART_DIV_ID]]", getEscapedName())
                .replace("[[AM5_CHART_TYPE]]", getType())
                .replace("[[AM5_CHART_DATA]]", this.data)
                .replace("[[AM5_THEMES]]", this.themes));

        for (Am5Component component : components) {
            total.append(component.render());

            if (component.getTemplate().size() > 0) {
                component.getTemplate().forEach((key, value) -> {
                    total.append(component.getEscapedName()).append(".").append(key).append(".setAll({");

                    value.forEach(property -> {
                        total.append(property.render());
                    });

                    total.append("});");
                });
            }
        }

        total.append(extra);

        return total.toString();
    }

    public void raw(String rawJs) {
        this.extra += rawJs;
    }
}
