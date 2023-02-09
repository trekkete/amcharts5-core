package it.trekkete.amcharts;

import it.trekkete.amcharts.components.Am5Property;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

public class Am5PropertyTest {

    @Test
    public void testGetKey() {

        Am5Property property = new Am5Property("key", "value", false);

        Assert.assertEquals("key", property.getKey());
    }

    @Test
    public void testGetValue() {

        Am5Property property = new Am5Property("key", "value", false);

        Assert.assertEquals("value", property.getValue());
    }

    @Test
    public void testRenderNonAtomString() {

        Am5Property property = new Am5Property("key", "value", false);

        Assert.assertEquals("key: \"value\"", property.render());
    }

    @Test
    public void testRenderAtomString() {

        Am5Property property = new Am5Property("key", "value", true);

        Assert.assertEquals("key: value", property.render());
    }

    @Test
    public void testRenderPrimitive() {

        Am5Property property = new Am5Property("key", 5, false);

        Assert.assertEquals("key: 5", property.render());
    }

    @Test
    public void testRenderJson() {

        Document testDocument = new Document("foo", "bar");

        Am5Property property = new Am5Property("key", testDocument, false);

        Assert.assertEquals("key: {\"foo\":\"bar\"}", property.render());
    }
}
