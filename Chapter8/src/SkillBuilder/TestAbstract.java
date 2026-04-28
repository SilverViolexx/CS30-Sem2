package SkillBuilder;

//parent class - other classes inherit properties from this
//class has to be abstract to have abstract methods
abstract class TestAbstract {

	//abstract method - children that inherit has wheels but don't know specifics - ie. # of wheels, rim colour
	//specifications happen in children class
	abstract void hasWheels();
	
}
