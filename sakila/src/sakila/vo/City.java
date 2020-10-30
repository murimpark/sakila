package sakila.vo;

public class City {
	private int cityId;
	private String city;
	private int countryName;
	private String lastUpdate;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCountryName() {
		return countryName;
	}
	public void setCountryName(int countryName) {
		this.countryName = countryName;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", city=" + city + ", countryName=" + countryName + ", lastUpdate="
				+ lastUpdate + "]";
	}
}
