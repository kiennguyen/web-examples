package startup;

import play.test.*;
import play.jobs.*;
import models.*;

@OnApplicationStart
public class Bootstrap extends Job
{
   public void doJob()
   {
      System.out.println("Bootstrap started");
      if (User.count() == 0)
      {
         Fixtures.loadModels("data.yml");
      }
   }
}