package com.mt.test;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public interface EmployeeDao
{
   public Employee get(Integer id);
   public void update(Employee e);
}
