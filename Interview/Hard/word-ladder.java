class Solution {


    private boolean checkDiff(String s1 , String s2){
        int diff = 0;
        for(int i = 0; i< s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }

        return diff == 1;
    }

     public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(beginWord);
        vis.add(beginWord);

        int level = 1;

        while(!q.isEmpty()){

            int size = q.size();  

            for(int i = 0; i < size; i++){

                String str = q.poll();

                if (str.equals(endWord)) return level;

                for(String word : wordList){
                    if(!vis.contains(word) && checkDiff(word, str)){
                        vis.add(word);
                        q.add(word);
                    }
                }
            }

            level++;  
        }

        return 0;
        
    }
}