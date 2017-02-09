package com.babu.designpatterns.behavioral;

public class LightsOffCommand implements Command {
	
	private LightDevice light;

	@Override
	public void execute() {
		light.switchOff();
		System.out.println("Light is "+(light.isLightOn()?"on":"off"));
	}

	public void setLightDevice(LightDevice light) {
		this.light = light;
	}
}
