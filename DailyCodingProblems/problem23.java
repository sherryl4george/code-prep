/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Trie {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        List<String> words;
        
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
            words = new ArrayList<>();
        }
    }

    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    
    /**
     * Recursive implementation of insert into trie
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }


    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //if end of word is reached then mark endOfWord as true on current node
            current.endOfWord = true;
            current.words.add(word);
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        //if node does not exists in map then create one and put it into map
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    public void searchRecursive(String word) {
        searchRecursive(root, word, 0);
    }
    
    private void searchRecursive(TrieNode current, String word, int index) {
        
        if(current.endOfWord){
        	System.out.println(current.words);
        	searchRecursive(root, word, index);
        	return;
        }
      	if (index == word.length()) {
            return;
        }       
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            searchRecursive(root, word, index + 1);
        	return;
        }
        searchRecursive(node, word, index + 1);
      
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] words = {"quick", "brown", "the", "fox"};
		String s = "thequickbrownfox";
		Trie t1 = new Trie();
		for(int i = 0;i<words.length;i++)
			t1.insertRecursive(words[i]);
		t1.searchRecursive(s);
		
	}
}