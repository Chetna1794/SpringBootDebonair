package com.infogain.debonair.dto;

import java.io.Serializable;

/**
 * Item class has the details of different items served at the restaurant
 * 
 * @author Chetna
 * @since 21-Apr-2020
 */
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;
	private int itemId;
	private String itemName;
	private float itemRate;
	private double prepTime;

	/**
	 * @param itemId   - Item's ID
	 * @param itemName - Item's Name
	 * @param itemRate - Item's Rate
	 * @param prepTime - Time taken by the item to prepare
	 */
	public Items(int itemId, String itemName, float itemRate, double prepTime) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemRate = itemRate;
		this.prepTime = prepTime;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public double getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(double prepTime) {
		this.prepTime = prepTime;
	}

	/**
	 * Overridden toString() method of Item class
	 * 
	 * @return Stringified form of Item Object
	 * @since 21-Apr-2020
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Items [itemId=").append(itemId).append(", itemName=").append(itemName).append(", itemRate=")
				.append(itemRate).append(", prepTime=").append(prepTime).append("]");
		return builder.toString();
	}

	/**
	 * Overridden hashCode() method of Item class
	 * 
	 * @return Stringified form of Item Object
	 * @since 21-Apr-2020
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + Float.floatToIntBits(itemRate);
		long temp;
		temp = Double.doubleToLongBits(prepTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Overridden equals() method of Item class
	 * 
	 * @return Stringified form of Item Object
	 * @since 21-Apr-2020
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Float.floatToIntBits(itemRate) != Float.floatToIntBits(other.itemRate))
			return false;
		if (Double.doubleToLongBits(prepTime) != Double.doubleToLongBits(other.prepTime))
			return false;
		return true;
	}

}
