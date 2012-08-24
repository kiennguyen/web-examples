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

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class MySaxParser extends DefaultHandler
{
   List<Employee> ems;

   private String tempVal;

   private Employee tempEmp;

   public static void main(String[] args)
   {
      MySaxParser parser = new MySaxParser();
      parser.parseDocument();
      parser.printData();
   }

   public MySaxParser()
   {
      ems = new ArrayList<Employee>();
   }

   private void printData()
   {

      System.out.println("No of Employees '" + ems.size() + "'.");

      Iterator it = ems.iterator();
      while (it.hasNext())
      {
         System.out.println(it.next().toString());
      }
   }

   public void parseDocument()
   {
      SAXParserFactory spf = SAXParserFactory.newInstance();
      try
      {
         SAXParser sp = spf.newSAXParser();
         sp.parse("src/main/resources/employee.xml", this);
      }
      catch (SAXException e)
      {
         e.printStackTrace();
      }
      catch (ParserConfigurationException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public void characters(char[] ch, int start, int length) throws SAXException
   {
      tempVal = new String(ch, start, length);
   }

   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
   {
      tempVal = "";
      if (qName.equalsIgnoreCase("Employee"))
      {
         tempEmp = new Employee();
         tempEmp.setType(attributes.getValue("type"));
      }
   }

   @Override
   public void endElement(String uri, String localName, String qName) throws SAXException
   {
      if (qName.equalsIgnoreCase("Employee"))
      {
         ems.add(tempEmp);
      }
      else if (qName.equalsIgnoreCase("Name"))
      {
         tempEmp.setName(tempVal);
      }
      else if (qName.equalsIgnoreCase("Id"))
      {
         tempEmp.setId(Integer.parseInt(tempVal));
      }
      else if (qName.equalsIgnoreCase("Age"))
      {
         tempEmp.setAge(Integer.parseInt(tempVal));
      }
   }
}
