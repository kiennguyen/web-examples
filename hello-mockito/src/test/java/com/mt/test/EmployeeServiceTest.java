package com.mt.test;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import junit.framework.TestCase;

/**
 * @author <a href="nguyenanhkien2a@gmail.com">Kien Nguyen</a>
 * @version $Revision$
 */

public class EmployeeServiceTest extends TestCase
{
   private EmployeeService employeeService;
   private EmployeeDao employeeDao;
   
   @Override
   public void setUp() throws Exception
   {
      super.setUp();
      this.employeeDao = Mockito.mock(EmployeeDao.class);
      this.employeeService = new EmployeeService(employeeDao);
   }
   
   public void testUpdateName()
   {
      Employee e = new Employee(1, "anh");
      Mockito.when(employeeDao.get(1)).thenReturn(e);

      boolean updated = employeeService.update(1, "kien");
      assertTrue(updated);

      Mockito.verify(employeeDao).get(1);

      ArgumentCaptor<Employee> eCaptor = ArgumentCaptor
              .forClass(Employee.class);
      Mockito.verify(employeeDao).update(eCaptor.capture());
      Employee updatedPerson = eCaptor.getValue();
      assertEquals("kien", updatedPerson.getName());

      Mockito.verifyNoMoreInteractions(employeeDao);
   }
}
