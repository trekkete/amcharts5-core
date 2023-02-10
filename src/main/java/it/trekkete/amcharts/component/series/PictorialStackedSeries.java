package it.trekkete.amcharts.component.series;

public class PictorialStackedSeries extends PercentSeries{

    private String svgPath;

    public PictorialStackedSeries() {
    }

    public PictorialStackedSeries(String categoryField, String valueField, String svgPath) {
        super(categoryField, valueField);

        setSvgPath(svgPath);
    }

    public String getSvgPath() {
        return svgPath;
    }

    public void setSvgPath(String svgPath) {
        this.svgPath = svgPath;

        set("svgPath", svgPath);
    }

    @Override
    public String getType() {
        return "PictorialStackedSeries";
    }
}
