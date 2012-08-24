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

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class Employee
{

   private String name;

   private int age;

   private int id;

   private String type;

   public Employee()
   {

   }

   public Employee(String name, int id, int age, String type)
   {
      this.name = name;
      this.age = age;
      this.id = id;
      this.type = type;

   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      sb.append("Employee Details - ");
      sb.append("Name:" + getName());
      sb.append(", ");
      sb.append("Type:" + getType());
      sb.append(", ");
      sb.append("Id:" + getId());
      sb.append(", ");
      sb.append("Age:" + getAge());
      sb.append(".");

      return sb.toString();
   }
}
