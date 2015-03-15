package com.microsys.app.model.dto;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("Item")
public class ItemDto {

	@JsonProperty("ItemName")
	private String itemName;

	public String getItemName() {
		return itemName;
	}
	
	private int hashValue;

	@JsonIgnore
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public int hashCode() {
		hashValue = itemName.hashCode();
		return hashValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		return hashValue == ((ItemDto)obj).hashCode() ? true : false;
	}
	
}
