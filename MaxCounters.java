class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int max_counter = 0;
        int curr_max_element = 0;
        int[] ret_counters = new int[N];
        int M = A.length;
        int X;
        
        for(int k=0; k<M; k++) {
            X = A[k] - 1;
            //System.out.format("\nk=%d, X=%d, X < N + 1:%s",k, X, X < N);
            if(X < N ) { // increase(X)
                int counter_x = Math.max(ret_counters[X], max_counter);
                //System.out.format("\ncounter_x=%d, curr_max_element=%d, max_counter=%d",counter_x, curr_max_element, max_counter);
                if(counter_x >= curr_max_element) {
                    //System.out.println("\n\tcounter_x >= curr_max_element");
                    curr_max_element = ret_counters[X] = ++counter_x;
                    //System.out.format("\n\tcounter_x=%d, curr_max_element=%d, max_counter=%d",counter_x, curr_max_element, max_counter);
                } else {
                    //System.out.println("\n\tELSE counter_x >= curr_max_element");
                    ret_counters[X] = ++counter_x;
                    //System.out.format("\n\tcounter_x=%d, curr_max_element=%d, max_counter=%d",counter_x, curr_max_element, max_counter);
                }
            } else { // operation max_counter
                max_counter = curr_max_element;
            }
        }
        for(int i=0; i<N; i++) {
            ret_counters[i] = Math.max(ret_counters[i], max_counter);
        }
        return ret_counters;
    }
}