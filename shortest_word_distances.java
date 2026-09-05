import java.util.*;

class shortest_word_distances {

    public List<Integer> shortest_word_distances( List<String> word,    List<List<String>> queries) {

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < word.size(); i++) {
            map.computeIfAbsent(word.get(i), k -> new ArrayList<>()).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (List<String> query : queries) {
            String word1 = query.get(0);
            String word2 = query.get(1);
            List<Integer> a = map.get(word1);
            List<Integer> b = map.get(word2);
            int i = 0;
            int j = 0;
            int min = Integer.MAX_VALUE;
            while (i < a.size() && j < b.size()) {
                min = Math.min(min, Math.abs(a.get(i) - b.get(j)));
                if (a.get(i) < b.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }

            ans.add(min);
        }

        return ans;
    }

    public static void main(String[] args) {
        shortest_word_distances sol = new shortest_word_distances();
        List<String> words1 = Arrays.asList(   "practice", "makes", "perfect", "coding", "makes"  );
        List<List<String>> queries1 = Arrays.asList(    Arrays.asList("coding", "practice"),   Arrays.asList("makes", "coding")  );
        System.out.println(sol.shortest_word_distances(words1, queries1));
        List<String> words2 = Arrays.asList(   "a", "b", "a", "c", "b");
        List<List<String>> queries2 = Arrays.asList(
                Arrays.asList("a", "b"), Arrays.asList("a", "c"),
                Arrays.asList("b", "c")
        );

        System.out.println(sol.shortest_word_distances(words2, queries2));
        List<String> words3 = Arrays.asList(    "x", "y", "z");
        List<List<String>> queries3 = Arrays.asList( Arrays.asList("x", "z"),   Arrays.asList("y", "z") );
        System.out.println(sol.shortest_word_distances(words3, queries3));
       
    }
}