package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author andrii
 */

public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
        int i = 0;
        for (String s: strings)
            for (String word: s.split(" "))
                if (word.length() > 2 && !contains(word)) {
                    Tuple t = new Tuple(word, word.length());
                    trie.add(t);
                    i++;
                }
        return i;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        return trie.wordsWithPrefix(pref);
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        ArrayList<String> res = new ArrayList<>();
        int lenAmount = 0;
        int currLength = 0;
        for (String word : trie.wordsWithPrefix(pref)) {
            if (word.length() != currLength) {
                lenAmount++;
                currLength = word.length();
            }
            if (lenAmount > k) break;
            res.add(word);
        }
        String[] result = Arrays.copyOf(res.toArray(), res.toArray().length, String[].class);
        return () -> Arrays.stream(result).iterator();
    }

    public int size() {
        return trie.size();
    }
}
