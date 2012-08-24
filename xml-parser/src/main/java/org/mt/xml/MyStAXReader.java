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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class MyStAXReader
{
   public static void main(String[] args) throws Exception
   {
      readXML(new FileInputStream("src/main/resources/employee.xml"));
   }

   public static void readXML(InputStream stream) throws Exception
   {
      XMLInputFactory xif = XMLInputFactory.newFactory();
      XMLEventReader xef = xif.createXMLEventReader(stream);
      
      while(xef.hasNext())
      {
         XMLEvent event = xef.nextEvent();
         if(event.isStartElement())
         {
            StartElement element = (StartElement) event;
            System.out.println("Start Element: " + element.getName());

            Iterator iterator = element.getAttributes();
            while (iterator.hasNext()) {
              Attribute attribute = (Attribute) iterator.next();
              QName name = attribute.getName();
              String value = attribute.getValue();
              System.out.println("Attribute name/value: " + name + "/" + value);
            }
         }
         if(event.isEndElement())
         {
            EndElement element = (EndElement) event;
            System.out.println("End element:" + element.getName());
         }
         if(event.isCharacters())
         {
            Characters characters = (Characters) event;
            System.out.println("Text: " + characters.getData());
         }
      }
   }
}
