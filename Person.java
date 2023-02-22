package com.k7it;
public class Person {

	int age;
	String name;
	double height;
	double weight;
	
	public double runCapacity() {
		return (height*weight)/age;
	}

	public static void main(String arg[]) {
		Person p1=new Person();
		p1.age=31;
		p1.name="Prasad";
		p1.height=5.9;
		p1.weight=70.5;
		System.out.println(p1.runCapacity());
	}
}
