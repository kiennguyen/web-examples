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
package models;

import play.modules.mongo.MongoEntity;

import play.modules.mongo.MongoModel;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */
@MongoEntity("collectionName")
public class Car extends MongoModel
{
   public String name;
   public String colour;
   public int topSpeed;
   
   public Car(String name, String colour, int topSpeed)
   {
      this.name = name;
      this.colour = colour;
      this.topSpeed = topSpeed;
               
   }
}
