package com.microsoft.cognitive_services.speech_recognition.examples;

import java.util.List;

public class speechInput {
	private String RecognitionStatus;
	private long Offset;
	private long Duration;
	private List<NBest> NBest;
	
	public String getRecognitionStatus() {
		return RecognitionStatus;
	}
	public void setRecognitionStatus(String recognitionStatus) {
		RecognitionStatus = recognitionStatus;
	}
	public long getOffset() {
		return Offset;
	}
	public void setOffset(long offset) {
		Offset = offset;
	}
	public long getDuration() {
		return Duration;
	}
	public void setDuration(long duration) {
		Duration = duration;
	}
	public List<NBest> getNBest() {
		return NBest;
	}
	public void setNBest(List<NBest> nBest) {
		NBest = nBest;
	}
}
