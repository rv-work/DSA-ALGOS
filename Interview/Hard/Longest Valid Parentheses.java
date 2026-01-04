class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); 

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(i); // reset base
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }
}


// length = current index - last invalid index



// Step 0: Stack ka kaam kya hai?

// Stack '(' ke index store karta hai.
// Aur ek base index bhi rakhta hai taaki length easily nikle.

// Stack<Integer> st = new Stack<>();
// st.push(-1);

// ❓ -1 kyun?

// Socho string start se hi valid ho:

// s = "()"
// i = 1
// length = 1 - (-1) = 2 ✅


// Agar -1 na hota, calculation galat ho jaati.

// 👉 -1 = last invalid position before string starts








// Example:

// s = ")()"
// i = 0


// Koi matching ( nahi tha
// → ab future substring yahin se start hogi

// 👉 new base = current index





// Input
// s = "(()())"
// index: 0 1 2 3 4 5


// i	ch	stack	    ans
// -		[-1]	    0
// 0	(	[-1,0]	    0
// 1	(	[-1,0,1]    0
// 2	)	[-1,0]	    2
// 3	(	[-1,0,3]    2
// 4	)	[-1,0]	    4
// 5	)	[-1]	    6

// Final answer = 6