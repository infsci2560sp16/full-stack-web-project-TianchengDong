

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.get;


public class InfoRoutes {

    Gson gson = new Gson();

    public InfoRoutes() {
        setupRoutes();
    }

    private void setupRoutes() {
      get("/api/about", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("city", "Beijing");
          data.put("description", "Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.");
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
