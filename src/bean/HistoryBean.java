package bean;

import java.io.Serializable;

public class HistoryBean implements Serializable{
	private String itemId;
	private String itemName;
	private int itemByQuantity;

	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemByQuantity() {
		return itemByQuantity;
	}
	public void setItemByQuantity(int itemByQuantity) {
		this.itemByQuantity = itemByQuantity;
	}
}