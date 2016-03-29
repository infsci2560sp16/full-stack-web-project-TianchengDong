public class CityInfo {
	private String cName;
	private String population;
	private String location;
	private String area;
	private String language;
	private String currency;
	private String time;
	private String poi1;
	private String poi2;
	private String poi3;
  public CityInfo(){};
	public CityInfo(String cname,String pop,String loc,String are,String lang,String cur,String tim,String p1,String p2,String p3)

	{
		this.cName = cname;
		this.population = pop;
		this.location = loc;
		this.area = are;
		this.language = lang;
		this.currency = cur;
		this.time = tim;
		this.poi1 = p1;
		this.poi2 = p2;
		this.poi3 = p3;

	}

	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
  public String getPoi1() {
		return poi1;
	}
	public void setPoi1(String poi1) {
		this.poi1 = poi1;
	}
	public String getPoi2() {
		return poi2;
	}
	public void setPoi2(String poi2) {
		this.poi2 = poi2;
	}
	public String getPoi3() {
		return poi3;
	}
	public void setPoi3(String poi3) {
		this.poi3 = poi3;
	}



}
