/**
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mt.xml;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class MyStAXWriter
{
   public static void main(String[] args) throws Exception
   {
      generateXML(System.out);

      generateXML(new FileOutputStream("src/main/resources/stax.xml"));
   }

   public static void generateXML(OutputStream stream) throws Exception
   {
      XMLEventFactory xef = XMLEventFactory.newInstance();
      XMLOutputFactory xof = XMLOutputFactory.newInstance();
      XMLEventWriter writer = xof.createXMLEventWriter(stream);
      StartDocument startDoc = xef.createStartDocument("UTF-8", "1.0");
      writer.add(startDoc);
      
      StartElement startEle = xef.createStartElement("", "", "Personnel");
      writer.add(startEle);
      
      startEle = xef.createStartElement("", "", "Employee");
      writer.add(startEle);
      
      EndDocument endDocument = xef.createEndDocument();
      writer.add(endDocument);
      
      writer.flush();
      writer.close();
      stream.close();
   }
}
