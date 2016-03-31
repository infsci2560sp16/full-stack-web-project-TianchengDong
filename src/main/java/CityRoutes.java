import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import static spark.Spark.get;
import spark.Request;

public class CityRoutes {

  public CityRoutes(){
    getCityInfo();
  }

  public HashMap<String,CityInfo> CreateSampleData()
  {
     CityInfo beijing = new CityInfo("beijing","21,516,000","Middle North","Mainland China","Mandarin","RMB","GMT+8","Forbidden City","The Great Wall","Summer Palace");
  	 CityInfo shanghai = new CityInfo("shanghai","24,152,700","East","Mainland China","Mandarin","RMB","GMT+8","The Bund","Shanghai Tower","Shanghai Disney");
     CityInfo xian = new CityInfo("xian","8,627,500","North West","Mainland China","Mandarin","RMB","GMT+8","Giant Wild Goose Pagoda","Bell Tower","Drum Tower");
     CityInfo chengdu = new CityInfo("chengdu","14,427,500","West","Mainland China","Mandarin","RMB","GMT+8","Mount Qingcheng","Dujiangyan","Sichuan Giant Panda Sanctuaries");
     CityInfo hongkong = new CityInfo("hongkong","7,234,800","South","Hong Kong SAR","Cantonese","Hong Kong Dollar","GMT+8","Avenue of Stars","Victoria Harbour","The Ocean Park");
     CityInfo taipei = new CityInfo("taipei","2,704,974","South East","Taiwan","Chinese","New Taipei Dollar","GMT+8","National Palace Museum","Taipei 101","Ximending");

    HashMap<String,CityInfo> cityList = new HashMap<>();
		  cityList.put(beijing.getcName(), beijing);
			cityList.put(shanghai.getcName(), shanghai);
      cityList.put(xian.getcName(), xian);
      cityList.put(chengdu.getcName(), chengdu);
      cityList.put(hongkong.getcName(), hongkong);
      cityList.put(taipei.getcName(), taipei);

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
          city = cityList.get(name);

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
