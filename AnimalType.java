public class AnimalType{
		   public static void main(String args[]){
		      /// create object for animalType 
			  
			  Animal a1 = new Animal();  			  
			  
			  a1.age = 30;
			  a1.name = "croccodile";
			  a1.height =21.9;
			  a1.weight = 899.0;
			  a1.color = "black";
			 
			  double AnimalRunRate  = a1.getRunRate();
			  
			  System.out.println("animal details");
			  System.out.println(a1.name);
			  System.out.println(a1.age);
			  System.out.println(a1.height);
			  System.out.println(a1.weight);
			  System.out.println(a1.color);
			  System.out.println(AnimalRunRate);
			  
			  Person a2 = new Person();
			  a2.age = 8;
			  a2.name = "Dog";
			  a2.height = 3.6;
			  a2.weight = 45.0;
			  a2.color = "lightgrey";
			  
			  double DogRunRate  = a2.getRunRate();
			  
			  System.out.println("Dog details");
			  System.out.println(a2.name);
			  System.out.println(a2.age);
			  System.out.println(a2.height);
			  System.out.println(a2.weight);
			  System.out.println(a2.color);
			  System.out.println(DogRunRate);
		   }
		}
		
		
		

 


			
					   
			   
			  
			  
			  
			  
			  
			  
	   
	   
	   
	   