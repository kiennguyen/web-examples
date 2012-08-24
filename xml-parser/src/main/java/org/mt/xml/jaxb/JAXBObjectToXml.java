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

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class JAXBObjectToXml
{

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      Customer customer = new Customer();
      customer.setId(10);
      customer.setName("kiennguyen");
      customer.setAge(28);

      try
      {
         File file = new File("src/main/resources/jaxb.xml");
         JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
         Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

         jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

         jaxbMarshaller.marshal(customer, file);
         jaxbMarshaller.marshal(customer, System.out);

      }
      catch (JAXBException e)
      {
         e.printStackTrace();
      }
   }

}
