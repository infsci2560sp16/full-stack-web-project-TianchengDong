import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;

import org.json.JSONObject;
import java.sql.*;
import java.util.ArrayList;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import com.heroku.sdk.jdbc.DatabaseUrl;


public class InfoRoutes {

    Gson gson = new Gson();

    public InfoRoutes() {
        setupRoutes();
    }

    private void setupRoutes() {
      get("/api/about", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("city1", "Beijing");
          data.put("city2", "Shanghai");
          data.put("city3", "Xi'an");
          data.put("city4", "Chengdu");
          data.put("city5", "Hongkong");
          data.put("city6", "Taipei");
          data.put("description", "Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.");
          return data;
      }, gson::toJson);


      post("/api/name", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("name", "David");
          return data;
      }, gson::toJson);


      //respond to post json request from client
      post("/api/signup", (req, res) -> {
          Connection connection = null;
          //**Testing**
          System.out.println(req.body());
        try {
          connection = DatabaseUrl.extract().getConnection();
          JSONObject obj = new JSONObject(req.body());
          String username = obj.getString("username");
          String email = obj.getString("email");
          String password = obj.getString("password");

          String sql = "INSERT INTO User(username, email, password) VALUES ('"
                        + username + "','" + email + "','" + password + "')";

          connection = DatabaseUrl.extract().getConnection();
          Statement stmt = connection.createStatement();
          stmt.executeUpdate("CREATE TABLE IF NOT EXISTS User");
          stmt.executeUpdate(sql);

           //**Testing**
         System.out.println(username);
         System.out.println(email);
         System.out.println(password);

         return req.body();
        } catch (Exception e) {
          return e.getMessage();
        } finally {

        }
      });


      // post("/api/input/place", (req, res) -> {
      //     req.queryParams("place");
      //
      //     Map<String, Object> data = new HashMap<>();
      //     data.put("success", result);
      //
      //     return data;
      // }, gson::toJson);





        // get("/api/time/now", (req, res) -> {
        //     Map<String, Object> data = new HashMap<>();
        //     data.put("currentTime", new Date());
        //     return data;
        // }, gson::toJson);
        //
        // get("/api/time/now.xml", (req, res) -> {
        //     Map<String, Object> data = new HashMap<>();
        //     data.put("currentTime", new Date());
        //     return data;
        // }, gson::toJson);


  }
}
