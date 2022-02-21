import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AppMain {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Adfa","Bjhgj",1));
		people.add(new Person("a","Diiy",2));
		people.add(new Person("Cewr","Diiy",2));
		people.add(new Person("AZ","ras",3));
		people.add(new Person("TRa","gdfa",4));
		people.add(new Person("QWE","iouy",5));
		
		printAll(people);
		
		people.sort((Person o1, Person o2) ->  o1.getFirstName().compareTo(o2.getFirstName()));
		
		
		
		printAll(people);
		
		//we can pass lambdas where functional interfaces are present. 
		
		printByCondition(people,(Person person)->  person.getFirstName().toUpperCase().startsWith(new String("a").toUpperCase()));	
		
		//By using java's Generic predicate way which has a "boolean test(T t)" method.
		printByPredicate(people,(Person person)->  person.getFirstName().toUpperCase().startsWith(new String("c").toUpperCase()));
		int a =2,b=5;
		//Lambda Exception handling or proxy or plugable logic example adding 
		lamdaCalculate(a,b,lambdaException((v,k)-> System.out.println("Adding: "+(v+k))));
		//Lambda Exception handling or proxy or plugable logic example multiplying
		lamdaCalculate(a,b,lambdaException((v,k)-> System.out.println("multiplying: "+(v*k))));
		
	}
	
	public static void printAll(List<Person> people) {
		for(Person p : people) {
			System.out.println(p.getFirstName());
		}
		System.out.println("----------------");
	}
	
	public static void printByCondition(List<Person> people, StringFilter filter) {
		for(Person p : people) {
			if(filter.condition(p)) {
				System.out.println("Functional Interface way: "+p.getFirstName());
			}
		}
		System.out.println("----------------");
	}
		
	public static void printByPredicate(List<Person> people, Predicate<Person> predicate) {
		for(Person p : people) {
			if(predicate.test(p)) {
				System.out.println("Generic Predicate way: "+p.getFirstName());
			}
		}  
		System.out.println("----------------");	
	}
	
	public static void lamdaCalculate(int a, int b, BiConsumer<Integer, Integer> consumer){
		System.out.println("In lambdaCalculate");
		//both different objects
		consumer.accept(a, b);
		System.out.println(consumer);
	}
	
		
	//Exception handling in lambda
	public static BiConsumer<Integer,Integer> lambdaException(BiConsumer<Integer, Integer> consumer) {
		System.out.println("In lambdaException");
		//Proxy type basically
		//this block only executes on accept method called on it
		return (v,k) -> {
			try {
				System.out.println("In try block");
				//here in this we have println method for plugable logic
				consumer.accept(v, k);
				System.out.println(consumer);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		};
	}
		
	
}
