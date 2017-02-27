package com.tang.composition;

public class AnimalTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Animal animal=new Animal();
		Wolf wolf=new Wolf(animal);
		Sheep sheep =new Sheep(animal);
		System.out.println("wolf ����");
		wolf.beat();
		wolf.eat();
		System.out.println("wolf �볡\n");
		System.out.println("sheep ����");
		sheep.beat();
		sheep.eat();
		System.out.println("sheep �볡\n");
	}

}
