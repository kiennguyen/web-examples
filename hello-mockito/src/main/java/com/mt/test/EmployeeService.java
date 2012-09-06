package com.mt.test;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class EmployeeService
{
   private final EmployeeDao employeeDao;

   public EmployeeService(EmployeeDao employeeDao)
   {
      this.employeeDao = employeeDao;
   }

   public boolean update(Integer id, String name)
   {
      Employee e = employeeDao.get(id);
      if (e != null)
      {
         Employee updatedEmployee = new Employee(e.getId(), name);
         employeeDao.update(updatedEmployee);
         return true;
      }
      else
      {
         return false;
      }

   }
}
