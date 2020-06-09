package com.email.service.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadApplicationConstants 
{
	@Value("${excelSheetPath}")
	private String excelSheetPath;
	
	public String getExcelSheetPath() {
		return excelSheetPath;
	}

	public void setExcelSheetPath(String excelSheetPath) {
		this.excelSheetPath = excelSheetPath;
	}
	
}
