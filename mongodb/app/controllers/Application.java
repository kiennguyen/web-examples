package controllers;

import play.cache.Cache;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller
{
   public static void index()
   {
      List<Car> cars = Cache.get("cars", List.class);
      if(cars == null) {
          cars = Car.find().fetch();
          Cache.set("cars", cars, "30mn");
      }
      render(cars);
   }

}