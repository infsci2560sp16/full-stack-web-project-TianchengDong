import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.get;
import spark.Request;

public class SignupRoutes {

    Gson gson = new Gson();

    public SignupRoutes() {
        checkUser();
    }

    String [] list = {"abc","123","amy","david"};

    private void checkUser() {
      get("/api/checkuser/:name", (req, res) -> {

        String username = req.params(":name");
        System.out.println(username);
        String result = "true";
        for(int i = 0;i < list.length; i++)
        {
          if(list[i].equals(username))
            result = "false";

        }

        Map<String, Object> data = new HashMap<>();
        data.put("success", result);

        return data;
      }, gson::toJson);


  }
}
