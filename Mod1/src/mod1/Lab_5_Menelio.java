package mod1;

import java.util.Scanner;

public class Lab_5_Menelio {//PatternRecognistion_2DimMain
  public static void main(String[] args) {
	  
	  /*Test array
	  int[][] board = {
		        {9, 5, 0, 0, 9},
		        {9, 7, 0, 1, 0},
		        {0, 0, 1, 0, 0},
		        {6, 1, 0, 1, 0},
		        {1, 0, 0, 0, 1},
		     
	  };*/
	  //code to  Manually enter an array
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter the number of rows: ");
    int numberOfRows = input.nextInt();
    System.out.print("Enter the number of columns: ");
    int numberOfColumns = input.nextInt();
    
    int[][] board = new int[numberOfRows][numberOfColumns];
    
    System.out.println("Enter the array values: ");
    for (int i = 0; i < board.length; i++) {
    	for (int j = 0; j < board[i].length; j++) {
    		
    		board[i][j] = input.nextInt();
    	}
    }
    
	  
    //print out array
    System.out.println();
    for(int i = 0; i < board.length;i++) {
    	for(int j = 0; j < board[0].length;j++) {
    		System.out.print(board[i][j]);
    	}
    	System.out.println();
    }
    
    System.out.print("\n"+isConsecutiveFour(board));
  }

  public static boolean isConsecutiveFour(int[][] values) {
    //test Scanner
	 Scanner step = new Scanner(System.in);
	  
	int numberOfRows = (values.length);
    int numberOfColumns = (values[0].length);
	//counter for number of consecutive numbers
    int counter=0;

    // Check rows with nested for loop
    for (int i =0; i < numberOfRows;i++ ){
    	  for(int j = 0 ;j < numberOfColumns; j++ ) {
    		  //if to prevent out of index exception
    		  if ((j+1) < numberOfColumns) {
    			  //if current value = next value in row counter++
    			  if (values[i][j]==values[i][j+1]) {
    				  counter++;
    				    // if counter = 4 return true  
    				    if(counter >= 3) {
    				    
    				    	return true;
    				    }    				   
    			  }
    		  }
    	  }
    	//reset counter for next row
		  counter = 0;
      }
    counter = 0;
    // Check columns
    for (int i =0; i < numberOfRows;i++ ){
  	  for(int j = 0 ;j < numberOfColumns; j++ ) {
  		  //if to prevent out of index exception
  		  if ((j+1) < numberOfColumns) {
  			  //if current value = next value in row counter++
  			  if (values[j][i]==values[j+1][i]) {
  				  counter++;
  				  // if counter = 4 return true  
  				  if(counter >= 3) {
  					
  				  	return true;
  				  }
  			  }
  		  }
  	  }
  	  //reset counter for next row
  	  counter = 0;
    }
    //reset counter to 0
    counter = 0;         
   //check NW->SE diagonal
    outerFor:
    for(int i = 0; i <= numberOfRows;i++) {
	   innerFor:
	   for(int j =0; j <= numberOfColumns;j++) {
		  
		   //if there aren't enough rows blow break outerFor and move on to next row
		   if( (i+3) >= numberOfRows) {
			   
			   break outerFor;
			   
		   }
		   //if there aren't enough columns to the right break innerFor and move on to next row
		   if ( (j+3) >= numberOfColumns) {
			   
			   break innerFor;
		   }
		   //check values[i][j] for NW diagonal
		   if(values[i][j]==values[i+1][j+1]&& values[i][j]==values[i+2][j+2]&&values[i][j]==values[i+3][j+3]) {
			 
			   return true; 
		   }
		
	   }
   }
  //check NE->SW diagonal
    outerFor:
        for(int i = 0; i < numberOfRows;i++) {
    	   innerFor:
    	   for(int j =0; j < numberOfColumns;j++) {
    		  
    		   //if there aren't enough rows below break outerFor and move on to next row
    		   if( (i+3) >= numberOfRows) {
    			   break outerFor;
    		   }
    		   //if there aren't enough columns to the left break innerFor and move on to next row
    		   
    		   //check values[i][j] for NW diagonal
    		   if( !((j-3) < 0) &&values[i][j]==values[i+1][j-1]&& values[i][j]==values[i+2][j-2]&&values[i][j]==values[i+3][j-3]) {
    			  
    			   return true; 
    		   }
    		   
    	   }
       } 
    return false;
  }
}