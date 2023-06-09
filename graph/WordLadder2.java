import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        ArrayList<String> usedWords = new ArrayList<>();
        usedWords.add(beginWord);

        int level = 0;
        List<List<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.remove();

            // erase all words that has been used in the previous levels to transform
            if (vec.size() > level) {
                level++;
                for (String it : usedWords) {
                    st.remove(it);
                }
            }
            String word = vec.get(vec.size() - 1);
            if (word.equals(endWord)) {
                if (ans.size() == 0)
                    ans.add(vec);
                else if (ans.get(0).size() == vec.size())
                    ans.add(vec);
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharsArr[] = word.toCharArray();
                    replacedCharsArr[i] = ch;
                    String replacedString = new String(replacedCharsArr);
                    if (st.contains(replacedString)) {
                        vec.add(replacedString);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedWords.add(replacedString);
                        vec.remove(vec.size() - 1);
                    }
                }
            }

        }

        return ans;
    }
}