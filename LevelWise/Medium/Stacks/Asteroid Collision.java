//  [Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();

        for (int a : ast) {
            boolean alive = true;
            while (alive && a < 0 && !st.isEmpty() && st.peek() > 0) {
                if (st.peek() < -a) {
                    st.pop(); 
                } else if (st.peek() == -a) {
                    st.pop(); 
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
