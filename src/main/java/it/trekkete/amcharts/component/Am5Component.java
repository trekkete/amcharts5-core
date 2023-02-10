package it.trekkete.amcharts.component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Am5Component implements Am5Renderable{

    protected String name;
    protected UUID id;
    protected String baseJs;

    protected List<Am5Property> properties;

    public Am5Component() {
        this.properties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEscapedName() {
        return name.replace("-", "_");
    }

    public void set(String name, Object value, boolean atom) {

        boolean found = false;
        for (int i = 0; i < this.properties.size(); i++) {
            if (this.properties.get(i).getKey().equals(name)) {
                found = true;

                this.properties.set(i, new Am5Property(name, value, atom));
            }
        }

        if (!found)
            this.properties.add(new Am5Property(name, value, atom));
    }

    public void set(String name, Object value) {
        set(name, value, false);
    }

    public Object get(String name) {

        for (Am5Property property : this.properties) {
            if (property.getKey().equals(name)) {
                return property.getValue();
            }
        }

        return null;
    }

    protected abstract String getLibrary();

    @Override
    public String render() {
        return baseJs
                .replace("[[AM5_COMPONENT_LIBRARY]]", getLibrary())
                .replace("[[AM5_COMPONENT_PROPERTIES]]", String.join(",", this.properties.stream().map(Am5Property::render).toList()));
    }
}
