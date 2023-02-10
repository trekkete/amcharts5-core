package it.trekkete.amcharts.component.data;

import org.bson.Document;

public class Am5DataItem extends Document {

    public Am5DataItem(String key, Object value) {
        super(key, value);
    }

    public Am5DataItem append(String key, Object value) {
        return (Am5DataItem) super.append(key, value);
    }
}
