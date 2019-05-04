package Model;

import org.apache.log4j.BasicConfigurator;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

       //BasicConfigurator.configure();

        get("/",(req,res) -> {
            Map<String,Object> model = new HashMap<>();
            model.put("template","templates/welcome.vtl");
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model,layout)
            );
        });

        get("/login",(req,res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("template","templates/login.vtl");

            return new VelocityTemplateEngine().render(
                    new ModelAndView(model,layout)
            );
        });

        post("/login",(req,res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("template","templates/login.vtl");

            String email = req.queryParams("email");
            String password = req.queryParams("password");

            if(email.trim().isEmpty() || password.trim().isEmpty())
            {
                System.out.println("please fill in all the fields");
            }
            else {
                if (!(User.allEmails().contains(email))) {
                    System.out.println("Email does not exist");
                }
                else {
                    User user = new User(email, password);

                    if(user.getUserPassword().equals(password))
                    {
                        System.out.println("Welcome");
                    }
                    else
                    {
                        System.out.println("wrong password");
                    }
                }
            }

            return new VelocityTemplateEngine().render(
                    new ModelAndView(model,layout)
            );
        });


        get("/signUp",(req,res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("template","templates/signup.vtl");

            return new VelocityTemplateEngine().render(
                    new ModelAndView(model,layout)
            );
        });


        post("/signUp",(req,res) ->
        {
            Map<String, Object> model = new HashMap<>();

            String email = req.queryParams("email");
            String password = req.queryParams("password");
            String confirm_password = req.queryParams("confirm_password");

            if(email.trim().isEmpty() || password.trim().isEmpty() || confirm_password.trim().isEmpty())
            {
                System.out.println("please fill in all the fields");
            }
            else
            {
                if (!(User.allEmails().contains(email)))
                {
                    if(password.equals(confirm_password))
                    {
                        User user = new User(email,password);
                        user.register();
                        res.redirect("/");
                    }
                    else {
                        System.out.println("password doesnt match");
                    }

                }
                else {
                    System.out.println("email already exist, log in instead");
                    res.redirect("/login");
                }

            }
            return new VelocityTemplateEngine().render(
              new ModelAndView(model,layout)
            );
        });

    }
}
