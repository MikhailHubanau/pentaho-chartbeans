/*
 * Copyright 2008 Pentaho Corporation.  All rights reserved. 
 * This software was developed by Pentaho Corporation and is provided under the terms 
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use 
 * this file except in compliance with the license. If you need a copy of the license, 
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho 
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS" 
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to 
 * the license for the specific language governing your rights and limitations.
 *
 * Created  
 * @author David Kincade
 */
package org.pentaho.experimental.chart.core.parser;

import org.jfree.xmlns.parser.AbstractXmlReadHandler;
import org.jfree.xmlns.parser.XmlReadHandler;
import org.pentaho.experimental.chart.core.ChartElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ChartElementReadHandler extends AbstractXmlReadHandler {
  private ChartElement chartElement;

  public ChartElementReadHandler() {
    chartElement = new ChartElement();
  }

  protected XmlReadHandler getHandlerForChild(final String uri, final String tagName, final Attributes atts)
      throws SAXException {
    return new ChartElementReadHandler();
  }

  public Object getObject() throws SAXException {
    return chartElement;
  }

}
