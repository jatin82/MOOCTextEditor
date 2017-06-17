package spelling;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		String lowerCaseWord = word.toLowerCase();
		char[] charArray = lowerCaseWord.toCharArray();
		TrieNode currTrieNode = root;
		
		for (char letter: charArray){
			TrieNode child = currTrieNode.getChild(letter);
			if (child != null){
				currTrieNode = child;
			} else {
				currTrieNode = currTrieNode.insert(letter);
			}
		}
		
		
		
		if (currTrieNode.endsWord()){
			return false;
		} else {
			currTrieNode.setEndsWord(true);
			size++;
			return true;
		}
		
	
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
		String lowerCaseWord = s.toLowerCase();
		if (lowerCaseWord.isEmpty()){
			return false;
		}
		char[] charArray = lowerCaseWord.toCharArray();
		TrieNode currTrieNode = root;
		
		for (char letter: charArray){
			TrieNode child = currTrieNode.getChild(letter);
			if (child == null){
				return false;
			} else if (currTrieNode.getText().equals(lowerCaseWord)) {
				return true;
			} else {
				currTrieNode = child;
				
			}
		}
		if (currTrieNode.getText().equals(lowerCaseWord)) {
			return true;
		} else {
			return false;
		}
		//return false;
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	String lowerCaseWord = prefix.toLowerCase();
	
		char[] charArray = lowerCaseWord.toCharArray();
		TrieNode currTrieNode = root;
		TrieNode stem = null;
		List<String> completions = new ArrayList<String>();
		LinkedList<TrieNode> queue = new LinkedList<TrieNode>();
		
		
		if (prefix.isEmpty()){
			stem = root;
			
		} else {
			
			for (char letter: charArray){
				TrieNode child = currTrieNode.getChild(letter);
				if(child == null){
					return completions;
				}
				else if (child.getText().equals(lowerCaseWord)) {
					stem = child;
					break;
				} else {
					
					currTrieNode = child;
				}
			}
		}
		this.printNode(stem);
		if (stem == null){
			return completions;
		}
		queue.add(stem);
		
		while (!queue.isEmpty() && completions.size() < numCompletions) {
			TrieNode firstNode = queue.removeFirst();
			
			if (firstNode.endsWord()){
				completions.add(firstNode.getText());
				
			}
			for (char nextChar : firstNode.getValidNextCharacters()){
				queue.addLast(firstNode.getChild(nextChar));
			}
		}
    	 
    	 
		return completions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}