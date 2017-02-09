package com.babu.designpatterns.behavioral;

public class LightsOnCommand implements Command {

	private LightDevice light;
	@Override
	public void execute() {
		light.switchOn();
		System.out.println("Light is "+(light.isLightOn()?"on":"off"));
	}

	public void setLightDevice(LightDevice light) {
		this.light = light;
	}
}
