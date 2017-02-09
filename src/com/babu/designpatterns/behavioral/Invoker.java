package com.babu.designpatterns.behavioral;

public class Invoker {
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void action() {
		System.out.println("Executing command ");
		command.execute();
		System.out.println("Completed executing command");
	}
}
