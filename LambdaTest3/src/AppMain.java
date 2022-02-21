import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AppMain {

	
	public static void printMessage() {
		System.out.println("Hello world!");
	}
	
	public static void main(String[] args) {
		//Method Reference ClassPath::method name for simple pass through ()-> printMessaage() with NO ARGUMENTS
		Thread t1 = new Thread(AppMain::printMessage);
		//t1.start();

		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Adfa","Bjhgj",1));
		people.add(new Person("a","Diiy",2));
		people.add(new Person("Cewr","Diiy",2));
		people.add(new Person("AZ","ras",3));
		people.add(new Person("TRa","gdfa",4));
		people.add(new Person("QWE","iouy",5));
		
		printByPredicate(people,p -> {
			if(p.getFirstName().startsWith("A")) {
				return true;
				}
			else {return false;}
		},
		System.out::println //method reference  (p) -> System.out.println(p)
		);
	
		//For In
		//External Iterators
		//Sequential 
		for(Person p : people) {
			//System.out.println(p);
		}
		
		//for Each
		//Internal Iterators
		//Can be run in multiple threads no order
		//consistent for parallelism
		people.forEach(System.out::println);
		
		//Top filter runs for every element the others depends on upper if it returns true.
		//Stream always has some source and operations
		people.stream()
		.filter(p->{
			System.out.println("filter-B");
			p.getFirstName().startsWith("B");
			return true;	
		})
		.filter(p->{
			System.out.println("filter-A");
			return p.getFirstName().startsWith("A");
		})
		//For Each is needed to run it
		//Terminal Operation
		.forEach(p->System.out.println("for each"));	
		
		System.out.println(people.stream().count());
		
		/*Lambda allows us to have a internal iteration that is we 
		 * let jvm do the execution on runtime. which helps in parallel processing
		 * 
		 * */
		
		//Returns a possibly parallel Stream with this collection as its source. 
		//It is allowable for this method to return a sequential stream. 
		System.out.println(people.parallelStream().count());
	}
	public static void printByPredicate(List<Person> people, Predicate<Person> predicateCondition, Consumer<Person> consumerBody) {
		for(Person p : people) {
			if(predicateCondition.test(p)) {
				consumerBody.accept(p);
			}
		}  
		System.out.println("----------------");	
	}

}

interface Process{
	public void process();
}
