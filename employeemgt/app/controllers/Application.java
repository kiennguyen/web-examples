package controllers;

import play.db.jpa.GenericModel.JPAQuery;

import models.User;
import play.data.validation.Valid;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller
{

   public static void index()
   {
      renderArgs.put("user", session.get("username"));
      render();
   }

   public static void login()
   {
      render();
   }

   public static void register()
   {
      render();
   }

   public static void doLogin(String username, String password)
   {
      System.out.println("user:" + username + " pass:" + password);
      User user = User.find("byUsernameAndPassword", username, password).first();
      if (user != null)
      {
         System.out.println("Successfully");
      }
      System.out.println("Failure");
   }

   public static void saveUser(@Valid User user, String verifyPassword)
   {
      System.out.println("user:" + user.username + " pass:" + verifyPassword);
      if (validation.hasErrors())
      {
         render("@register", user, verifyPassword);
      }
      user.create();
   }
}