
public class AppMain {
	
	public static void myGreet(Gretting gretting) {
		gretting.perform();
	}
	

	public static void main(String[] args) {
		
		//Instance Polymorphism
		Gretting gg = new GoodGreeting();
		gg.perform();
		
		//Anonymous Implementation
		gg = new Gretting() {
			public void perform() {
				System.out.println("Hello World!");		
			}
		};
		gg.perform();
		
	
		//Inline Lambda Expression behaving like a instance
		//To work it has to be a functional interface 
		//i.e. one method with same lambda expression signature. 
		gg = () -> System.out.println("Hello World!");
		gg.perform();
				
		// Reference Way		
		myGreet(gg);
		
		
	}

}
