
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

// Arrays.asList(T...) and usage of varargs
class ArraysAsList{
	ArraysAsList(){
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Show the usage of Arrays.asList(T...a)");
		System.out.println("Initial a List using array of String");
		String[]str = {"hello","bye"};
		List<String> los = Arrays.asList(str);
		System.out.println("List<String> can't be cast to List<Object>");
		
		
		Object[]integ = {1,2,3,4,5};
		// The usage of varargs in T...
		List<Object> lofint = Arrays.asList((Object[])integ);
		System.out.println("pass arr of Integer as varargs");
		System.out.println("List is"+lofint);
		
		// pass in array as an Object 
		List<Object> lofarr = Arrays.asList((Object)integ);
		System.out.println("pass arr of integer as one object");
		System.out.println("memory address of list is"+lofarr);
		Object []mixed ={new Object(), new String("hello"), new Integer(1)};
		List<Object> lofmix = new ArrayList<>(Arrays.asList(mixed));
		List lf = lofmix;
		for(Object c:lofarr)
			System.out.println(c);
		
		
	}
}
// Array.asList<T...> usage for generic type inference
class TypeInference{
	TypeInference(){
		Demiliter.printDemiliter(this.getClass());
		List<Object> lofO = new ArrayList<>(Arrays.asList(1,"2",new Integer(3)));
		System.out.println("Arrays.asList(T...) will conclude the most common type of the varargs passed in.");
		
		// Run the remove(0) for Arrays.asList(T...) list
		
		opReturnList();
		
		showTypeInference();
	}
	class S implements Comparable<String>{
		@Override
		public int compareTo(String o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	class child1 extends S {

	}
	class child2 extends S{
		
	}
	// show type inference of T...
	void showTypeInference(){
		System.out.println("Type inference in Java:");
		System.out.println("The lowest common parent of type Integer and Float is Object, since Integer, Float not only extends Number but also implemments Comparable");
		System.out.println("The type inference for Integer and Float is Type Object");
		
		List<Object> list = new ArrayList<>(Arrays.asList(new Integer(1),new Float(1)));
		System.out.println("Runtime class of list of integer and float"+	list.getClass());
		
		System.out.println("Enable to do type inference if only there's one lowest common parent available.");
		
		List<S> los = new ArrayList<>(Arrays.asList(new child2(),new child1()));
		System.out.println("Runtime class of list of child1 and child2"+	los.getClass());
	}
	// show Arrays.asList(T...) return is a read-only list
	void opReturnList(){
		System.out.println("Arrays.asList() returns a read-only list");
		System.out.println("Remove(0) on Arrays.asList().");
		int []pia = new int[]{1,2,3};
		Integer [] wi = new Integer[]{1,2,3};
		Object oall = pia;
		oall = wi;
		System.out.println("Using new ArrayList(Arrays.asList()).");
		List<Integer> li = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3})); // Can't cast from int[] to Integer[]
		System.out.println("List before remove the first:"+li);
		li.remove(0);
		System.out.println("List after remove the first:"+li);
		
		System.out.println("Operate remove on Arrays.asList() plain return result");
		List<Integer> l = Arrays.asList(new Integer[]{1,2,3,4});
		try{
			l.remove(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Unsupported Exception caught in remove operation.");
			System.out.println("FYI. Exception thrown after executed the finally block");
		}
		
	}
}

// ArrayDeque usage
class ArrayDequeTest{
	ArrayDequeTest(){
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Test the use of ArrayDeque.");
		Integer []arr ={1,2,3,4};
		Deque<Integer> dq = new ArrayDeque<>();
		System.out.println("Add List<Integer> as Collection<? extends Integer>.");
		dq.addAll(Arrays.asList((Integer[])arr));
		System.out.println("List before remove:"+dq);
		// ArrayDeque remove
		System.out.println("One element removed:"+dq.remove());
		
		System.out.println("List after remove"+dq);
		Iterator<Integer> it = dq.iterator();
		System.out.println("Remove the left using the iterator.remove()");
		while(it.hasNext()){
			System.out.println("element:"+it.next());
			it.remove();
			
		}
	}
}
// WildCard Type Safe 
class TypeSafeWC{
	public TypeSafeWC() {
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Declaring list of String, list of Object, list of any types");
		List<String> lofStr = new ArrayList<>(); 
		List<Object> lofO = new ArrayList<>();
		List lofany = new ArrayList<>();
		
		//Pass in list of String
		System.out.println("Pass lof String to List<?>");
		typeSafePass(lofStr);
		System.out.println("Pass lof Object to List<?>");
		typeSafePass(lofO);
		System.out.println("Pass lof raw types to List<?>");
		typeSafePass(lofany);
		
		System.out.println("Pass Object types into Object types List");
		typeSafePassAgain(lofany);
		
		System.out.println("Pass lof O, lof String, lof raw into Raw types");
		typeSafePassAg(lofStr);
		typeSafePassAg(lofany);
		typeSafePassAg(lofO);
		System.out.println("Raw types should not be used in new code.");
		System.out.println("It's only allowed for compatability.");
	}
	void typeSafePassAg(List l){
		l.add(new Integer(1));
	}
	void typeSafePassAgain(List<Object> l){
		l.add(new Integer(1));
	}
	void typeSafePass(List<?> l){
		
	}
}
// Java built-in primitive Type cast and AutoBoxing/Unboxing
class TypeCastAutoBoxing{
	public TypeCastAutoBoxing() {
		// TODO Auto-generated constructor stub
		Demiliter.printDemiliter(this.getClass());
		System.out.println("Cast char to int");
		int a = '0';
		float f = '0';
		long l = 10L; // 10l
		System.out.println("int a = '0', a="+a);
		System.out.printf("PRINT a in char: a = %c, f in double f= %f\n",a,f);
		
		System.out.println("float f = '0', f="+f);
	}
}

public class Questions{
	public static void main(String[]arg){
		//ArrayDeque Test
		ArrayDequeTest art = new ArrayDequeTest();
		
		// Arrays.asList(T...) usage demo
		ArraysAsList aal = new ArraysAsList();
		
		// Type inference checking
		TypeInference ti = new TypeInference();
		
		// Type Cast etc
		TypeCastAutoBoxing tcab = new TypeCastAutoBoxing();
		
	}
}