package mod1;

public class LabAssignmentArrays {

	public static void main(String[] args) {
		int array[][] = { { 3, 2, 5 }, { 2, 2, 4, 5, 6 }, { 1, 1 } };

		 System.out.println( mystery( array ) );

	}
	public static int mystery( int values[][] )
	{
	    int mystery = 1;
	    for ( int i[] : values )
	        for ( int j : i )
	            mystery *= j;
	    return mystery;
	}

}
