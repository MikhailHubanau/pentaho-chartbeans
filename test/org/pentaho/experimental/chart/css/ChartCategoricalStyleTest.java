package org.pentaho.experimental.chart.css;

import junit.framework.TestCase;
import org.jfree.resourceloader.ResourceException;
import org.pentaho.experimental.chart.ChartBoot;
import org.pentaho.experimental.chart.ChartDocumentContext;
import org.pentaho.experimental.chart.ChartFactory;
import org.pentaho.experimental.chart.core.ChartDocument;
import org.pentaho.experimental.chart.core.ChartElement;
import org.pentaho.experimental.chart.css.keys.ChartStyleKeys;
import org.pentaho.experimental.chart.css.styles.ChartCategoricalStyle;
import org.pentaho.reporting.libraries.css.dom.LayoutStyle;
import org.pentaho.reporting.libraries.css.values.CSSConstant;

public class ChartCategoricalStyleTest extends TestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    
    // Boot the charting library - required for parsing configuration
    ChartBoot.getInstance().start();
  }
  
  public void testCategoryStyle() throws IllegalStateException, ResourceException {
    ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource("ChartCategoricalStyleTest.xml")); //$NON-NLS-1$
    ChartDocument cd = cdc.getChartDocument();
    assertNotNull(cd);
    ChartElement element = cd.getRootElement();
    assertNotNull(element);

    CSSConstant[] passValues = new CSSConstant[]{
        ChartCategoricalStyle.FALSE,
        ChartCategoricalStyle.TRUE,
        ChartCategoricalStyle.FALSE,
        ChartCategoricalStyle.FALSE
    };
    
    int counter = 0;
    int lenArray = passValues.length;
    ChartElement child = element.getFirstChildItem();
    
    while(child != null) {
      LayoutStyle layoutStyle = child.getLayoutStyle();
      assertNotNull(layoutStyle);
      System.out.println("Expected: "+passValues[counter]+" - Got: "+layoutStyle.getValue(ChartStyleKeys.CATEGORICAL)); //$NON-NLS-1$ //$NON-NLS-2$
      assertEquals(passValues[counter++], layoutStyle.getValue(ChartStyleKeys.CATEGORICAL));
      child = child.getNextItem();
    }

    if (counter < lenArray-1) {
      throw new IllegalStateException("Not all tests covered!");  //$NON-NLS-1$
    }
  
  }
}