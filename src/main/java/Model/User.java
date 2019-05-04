package Model;

import org.sql2o.Connection;

import java.util.List;

public class User {
    private String email;
    private String password;
    private int id;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void register() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO users (email,password) VALUES (:email,:password)";
           this.id =(int) con.createQuery(sql,true)
                    .addParameter("email", this.email)
                    .addParameter("password", this.password)
                    .executeUpdate()
                   .getKey();
        }
    }

    public static List<User> allUsers() {
        String sql = "SELECT * FROM users";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    public static List<String> allEmails()
    {
        String sql = "SELECT email FROM users";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(String.class);
        }
    }

    public String getUserPassword()
    {
        String sql = "SELECT password FROM users WHERE email = :email";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("email",this.email)
                     .executeAndFetch(String.class).toString()
                    .replace("[","").replace("]","");
        }



    }



}
