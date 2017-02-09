package com.babu.designpatterns.behavioral.state;

public abstract class ATMState {
	
	public abstract void insertCard();
	
	public abstract void enterPin(int pinEntered);
	
	public abstract void withDrawCash(int cashEntered);
	
	public abstract void ejectCard();
	
}
