// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        int counter = 0;
        int start = (int)Math.sqrt(N);
        if(start * start == N) { counter--; } // ex. 25 -> don't count 5 as 2 factors!
        
        for(int div = start; div>=1; div--) {
            if(N % div == 0) { counter +=2; }        
        }
        
        return counter;
    }
}
