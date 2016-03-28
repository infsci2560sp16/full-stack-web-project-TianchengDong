import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.get;
import static spark.Spark.post;


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


      post("/api/input/place", (req, res) -> {
          req.queryParams("place");

          Map<String, Object> data = new HashMap<>();
          data.put("success", result);

          return data;
      }, gson::toJson);





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
