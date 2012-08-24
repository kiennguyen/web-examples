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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class MyDOMParser
{
   public static void main(String[] args)
   {
      MyDOMParser parser = new MyDOMParser();
      Document dom = parser.parseFile("src/main/resources/employee.xml");
      List<Employee> ems = parser.parseDocument(dom);
      parser.print(ems);      
   }
   
   public void print(List<Employee> ems)
   {

      System.out.println("No of Employees '" + ems.size() + "'.");

      Iterator it = ems.iterator();
      while (it.hasNext())
      {
         System.out.println(it.next().toString());
      }
   }

   public Document parseFile(String filename)
   {
      try
      {
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = dbf.newDocumentBuilder();
         return builder.parse(filename);
      }
      catch (ParserConfigurationException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      catch (SAXException e)
      {
         e.printStackTrace();
      }
      return null;
   }

   public ArrayList<Employee> parseDocument(Document dom)
   {
      Element e = dom.getDocumentElement();
      NodeList l = e.getElementsByTagName("Employee");
      if (l != null && l.getLength() > 0)
      {
         ArrayList<Employee> ems = new ArrayList<Employee>();
         for (int i = 0; i < l.getLength(); i++)
         {
            ems.add(parseEmployee((Element)l.item(i)));
         }
         return ems;
      }
      return null;
   }

   /**
    * ie
    *  <Employee type="permanent">
        <Name>Seagull</Name>
        <Id>3674</Id>
        <Age>34</Age>
       </Employee>
    * @param empEl
    * @return
    */
   public Employee parseEmployee(Element empEl)
   {
      String name = getTextValue(empEl, "Name");
      int id = getIntValue(empEl, "Id");
      int age = getIntValue(empEl, "Age");

      String type = empEl.getAttribute("type");
      Employee e = new Employee(name, id, age, type);

      return e;
   }

   private String getTextValue(Element ele, String tagName)
   {
      String textVal = null;
      NodeList nl = ele.getElementsByTagName(tagName);
      if (nl != null && nl.getLength() > 0)
      {
         Element el = (Element)nl.item(0);
         textVal = el.getFirstChild().getNodeValue();
      }

      return textVal;
   }

   private int getIntValue(Element ele, String tagName)
   {
      return Integer.parseInt(getTextValue(ele, tagName));
   }

}
