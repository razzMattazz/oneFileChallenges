/**********************************
We want to create a package of chocolate that has a certain mass. We have small bars (1 kilo each) and big bars (5 kilos each). Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.

I added a test method that generates 15 random positive integers, calls the makeChocolate method, and prints the results to cmd.
************************************/
/**SOLUTION BY: Matthew Vaughn*/

import java.util.*;

public class MakeChocolate {
	
	public int makeChocolate(int small, int big, int goal) {

		int barsUsed = 0;
	
		while(goal != 0) {
			if (big !=0 && goal >= 5) {
				big--;
				goal = goal - 5;
			}
			else if (small != 0 && goal != 0) {
				small--;
				goal = goal -1;
				barsUsed++;
			}
			if(small == 0 && goal !=0) {
			  goal = 0;
			  barsUsed = -1;
			}
		}
		
		return barsUsed;
		
	}
	
	public void test() {
		Random random = new Random();
		
		int s, b, g;
		
		for(int i = 0; i < 15; i++) {
			s = Math.abs(random.nextInt()) % 40;
			b = Math.abs(random.nextInt()) % 100;
			g = Math.abs(random.nextInt()) % 100;
			System.out.print("Test "+(i+1)+" Inputs:("+s+", "+b+", "+g+")");
			System.out.println(" Results: " +makeChocolate(s, b, g));
		}
			
		
	}

		
	public static void main(String[] args) {
		MakeChocolate mc = new MakeChocolate();
		mc.test();
	}
}