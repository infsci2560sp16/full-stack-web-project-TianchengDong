import com.google.gson.Gson;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.text.SimpleDateFormat;
import static spark.Spark.get;


public class Personinfo {

    Gson gson = new Gson();

    public Personinfo() {
        getPersoninfo();
    }

    private void getPersoninfo() {
            String city[]  = {"beijing","shanghai","xi-an","chengdu","hongkong","taipei"};
            get("/api/personinfo", (req, res) -> {

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("username","David");
                attributes.put("city",city);

                return new ModelAndView(attributes, "personinfo.ftl");
              }, new FreeMarkerEngine());
    }



}
