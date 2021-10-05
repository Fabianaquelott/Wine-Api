package com.wine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchStoreDTO {
	
	private String storeId;
	private String initialZipCode;
	private String finalZipCode;
}
