package com.email.service.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.service.common.EmailUtility;
import com.email.service.common.ReadApplicationConstants;
import com.email.service.common.ReadEmailConstants;

@Service
public class ReadEmailAddressService 
{

	private static final Logger Log = LoggerFactory.getLogger(ReadEmailAddressService.class);
	
	@Autowired
	private EmailUtility emailUtility;
	
	@Autowired
	private ReadApplicationConstants applicationConstants;
	
	public int readExcelSheet() 
	{
		Log.debug("Request received in service to read the email address from excel sheet at path {} and send them participation email",applicationConstants.getExcelSheetPath());
		Log.debug("Creating file stream to read excel sheet stored at path {}",applicationConstants.getExcelSheetPath());
		boolean flag=true;  //Setting the flag to true
		try 
		{
			FileInputStream fileStream = new FileInputStream(applicationConstants.getExcelSheetPath());
			Log.debug("Creating work book object");
			Workbook workbook = new XSSFWorkbook(fileStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			Row row = sheet.getRow(0);
			List<String> emailAddress = new ArrayList<>();
			fileStream.close();
			while(rowIterator.hasNext() && flag)
			{
				row = rowIterator.next();
				Cell userEmailAddress = row.getCell(0);
				if(userEmailAddress.getCellType()==Cell.CELL_TYPE_STRING)
				{
					Log.debug("Cell type is String, checking for null or empty values");
					if(Objects.isNull(userEmailAddress.getStringCellValue())||userEmailAddress.getStringCellValue().isEmpty())
					{
						Log.error("Cell value is null or empty, cannot process excel read");
						return -25;
					}
					else
					{
						Log.debug("Cell value is not null, The email address is {} - adding this email to array list",userEmailAddress.getStringCellValue());
						emailAddress.add(userEmailAddress.getStringCellValue());
					}
				}
				else
				{
					Log.debug("Cell type does not match, returning -30");
					flag=false;
					return -30;
				}
				
			}
			Log.debug("The number of email addresses added in the array list is {}. Constructing email body",emailAddress.size());
			Log.debug("Sending request to generate the email body");
			String body = this.generateEmailBody();
			Log.debug("Received the email body, Sending email to the user");			
			return emailUtility.send(emailAddress,ReadEmailConstants.getSubject(), body, ReadEmailConstants.getSender());
			
		}
		catch (Exception e) 
		{
			Log.debug("An exception occurred while reading the email sheet "+e);
			return -25;
		}
		
	}

	public String generateEmailBody()
	{
		Log.debug("Request received to generate the email body");
		String emailBody="<html>"+
				"<body style='background-color:white'>"+
				"<div>"
				+"<div style=font-family:'Calibri (Body)'>"
				+"<p>"+ReadEmailConstants.getSalutation()+"</p>"+
				"<p>"+ReadEmailConstants.getIntroductionText()+"</p>"+
				"<p>"+ReadEmailConstants.getFirstParaText()+"&nbsp;<b>"+ReadEmailConstants.getWinnersBoldText()+"</b>&nbsp;"
				+ReadEmailConstants.getRecognizedWithText()+"&nbsp;<b>"+ReadEmailConstants.getCertificateBoldText()+"</b>&nbsp;"
				+ReadEmailConstants.getFirstParaEnding()+"&nbsp;<b>"+ReadEmailConstants.getCertificateOfParticipationBoldText()+
				"</b></p>"+
				"<p>"+ReadEmailConstants.getToText()+"&nbsp;<b style='color:red'>"+ReadEmailConstants.getDownloadBoldRedText()+"</b>&nbsp;"
				+"<b>"+ReadEmailConstants.geteCertificateTextBold()+"</b>&nbsp;"+ReadEmailConstants.getSecondParagraph()+"</p>"
				+"<p>"+ReadEmailConstants.getThankYouMessage()+"</p>"
				+"<p>"+ReadEmailConstants.getTeamText()+"<br>"
				+ReadEmailConstants.getScgjText()+"</p>"
				+"</div></div></body></html>";
		return emailBody;
	}
}
