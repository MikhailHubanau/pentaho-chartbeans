package org.pentaho.chart.model;

import java.io.Serializable;

public class BarPlot extends TwoAxisPlot implements Serializable {
  private static final float DEFAULT_OPACITY = 0.85f;
  public enum BarPlotFlavor {PLAIN, THREED, GLASS, SKETCH, STACKED};
  
  BarPlotFlavor flavor = BarPlotFlavor.PLAIN;

  public BarPlot() {
    super(new Axis(), new NumericAxis());
  }

  public BarPlot(BarPlotFlavor flavor) {
    this();
    setOpacity(DEFAULT_OPACITY);
    setFlavor(flavor);
  }
  
  public BarPlotFlavor getFlavor() {
    return flavor;
  }

  public void setFlavor(BarPlotFlavor flavor) {
    this.flavor = flavor;
  }
}
