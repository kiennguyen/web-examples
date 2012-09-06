package com.mt.test;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class Employee
{
   private final Integer id;
   private final String name;

   public Employee(Integer id, String name)
   {
      this.id = id;
      this.name = name;
   }

   public Integer getId()
   {
      return id;
   }

   public String getName()
   {
      return name;
   }
}
