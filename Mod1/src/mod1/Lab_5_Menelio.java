package mod1;

public class Lab_5_Menelio {//PatternRecognistion_2DimMain
  public static void main(String[] args) {
/*    int[][] board = {
        {0, 1, 0, 6, 1, 6, 1},
        {0, 1, 6, 8, 6, 0, 1},
        {5, 2, 2, 1, 8, 2, 9},
        {6, 5, 6, 1, 1, 2, 1},
        {6, 9, 6, 2, 1, 9, 1},
        {3, 5, 9, 1, 3, 1, 1},
        {6, 5, 6, 3, 1, 9, 3},
        {1, 3, 6, 1, 9, 0, 7}    
    }; */
    
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter the number of rows: ");
    int numberOfRows = input.nextInt();
    System.out.print("Enter the number of columns: ");
    int numberOfColumns = input.nextInt();
    
    int[][] board = new int[numberOfRows][numberOfColumns];
    
//////////////////////Debugging    
    System.out.println("\n number of rows "+ (board.length));
    System.out.println("\n number of column "+ (board[0].length)+"\n");
///////////////////////
    
    System.out.println("Enter the array values: ");
    for (int i = 0; i < board.length; i++) {
    	for (int j = 0; j < board[i].length; j++) {
    		
    		board[i][j] = input.nextInt();
    	}
    }
    //print out array
    
    for(int i = 0; i < board.length;i++) {
    	for(int j = 0; j < board[0].length;j++) {
    		System.out.print(board[i][j]);
    	}
    	System.out.println();
    }
    
    System.out.print("\n"+isConsecutiveFour(board));
  }

  public static boolean isConsecutiveFour(int[][] values) {
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
///////////////////////Debugging
    				  System.out.println("Flag1"+" i= "+i+" j= "+j+" Data= "+values[i][j]+" Counter= "+counter);
////////////////////////////////
    				    // if counter = 4 return true  
    				    if(counter >= 4) {
    				    	return true;
    				    }
    				   
    			  }
    		  }
    		  //reset counter for next row
    		  counter = 0;
    	  }
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
///////////////////////Debugging
  				  System.out.println("Flag2"+" i= "+i+" j= "+j+" Data= "+values[i][j]+" Counter= "+counter);
////////////////////////////////
  				  // if counter = 4 return true  
  				  if(counter >= 4) {
  				  	return true;
  				  }
  			  }
  		  }
  		  //reset counter for next row
  		  counter = 0;
  	  }
    }
  
  counter = 0;
    
    
  
   // Get a column into an array
      
      
      
      
          
        
    // Check major diagonal (lower part)   
   
   
   
   
   
       
    // Check major diagonal (upper part)
   
   
   
   
   
   
   
   
    // Check sub-diagonal (left part)
    
    
    
    
    
    
    
    
        
    // Check sub-diagonal (right part)
    return false;
  }
}