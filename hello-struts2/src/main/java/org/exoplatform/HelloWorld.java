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
package org.exoplatform;

/**
 * @author <a href="kienna@exoplatform.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class HelloWorld {

   private String message;

   private String userName;
   
   public HelloWorld() {
   }

   public String execute() {
       setMessage("Hello " + getUserName());
       return "SUCCESS";
   }

   /**
    * @return the message
    */
   public String getMessage() {
       return message;
   }

   /**
    * @param message the message to set
    */
   public void setMessage(String message) {
       this.message = message;
   }

   /**
    * @return the userName
    */
   public String getUserName() {
       return userName;
   }

   /**
    * @param userName the userName to set
    */
   public void setUserName(String userName) {
       this.userName = userName;
   }

}
