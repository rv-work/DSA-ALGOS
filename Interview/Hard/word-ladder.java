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








class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Map<String, List<String>> map = new HashMap<>();

        int L = beginWord.length();

        // Build pattern map
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(beginWord);
        vis.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                String curr = q.poll();
                if (curr.equals(endWord)) return level;

                for (int i = 0; i < L; i++) {
                    String pattern = curr.substring(0, i) + '*' + curr.substring(i + 1);

                    for (String next : map.getOrDefault(pattern, new ArrayList<>())) {
                        if (!vis.contains(next)) {
                            vis.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
