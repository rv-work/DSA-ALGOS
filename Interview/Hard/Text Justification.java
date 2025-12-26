class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int currLength = 0;
            int cnt = 0;
            int k = i;

            // pick words for one line
            while (k < n && currLength + cnt + words[k].length() <= maxWidth) {
                currLength += words[k].length();
                cnt++;
                k++;
            }

            String line = "";

            // not last line
            if (k < n) {
                int rem = maxWidth - currLength;
                int gaps = cnt - 1;

                // single word
                if (gaps == 0) {
                    line += words[i++];
                    while (line.length() < maxWidth) line += " ";
                    res.add(line);
                    continue;
                }

                int each = rem / gaps;
                int extra = rem % gaps;

                while (i < k) {
                    line += words[i++];
                    if (i < k) {
                        for (int s = 0; s < each; s++) line += " ";
                        if (extra-- > 0) line += " ";
                    }
                }
            } 
            // last line
            else {
                while (i < k) {
                    line += words[i++];
                    if (i < k) line += " ";
                }
                while (line.length() < maxWidth) line += " ";
            }

            res.add(line);
        }
        return res;
    }
}
