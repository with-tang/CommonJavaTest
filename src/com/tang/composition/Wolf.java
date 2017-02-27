package com.tang.composition;

public class Wolf
{
	private Animal animal;
	public Wolf(Animal animal)
	{
		this.animal=animal;
	}
	public void beat()
	{
		animal.beat();
	}
	public void eat()
	{
		System.out.println("I am a wolf,I eat sheep !");
	}
}
