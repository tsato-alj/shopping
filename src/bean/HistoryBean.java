package bean;

import java.io.Serializable;

public class HistoryBean implements Serializable{
	private int orderId;
	private String itemId;
	private String itemName;
	private int itemByQuantity;

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
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