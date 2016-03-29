import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.get;
import spark.Request;

public class CityRoutes {

  public CityRoutes(){
  //  CreateSampleData();
    getCityInfo();
  }
  public HashMap<String,CityInfo> CreateSampleData()
  {
    CityInfo beijing = new CityInfo("China","136,782,000","Asia","Beijing","Mandarin","RMB","Shanghai","Guangzhou","The Great Wall","the Palace Museum");
  	CityInfo shanghai = new CityInfo("United States of America","322,369,319","North America","Washington, D.C.","English","United States dollar","New York City","Los Angeles","Grand Canyon","Statue of Liberty");
  	CityInfo xi-an = new CityInfo("Canada","36,048,521","North America","Ottawa","English and French","Canadian dollar","Vancouver","Toronto","Niagara Falls","Churchill");
    HashMap<String,CityInfo> cityList = new HashMap<>();
			cityList.put(beijing.getcName(), beijing);
			cityList.put(shanghai.getcName(), shanghai);
			cityList.put(xi-an.getcName(), xi-an);
      return cityList;
  }


  private void getCityInfo(){
    get("/api/mapInfo/:name", (req, res) -> {

      String name = req.params(":name");
      HashMap<String,CityInfo> cityList = new HashMap<>();
      cityList = CreateSampleData();
      CityInfo city = new CityInfo();
       if(!cityList.containsKey(name))
       {

          city = null;
       }
       else
       {
          city = cityyList.get(name);

       }

       String xml = "";
      // try {
       if(null != city)
       {
          xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                              "<City>" +
                                  "<name>"+city.getcName()+"</name>" +
                                  "<population>"+city.getPopulation()+"</population>" +
                                  "<location>"+city.getLocation()+"</location>" +
                                  "<area>"+city.getArea()+"</area>" +
                                  "<language>"+city.getLanguage()+"</language>" +
                                  "<currency>"+city.getCurrency()+"</currency>" +
                                  "<time>"+city.getTime()+"</time>" +
                                  "<poi1>"+city.getPoi1()+"</poi1>" +
                                  "<poi2>"+city.getPoi2()+"</poi2>" +
                                  "<poi3>"+city.getPoi3()+"</poi3>" +
                              "</City>";
       }
      else
      {
         xml =    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                             "<City>" +
                              "<name>information is not available yet</name>" +

                             "</City>";
      }

      res.type("text/xml");
      return xml;
 });


  }

}
