package domain;


public class Item{
	private boolean isAvailable;
	private int code;
	private String title;
	private String description;
	private String location;
	private double dailyPrice;
	
	
	public void returnItem() {
		
	}
	
	public void updateItemAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}