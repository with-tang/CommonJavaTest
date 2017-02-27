package com.tang.composition;

public class AnimalTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Animal animal=new Animal();
		Wolf wolf=new Wolf(animal);
		Sheep sheep =new Sheep(animal);
		System.out.println("wolf 出场");
		wolf.beat();
		wolf.eat();
		System.out.println("wolf 离场\n");
		System.out.println("sheep 出场");
		sheep.beat();
		sheep.eat();
		System.out.println("sheep 离场\n");
	}

}
