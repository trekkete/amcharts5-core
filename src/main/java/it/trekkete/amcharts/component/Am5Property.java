package it.trekkete.amcharts.component;

import com.google.gson.Gson;
import org.bson.Document;

public class Am5Property implements Am5Renderable {

    private final String key;
    private final Object value;

    private final boolean atom;

    public Am5Property(String key, Object value, boolean atom) {
        this.key = key;
        this.value = value;
        this.atom = atom;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String render() {
        String temp = key + ": ";

        if (value instanceof String) {
            if (atom) {
                temp += value;
            }
            else {
                temp += "\"" + value + "\"";
            }
        }
        else if (value instanceof Document) {
            temp += new Gson().toJson(value);
        }
        else {
            temp += value;
        }

        return temp;
    }
}
