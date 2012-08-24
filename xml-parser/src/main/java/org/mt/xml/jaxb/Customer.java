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
package org.mt.xml.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

@XmlRootElement
public class Customer
{
   String name;
   int age;
   int id;
 
   public String getName() {
      return name;
   }
 
   @XmlElement
   public void setName(String name) {
      this.name = name;
   }
 
   public int getAge() {
      return age;
   }
 
   @XmlElement
   public void setAge(int age) {
      this.age = age;
   }
 
   public int getId() {
      return id;
   }
 
   @XmlAttribute
   public void setId(int id) {
      this.id = id;
   }
   
  
   @Override
   public String toString()
   {
      return "Customer[id=" + this.id + ",name=" + this.name+ ",age=" + this.age + "]";
   }
}
