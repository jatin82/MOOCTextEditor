# MOOCTextEditor
Text editor project for Data Structures and Algorithms Course UCSD

Starter Code and GUI Application for Course 2 in the
Java Programming: Object Oriented Design of 
Data Structures Specialization:

[Data structures: Measuring and Optimizing Performance]
(https://www.coursera.org/learn/data-structures-optimizing-performance)

Authored by UCSD MOOC Team:
Mia Minnes, Christine Alvarado, Leo Porter, Alec Brickman
and Adam Setters

Date: 10/29/2015


## DESCRIPTION

The files provided are skeleton code, as well as grading previews and 
testing files to be used in completing the course programming 
assignments. Additionally, you are provided a runnable JavaFX program 
which will help to test and demonstrate your implementations.

## FILES AND OUTCOMES BY WEEK

Below are the files and outcomes introduced in each week and used in each week
of the course. See file for description...

## Week 1 : Introduction and Working with Strings
document.Document.java
document.BasicDocument.java

Describe how the Flesch Readability Score can be used to determine the readability of text
- Quantify how readable a piece of text is
- High score when short sentences and short sentences, with less syllables per word
Describe how Strings are represented in Java
- strings are objects, actually they are an array of characters (char primitive type)
- strings are immutable, no way to change a string in memory
- java has a mechanism to deal with strings in memory to save memory, i.e. if strings are immutable they could take up lot of heap space ... interned string object, similar strings will reference the same object in memory
Perform basic operations with Strings in Java
	
Work with the String class's built-in methods to manipulate Strings
- String.equals() will return true if content of string is equal i.e. all of the characters are the same. It won't (false) if you use == because this compare objects, even if the strings have the same characters two different objects are holding those 
Write regular expressions to match String patterns
Use regular expressions to split strings


## Week 2 : Efficiency Analysis and Benchmarking
document.EfficientDocument.java

Explain why the performance of an algorithm is important
- Relates back to user experience, if a program takes too long to run users not happy.
- Algorithm strategy for solving a prob
- can't use stopwatch/timer, computer's hardware will slow down program, different libraries for a given language
- measure the number of operations (we control this), focus on how performance scales  (how does operations grow as input grows), go beyond input size
Describe some factors that impact the performance of an algorithm
- number of iterations, number of operations
Explain why asymptotic analysis is useful
- If doing asymtotic analysis no need to worry about initialization time, implementations of specific operations
- n typically represents the size of the input
- constant time, input size doesn't affect number of operations
- linear time, grows linearly in terms of the size of its input
- f(n) = O(g(n)) = Big O Classes f(n) and g(n) grow in the same way as their input grows
Calculate the big-O class of a code snippet
- Big O notation captures the rate o growth of two functions
Combine the runtimes of smaller code snippets to analyze the performance of more complicated code
Compute the big-O class of code with nested loops
- (O)n^2
Analyze the performance of selection sort
- has a nested loop so (O)n^2
Define worst case, average case, and best case performance and describe why each of these is used
- Need to account for variability
- best case: best possible performance of algorithm for any input (of fixed size n)
- Worst case: worst possible performance of algorthm for any input ( of fixed size n)
State and justify the asymptotic performance for linear search,binary search, selection sort, and insertion sort in the best case and in the worst case
- linear search, best O(1), worst O(n)
- binary search (must be sorted), best O(1), worst O(log n)
- selection sort, basically find smallest element in positions i to length-1, swap it with element in position i. best and worst case (O)n^2
- insertion sort, basically swap successive pairs to put value in position i in correct location relative to earlier values, best (O)n (when array is already sorted), worst (O)n^2
Describe the merge sort algorithm
- uses recursion
- if list has one element, return. Divide list in half. Sort first half. Sort Second half. Merge sorted lists.
- 
Explain the use of recursion in merge sort
- The method calls itself... wow
Use asymptotic analysis to compare merge sort with selection sort and with insertion sort
State the best, worst, and average case performance for insertion sort, selection sort, merge sort, and quick sort
Evaluate situations in which different sorting algorithms are appropriate
Organize big O classes according to rate of growth
Avoid some common pitfalls in asymptotic analysis
Explain the role of benchmarking in computer science
Identify components of real systems which impact execution time
Use Java timing libraries to measure execution time
Use runtimes from a real system to reason about performance


## Week 3 : Interfaces, Linked Lists vs. Arrays, and Correctness
textgen.MyLinkedList*.java
textgen.MarkovTextGenerator.java
textgen.MarkovTextGenerator*.java

###Explain the idea of abstraction and why it is important
	- hiding irrelevant details to focus on the essential features needed to understand and use a thing the key to implementing large scale software system
###Give an example of abstraction in the real world and in Java
	- how do car brakes work? Push the brake pedal and the car stops as a driver do not need to know how the brakes work
	- Abstraction barrier: sets the rules of interaction i.e. knowing how the brakes work (implementation specified) vs. knowing how to use the brake pedal (behaviour specified). User of libraries vs Library Developer
	- Data abstraction: not important to understand how the data is organized if you are user of the data, care about how to interact with the data
	- in Java Interface List -> ArrayList
	- in Java more specifically
###Describe the difference between an Abstract Data Type (ADT) and a Data Structure
	- ADT has no implementation and manifest as interfaces and abstract classes in java
	- data structure is a specific implementation of an ADT i.e. List (ADT) to ArrayList (data structure)
###Describe and draw the structure of a LinkedList
	- comprised of a series of nodes
		- each node points to the previous and next node in the list
	- there is also a class which tracks the head and tail of the list
	- one implementation has sentinal nodes which exist only before the first node and after the last node, they only refer back to the first and last nodes
###Describe an advantage of a LinkedList over an ArrayList
	- linked list is higher performance for inserting into the list, arraylist is higher performance for accessing elements of the list
###Implement Generic classes in Java
	-<E> a type parameter, accept a type when a parameter is created
###Throw Exceptions to indicate errors
###Implement a doubly linked list with sentinel nodes in Java
###Explain the value of having confidence in your code
###Identify ways to build confidence in code correctness
Describe different testing practices
Compare advantages in testing methodologies
Write tests for a LinkedList
Explain how Markov processes can be used to generate text
Distinguish between training on text and generating text


## Week 4 : Trees! (including Binary Search Trees and Tries)
###Describe the value of trees
	they are a dynamic data structure, easy to add and remove nodes
	the structure convey's information
###Describe a Tree Data Structure
	Parents and children
	Root node has no parents
	Leaf nodes have no children
	Single root
	each node can have only one parent
	no cycles, i.e. no loops
	can a single node be a tree - yes, just a root
###Author a TreeNode class
	trees hava a linked structure like linked list
	a tree just needs a root node
	for a binary tree nod each node needs 1. a value, 2. a parent, 3. left child, 4. right child
'''Java
public class BinaryTree<E> {
	TreeNode<E> root;
	// etc..
}
'''
###Explain the need to visit data in different orderings
	make choices based on the need of data structure, e.g. social network connectivity - breadth first, maze - will go on until hitting a dead end then turn around
###Perform and author a preorder traversal
	traversal, if I need to find something in the tree, how do I find it
	preorder traversal - visit yourself, then visit all you left subtree, then visit all your right subtree
	recusion!
###Perform in-order, post-order and level-order traversals
	post order - depth first visit all your left subtree, visit all your right subtree, visit yourself
	in order traversal - depth first visiit all your left subtree, visit yourself, visit all your right subtree
	level order traversal - breadth first - keep a list adding and removing from the start
###Define a Binary Search Tree
	a binary tree restricts any parent to have at most 2 children
	A BST must 1. be a binary tree, 2. Left subtrees are less than parent, 3. Right subtrees are greater than parent
	Binary search review: list is sorted, check middle element, if search is greater eliminate higher half of list, check  middle of new list etc...
###Identify valid Binary Search Trees
###Perform Search in a Binary Search Tree
	Use recursion
	check left or right until there are no nodes left
	could also use iteration
###Insert an item into a Binary Search Tree
	walk through the nodes, check left and right until it fits the node
###Delete an item from a Binary Search Tree
	find smallest element in right subtree
	replace deleted element with the smallest right subtree value
	delete smallest element that was just switched
###Explain the running time performance to find an item in a BST
###Compare the performance of linked lists and BSTs
	height of the tree will affect performance
	create a Balanced BST
	|Left tree - Right Tree| <=1
	Height around log(n)
	make tree as bushy as possible
###Explain what a trie data structure is
	bst doesn't take advantage of shared structure e.g. east eat ear
	reTRIEval
###Describe the algorithm for finding keys in and adding keys to a trie
	follow the linked letter nodes to the word required
###Compare the time to find a key in a BST to a trie
	depends on the height aka length of the longest word
###Implement a trie data structure in Java

spelling.SpellingSuggest.java
spelling.AutoComplete.java
spelling.Dictionary.java
spelling.Dictionary*.java
spelling.AutoCompleteDictionaryTrie.java
spelling.TrieNode.java

## Week 5 : Hash Maps and Edit Distance
###Describe why hash tables are valuable
	If index for an array is known, could immediately look up the data
	hash table idea: if I want to add something into an array, could i find a way to translate it into an index?
	take a key (data in array) and convert it into an index - hash function - creates hash code
	How to make a hash function that works well
	
###Describe the role of a hash function
	maps a key, i.e the data to a particular location in the hash table
	It should minimize collisions
###Describe alternative methods for handling collisions in a Hash Table
###Identify other challenges associated with Hash Tables
###Explain the difference between a Hash Set and a Hash Map
###Describe a detailed algorithm for generating spelling suggestions for misspelled words
###Define the notion of edit distance
###Describe a naïve algorithm for calculating the edit distance between two strings
###Describe how pruning can be used to reduce the problem space

spelling.WordPath.java
spelling.NearbyWords.java
spelling.WPTree.java

# SETUP

Importing Project into eclipse:
    1. Create a new Java Project in your workspace
    2. Import the starter files:
      File -> Import -> Select "File System" -> Next -> Browse and set 
      root directory to folder contents of zip were extracted to -> Finish

Feel free to use another IDE or manually compile and run your programs.
If you need help, google is your friend.

# ACKNOWLEDGEMENTS

A big thank you to Tomas Mikula for creating RichTextFX 
which was used as the text area in the GUI application.
(Link: https://github.com/TomasMikula/RichTextFX)

