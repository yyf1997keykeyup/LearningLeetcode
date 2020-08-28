package Design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem {
    class Trie {
        Trie[] children = new Trie[26];
        PriorityQueue<String> suggestions = new PriorityQueue<>();
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String product : products) {
            insert(product, root);
        }
        return trieSearch(searchWord, root);
    }
    private void insert(String p, Trie root) {
        Trie t = root;
        for (char c : p.toCharArray()) {
            if (t.children[c - 'a'] == null) {
                t.children[c - 'a'] = new Trie();
            }
            t = t.children[c - 'a'];
            t.suggestions.offer(p);
            if (t.suggestions.size() > 3) {
                t.suggestions.poll();
            }
        }
    }
    private List<List<String>> trieSearch(String searchWord, Trie root) {
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            List<String> subList = new ArrayList<>();
            if (root != null) {
                root = root.children[c - 'a'];
            }
            if (root != null) {
                subList.addAll(root.suggestions);
                Collections.sort(subList);
            }
            ans.add(subList);
        }
        return ans;
    }
}
