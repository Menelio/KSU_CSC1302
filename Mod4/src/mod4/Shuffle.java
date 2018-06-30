package mod4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Shuffle {

	public static void main(String[] args) {
		//create an ArrayList<Number> of numbers 1-6 
		ArrayList<Number> list = new ArrayList<Number>();
		//add them to array in no particular order
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(3);
		list.add(6);
		//sort and shuffle printing out results each time
		//Without using collections FrameWork
		System.out.println("Default list\n"+list.toString());
		sort(list);
		System.out.println("List sorted without using Collections Frame Work\n"+list.toString());
		shuffle(list);
		System.out.println("List shuffled without using Collections Frame Work\n"+list.toString());
		//Using collections FrameWork
		sortUsingCollectionFW(list);
		System.out.println("List sorted using Collections Frame Work\n"+list.toString());
		shuffleUsingCollectionFW(list);
		System.out.println("List shuffled using Collections Frame Work\n"+list.toString());
		

	}
	//sort without using Collections framework 
	public static void sort(ArrayList<Number> list) {
		//int array for sort
		int[] sort=new int[list.size()];
			
		//for loop for transferring list to sort
		for(int i=0;i < list.size();i++) {
			sort[i]=list.get(i).intValue();
		}
		//sort sort array
		Arrays.sort(sort);
		//remove elements from list
		list.removeAll(list);
		//put elements back in list
		for(int i=0;i < sort.length;i++) {
			list.add(sort[i]);
				
		}		
	}	
	//sort using Collections framework
	public static void sortUsingCollectionFW(ArrayList<Number> list) {
		Collections.sort(list, null);	
	}
	
	//shuffle without using Collections Framework
	public static void shuffle(ArrayList<Number> list) {
		//int array for sort
		int[] sort=new int[list.size()];
					
		//for loop for transferring list to sort
		for(int i=0;i < list.size();i++) {
			sort[i]=list.get(i).intValue();
		}
		//remove elements from list
		list.removeAll(list);
		//place elements back in shuffled order
		//array to hold indexs already used
		int[] indexs= new int[sort.length];
		//populate indexs with -1
		for(int i=0; i < indexs.length; i++) {
			indexs[i]=-1;
		}
		int currentIndex=0;
		int h=0;
		shuffle:
		while(true) {
			currentIndex=(int) (Math.random()*sort.length);
			checkCurrentIndex:
			{
				for(int i =0; i<indexs.length;i++) {
					if(currentIndex==indexs[i]) {
						//System.out.println("broke checkCurrentIndex indexs[i]="+indexs[i]+" currentIndex="+ currentIndex);
						break checkCurrentIndex;
					}
					//System.out.println("Forloop checkCurrentIndex: i= "+i+" currentIndex= "+currentIndex);
				}
				list.add(sort[currentIndex]);
				indexs[h]=currentIndex;
				h++;
				//System.out.println("Assigning h="+h+" indexs= "+Arrays.toString(indexs)+" list= "+list.toString());
				if(h>=sort.length)break shuffle;
				
			}
		}
	}
	//shuffle using Collections framework
	public static void shuffleUsingCollectionFW(ArrayList<Number> list) {
		Collections.shuffle(list);
	}
	
}
