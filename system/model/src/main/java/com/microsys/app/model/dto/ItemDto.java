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

	@JsonIgnore
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
}
