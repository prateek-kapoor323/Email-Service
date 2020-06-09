package com.email.service.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:emailConstants.properties")
@ConfigurationProperties(prefix="email")
public class ReadEmailConstants 
{
	private static String salutation;
	private static String introductionText;
	private static String firstParaText;
	private static String winnersBoldText;
	private static String recognizedWithText;
	private static String certificateBoldText;
	private static String firstParaEnding;
	private static String certificateOfParticipationBoldText;
	private static String toText;
	private static String downloadBoldRedText;
	private static String eCertificateTextBold;
	private static String secondParagraph;
	private static String thankYouMessage;
	private static String teamText;
	private static String scgjText;
	private static String subject;
	private static String sender;
	
	
	public static String getSender() {
		return sender;
	}
	public static void setSender(String sender) {
		ReadEmailConstants.sender = sender;
	}
	public static String getSubject() {
		return subject;
	}
	public static void setSubject(String subject) {
		ReadEmailConstants.subject = subject;
	}
	public static String getSalutation() {
		return salutation;
	}
	public static void setSalutation(String salutation) {
		ReadEmailConstants.salutation = salutation;
	}
	public static String getIntroductionText() 
	{
		return introductionText;
	}
	public static void setIntroductionText(String introductionText) {
		ReadEmailConstants.introductionText = introductionText;
		System.out.println(ReadEmailConstants.introductionText);
	}
	public static String getFirstParaText() {
		return firstParaText;
	}
	public static void setFirstParaText(String firstParaText) {
		ReadEmailConstants.firstParaText = firstParaText;
	}
	public static String getWinnersBoldText() {
		return winnersBoldText;
	}
	public static void setWinnersBoldText(String winnersBoldText) {
		ReadEmailConstants.winnersBoldText = winnersBoldText;
	}
	public static String getRecognizedWithText() {
		return recognizedWithText;
	}
	public static void setRecognizedWithText(String recognizedWithText) {
		ReadEmailConstants.recognizedWithText = recognizedWithText;
	}
	public static String getCertificateBoldText() {
		return certificateBoldText;
	}
	public static void setCertificateBoldText(String certificateBoldText) {
		ReadEmailConstants.certificateBoldText = certificateBoldText;
	}
	public static String getFirstParaEnding() {
		return firstParaEnding;
	}
	public static void setFirstParaEnding(String firstParaEnding) {
		ReadEmailConstants.firstParaEnding = firstParaEnding;
	}
	public static String getCertificateOfParticipationBoldText() {
		return certificateOfParticipationBoldText;
	}
	public static void setCertificateOfParticipationBoldText(String certificateOfParticipationBoldText) {
		ReadEmailConstants.certificateOfParticipationBoldText = certificateOfParticipationBoldText;
	}
	public static String getToText() {
		return toText;
	}
	public static void setToText(String toText) {
		ReadEmailConstants.toText = toText;
	}
	public static String getDownloadBoldRedText() {
		return downloadBoldRedText;
	}
	public static void setDownloadBoldRedText(String downloadBoldRedText) {
		ReadEmailConstants.downloadBoldRedText = downloadBoldRedText;
	}
	public static String geteCertificateTextBold() {
		return eCertificateTextBold;
	}
	public static void seteCertificateTextBold(String eCertificateTextBold) {
		ReadEmailConstants.eCertificateTextBold = eCertificateTextBold;
	}
	public static String getSecondParagraph() {
		return secondParagraph;
	}
	public static void setSecondParagraph(String secondParagraph) {
		ReadEmailConstants.secondParagraph = secondParagraph;
	}
	public static String getThankYouMessage() {
		return thankYouMessage;
	}
	public static void setThankYouMessage(String thankYouMessage) {
		ReadEmailConstants.thankYouMessage = thankYouMessage;
	}
	public static String getTeamText() {
		return teamText;
	}
	public static void setTeamText(String teamText) {
		ReadEmailConstants.teamText = teamText;
	}
	public static String getScgjText() {
		return scgjText;
	}
	public static void setScgjText(String scgjText) {
		ReadEmailConstants.scgjText = scgjText;
	}
}