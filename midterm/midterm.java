package midterm;

import java.util.Scanner;

interface a {
    public char whoAmI();
}

class Cup implements a{
	public char whoAmI() {
	    return 'C';
	}
}
class Ball implements a{
	public char whoAmI() {
	    return 'B';
	}
}

class Hat implements a {
	public char whoAmI() {
	    return 'H';
	}
}

class Pen implements a {
	public char whoAmI() {
	    return 'P';
	}
}	
class Und implements a {
	public char whoAmI() {
		return 'U';
	}
}


public class midterm{

	public static void main(String[] args) {
		
            //determine the order in this string
		    //create a grid for this letters
		    String order = "CPCHPBUBH";
		    a[][] grid = new a[3][3];
		    
		    //create objects and placed them in the grid
		    createObj(grid,order);
		    
		    offGrid(grid,order);
		    

	}

	public static void createObj(a[][] grid, String order) {

		int index=0;
		//we have to write a loop for the grid
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				//we should get the object type from the string and we can use charAt 
				//and we should write index++ beause it have to scan al the letters in it
				
				char objLetter=order.charAt(index++);
				
				//create objects and placed them in the grid
				if(objLetter=='C') {
					grid[i][j] = new Cup();
				}
				else if(objLetter=='B') {
					grid[i][j] = new Ball();
				}
				else if(objLetter=='H') {
					grid[i][j] = new Hat();
				}
				else if(objLetter=='P') {
					grid[i][j] = new Pen();
				}
				else if(objLetter=='U') {
					grid[i][j] = new Und();
				}
			}
		}
	}
	
	//4.que
	public static void offGrid(a[][] grid, String order) {
		//we have to write this grid with x's
		//actually we create new matrix for the close term
		char [][] matrix = new char[3][3]; 
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				matrix[i][j] = 'X';
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		//5.que
		//we have to use scanner because we are taking inputs from user
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i<9; i++) {
			System.out.print("please enter row-col location:");
			int row= scanner.nextInt();
			int col=scanner.nextInt();
			
			if(matrix[row][col] != grid[row][col].whoAmI()) {
				matrix[row][col] = grid[row][col].whoAmI();
				
			for(int t=0; t<3; t++) {
				for(int z=0; z<3; z++) {
					System.out.print(matrix[t][z] + " ");
				}
				System.out.print("\n");
			}
			}
			else {
				//this mean is unidentified is in that place
				System.out.print("\nit is already uncovered\n");
			}
		}
		//6.que
		    scanner.nextLine();
			System.out.print("do you want to continue?\n");
			String answer = scanner.nextLine();
			String Continue = "yes";
			//checking the answer
			if(answer.equals(Continue)) {
				//we have to write a loop for see the matrix
				for(int z=0; z<3; z++) {
					for(int x=0; x<3; x++) {
						matrix[z][x]='X';
						System.out.print(matrix[z][x]);
					}
					System.out.print("\n");
				}
			}
		
		System.out.print("write your guess in uppercase:\n");
		String output = scanner.nextLine();
	
		char[] Answer = order.toCharArray();
		char[] Answer2 = output.toCharArray();
		
		int count=0;
		int count2=0;
		//this for loop is checking the answer part and part 
		for(int i=0; i<9; i++) {
			if(Answer2[i]==Answer[i]) {
				count++;
				//if our guesses letters are correct this count is going up
			}
			else {
				count2++;
				//it is counting for the opposite way
			}
		}
		if(count>=4) {
			System.out.print("you win");
		}
		else {
			System.out.print("you lose,try it again");
		}
    }

	}



