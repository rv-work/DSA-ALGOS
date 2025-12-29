class Solution {

    void res(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> li) {
        if (root == null) return;

        li.add(root.val);
        targetSum -= root.val;

        if (targetSum == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(li)); 
            // ans.add(li)------ wrong because ref add hota hai to jab vo list change hogi to asn ke ander bhi change ho jayegi 


        }

        res(root.left, targetSum, ans, li);
        res(root.right, targetSum, ans, li);

        li.remove(li.size() - 1); // backtrack
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        res(root, targetSum, ans, new ArrayList<>());
        return ans;
    }
}








// 🔴 Core baat sirf itni hai
// ans.add(li);   // ❌ galat
// ans.add(new ArrayList<>(li)); // ✅ sahi


// kyu?
// kyunki li ek hi list hai jo bar-bar change ho rahi hai.

// 🧠 Pehle ye samjho: Reference kya hota hai

// Java me:

// List<Integer> li = new ArrayList<>();


// 👉 li data nahi, balki address (reference) rakhta hai.

// Agar tum likhte ho:

// ans.add(li);


// to ans me list ki COPY nahi,
// sirf uska address ja raha hai.

// 🔁 Ab backtracking ke saath kya hota hai
// maan lo tree ye hai:
//     5
//    / \
//   4   8


// target = 9

// Step-by-step dry run:
// 1️⃣ root = 5
// li = [5]

// 2️⃣ left = 4
// li = [5, 4]
// targetSum = 0


// 👉 condition true → tumne likha:

// ans.add(li);


// ab:

// ans = [[5, 4]]   // lagta hai sab sahi

// 3️⃣ Backtracking hoti hai
// li.remove(li.size() - 1);


// ab:

// li = [5]


// 💥 SURPRISE

// ans = [[5]]


// ❓ kyu?
// kyunki ans ke andar wahi list ka reference tha
// aur tumne usi list se element remove kar diya.

// 🎯 Isliye COPY banana zaroori hai

// Jab tum likhte ho:

// ans.add(new ArrayList<>(li));


// to kya hota hai?

// ek nayi list banti hai

// usme current li ke values copy hoti hain

// future changes ka koi effect nahi

// Example:
// li = [5,4]
// ans.add(new ArrayList<>(li)) // ans = [[5,4]]

// li.remove(4)

// li = [5]
// ans = [[5,4]] ✅ SAFE

// 🧠 Real-life analogy (easy)

// Socho:

// li = ek whiteboard

// tum likh rahe ho numbers

// ans.add(li) = whiteboard ka photo nahi,
// balki whiteboard hi utha ke rakh diya

// baad me tum whiteboard erase karte ho
// → photo bhi erase ho jaata hai 😄

// new ArrayList<>(li) = photo click kar li