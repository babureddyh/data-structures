package com.babu.designpatterns.behavioral;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightDevice light = new LightDevice();
		LightsOnCommand command = new LightsOnCommand();
		Invoker invoker = new Invoker();
		command.setLightDevice(light);
		invoker.setCommand(command);
		invoker.action();
		LightsOffCommand command1 = new LightsOffCommand();
		command1.setLightDevice(light);
		invoker.setCommand(command1);
		invoker.action();
	}

}
