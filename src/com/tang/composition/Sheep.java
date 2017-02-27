package com.tang.composition;

public class Sheep
{
	private Animal animal;
	public Sheep(Animal animal)
	{
		this.animal=animal;
	}
	public void beat()
	{
		animal.beat();
	}
	public void eat()
	{
		System.out.println("I am a sheep, I eat grass !");
	}
}
