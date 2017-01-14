package com.babu.designpatterns.behavioral;

public class LightDevice {
	private boolean lightStatus;
	
	public void switchOn() {
		lightStatus = true;
	}
	
	public void switchOff(){
		lightStatus = false;
	}
	
	public boolean isLightOn() {
		return lightStatus;
	}
}
