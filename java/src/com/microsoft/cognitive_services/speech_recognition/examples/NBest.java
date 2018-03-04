package com.microsoft.cognitive_services.speech_recognition.examples;

public class NBest {
	private double Confidence;
	private String Lexical;
	private String ITN;
	private String MaskedITN;
	private String Display;
	
	public double getConfidence() {
		return Confidence;
	}
	public void setConfidence(double confidence) {
		Confidence = confidence;
	}
	public String getLexical() {
		return Lexical;
	}
	public void setLexical(String lexical) {
		Lexical = lexical;
	}
	public String getITN() {
		return ITN;
	}
	public void setITN(String iTN) {
		ITN = iTN;
	}
	public String getMaskedITN() {
		return MaskedITN;
	}
	public void setMaskedITN(String maskedITN) {
		MaskedITN = maskedITN;
	}
	public String getDisplay() {
		return Display;
	}
	public void setDisplay(String display) {
		Display = display;
	}
}
