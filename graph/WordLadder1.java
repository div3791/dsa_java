import java.util.*;

public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty())
            return 0;

        Set<String> set = new HashSet<>();
        int len = wordList.size();

        for (int i = 0; i < len; i++) {
            set.add(wordList.get(i));
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<String, Integer>(beginWord, 1));

        set.remove(beginWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().first;
            int steps = queue.peek().second;
            queue.remove();
            if (word.equals(endWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char replacedWord[] = word.toCharArray();
                    if (ch == replacedWord[i])
                        continue;
                    replacedWord[i] = ch;
                    String replaced = new String(replacedWord);
                    if (set.contains(replaced)) {
                        set.remove(replaced);
                        queue.add(new Pair<String, Integer>(replaced, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}
