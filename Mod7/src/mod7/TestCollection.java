package mod7;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestCollection {
  public static void main(String[] args) {
	  //set initializes ques 
	  PriorityQueue<String> pQueue1 = new PriorityQueue<>();
	  pQueue1.add("George");
	  pQueue1.add("Jim");
	  pQueue1.add("John");
	  pQueue1.add("Blake");
	  pQueue1.add("Kevin");
	  pQueue1.add("Michael");
	  
	  PriorityQueue<String> pQueue2 = new PriorityQueue<>();
	  pQueue2.add("George");
	  pQueue2.add("Katie");
	  pQueue2.add("Kevin");
	  pQueue2.add("Michelle");
	  pQueue2.add("Ryan");
	  
	  System.out.println("Priority Queue1= "+pQueue1);
	  System.out.println("Priority Queue2= "+pQueue2+"\n");
	  
	  //find union of Priority Queue1 and Priority Queue2
	  System.out.println("Union of Priority Queue1 and Priority Queue2= "+union(pQueue1, pQueue2)+"\n");
	  
	  //find difference 
	  System.out.println("Priority Queue1 - Priority Queue2= "+ difference(pQueue1,pQueue2));
	  System.out.println("Priority Queue2 - Priority Queue1= "+ difference(pQueue2,pQueue1)+"\n");
	  
	  //find intersection of Priority Queue1 and Priority Queue2
	  System.out.println("Intersection of Priority Queue1 and Priority Queue2= "+intersection(pQueue1, pQueue2)+"\n");
	  
	  
  }
  //method for finding union of two Priority Queues
  public static PriorityQueue<String> union(PriorityQueue<String> pQueue1, PriorityQueue<String> pQueue2) {
	 //create priority queue to return
	 PriorityQueue<String> q = new PriorityQueue<String>();
	 //add first priority queue to return queue
	 q.addAll(pQueue1);
	 //get iterator for second priority queue 
	 Iterator<String> it = pQueue2.iterator();
	 //add second priority queue to return queue without creating duplicates
	 while(it.hasNext()) {
		 String s = it.next();
		 if(!q.contains(s)) {
			 q.add(s);
		 }
	 }
	 //return union of two queues
	 return q;
  }
  public static PriorityQueue<String> difference(PriorityQueue<String> pQueue1, PriorityQueue<String> pQueue2){
	  //create priority queue to return
	  PriorityQueue<String> q = new PriorityQueue<String>();
	  //add pQueue1 to q
	  q.addAll(pQueue1);
	  //remove pQueue2 from q
	  q.removeAll(pQueue2);
	//return difference of two queues
	  return q;
  } 
  public static PriorityQueue<String> intersection(PriorityQueue<String> pQueue1, PriorityQueue<String> pQueue2){
	  //create priority queue to return
	  PriorityQueue<String> q = new PriorityQueue<String>();
	  //set q = to first priority queue
	  q = pQueue1;
	  //find intersection using retainAll method
	  q.retainAll(pQueue2);
	  //return intersection of two queues
	  return q;
  }
}
