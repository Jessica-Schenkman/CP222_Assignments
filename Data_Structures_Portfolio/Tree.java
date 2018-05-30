/*
Jessica Schenkman
Tree.java
January/Febuary 2016
This is an implimentation of a binary search tree.
The right child is greator than or equal to the parent node and the left child is less than the parent node.
A word is classified as being greator than a second word if the first letter of the word comes before the first letter of the second word in the alphabet.
A word is classified as being less than a second word if the first letter of the word comes after the first letter of the second word in the alphabet.
A word is classified as being equal to a second word if the first letter of each word is the same letter.
This code has been applied to a txt document containing several words.
It scans the document and stores the words in a binary search tree.
*/



import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tree<T extends Comparable> {

int count = 0;
int height = 0;
int right_count;
int left_count;
boolean list_empty;
boolean tree_is_balenced;
boolean value_is_there;
TreeNode<T> current_parent;

  private TreeNode<T> root;

  public Tree() {
    root = null;
  }

//The following method adds nodes to the tree
  public void addNode(T value) {
    TreeNode<T> new_node = new TreeNode<T>(value);

    if (root == null) {
      root = new_node;
    }
    else {
      TreeNode<T> current_node = root;
      while (current_node != null) {
        if (new_node.getValue().compareTo(current_node.getValue()) < 0) {
          if (current_node.getLeftChild() == null) {
            current_node.addLeftChild(new_node);
            return;
          }
          else {
            current_node = current_node.getLeftChild();
          }
        }
        else {
          if (current_node.getRightChild() == null) {
            current_node.addRightChild(new_node);
            return;
          }
          else {
            current_node = current_node.getRightChild();
          }
        }
      }
    }
  }

//The following method removes a value within the tree
  public void removeValueHelper(TreeNode<T> current_node, T element){
  System.out.println("Node at the beginning of method call: " + current_node.getValue() + " Element: " + element);

    if(current_node.getValue() != null){

      if(current_node.getValue().equals(element)){
        System.out.println("got in!");
        if(current_parent.getLeftChild().equals(current_node)){
          current_parent.addLeftChild(current_node.getLeftChild());
        }
        else{
          current_parent.addRightChild(current_node.getRightChild());
        }
      }
       else{
          System.out.println("continued recursion ");

            current_parent = current_node;
            if(current_node.getLeftChild() != null){
            removeValueHelper(current_node.getLeftChild(), element);
            }
            current_parent = current_node;
            if(current_node.getRightChild() != null){
              removeValueHelper(current_node.getRightChild(), element);
            }
          }
        }
      System.out.println("Item is not in list");
  }

//The following method removes a value with in the tree
  public void removeValue(T element){
    removeValueHelper(root, element);
  }


//checks if a certain value is in the tree
  public void checkValueHelper(TreeNode<T> current_node, T element){

    if(current_node != null){

      checkValueHelper(current_node.getLeftChild(), element);
      checkValueHelper(current_node.getRightChild(), element);

      if(current_node.getValue().equals(element)){
        value_is_there = true;
      }
    }
  }

//The following method checks if a certain value is in the tree
  public void checkValue(T element){
    value_is_there = false;
    checkValueHelper(root, element);

  }


//The following method checks to see if the tree is balenced
  public void checkBalenceHelper(TreeNode<T> current_node){
    if(current_node != null){
      if(current_node.getRightChild() != null){
        right_count++;
        checkBalenceHelper(current_node.getRightChild());
      }
      if(current_node.getLeftChild() != null){
        left_count++;
        checkBalenceHelper(current_node.getLeftChild());
      }
    }
  }

//The following method checks to see if the tree is balenced
  public boolean checkBalence(){
    checkBalenceHelper(root);
    if(right_count == left_count){
          tree_is_balenced = true;
          return tree_is_balenced;
    }
    else{
      tree_is_balenced = false;
      return tree_is_balenced;

    }

  }


//The following method returns boolean value to indicate if the tree is empty or not
  public boolean isTreeEmpty(){
    if(root == null){
      list_empty = true;
    }
    else{
      list_empty = false;
    }
    return list_empty;
  }

//The following method traverses each node and adds to size count to reutrn the size of the tree
  public void sizeHelper(TreeNode<T> current_node){

    if(current_node != null){
      sizeHelper(current_node.getLeftChild());
      sizeHelper(current_node.getRightChild());
      count++;
    }
  }

  public int size(){
    sizeHelper(root);
    return count;
  }


//The following method recursively traverses the tree in level order
  public void levelorderTraversalHelper(TreeNode<T> current_node){
    if(current_node != null){
      if(current_node.getLeftChild() != null){
        System.out.println("Left" + current_node.getLeftChild());
      }
      if(current_node.getRightChild() != null){
        System.out.println("Right: " + current_node.getRightChild());
      }
      levelorderTraversalHelper(current_node.getLeftChild());
      levelorderTraversalHelper(current_node.getRightChild());
    }
  }

  public void levelorderTraversal(){
    System.out.println(root);
    levelorderTraversalHelper(root);
  }

//The following method recursively traverses the tree post order
  public void postorderTraversalHelper(TreeNode<T> current_node){
    if(current_node != null){
      postorderTraversalHelper(current_node.getLeftChild());
      postorderTraversalHelper(current_node.getRightChild());
      System.out.println(current_node);
    }
  }

  public void postorderTraversal(){
    postorderTraversalHelper(root);
  }

//The following method recursively traverses the tree in preorder
  public void preorderTraversalHelper(TreeNode<T> current_node){
    if(current_node != null){
      System.out.println(current_node);
      preorderTraversalHelper(current_node.getLeftChild());
      preorderTraversalHelper(current_node.getRightChild());
    }
  }

  public void preorderTraversal(){
    preorderTraversalHelper(root);
  }

//The following method recursively traverses tree inorder
  public void inorderTraversalHelper(TreeNode<T> current_node) {
    if (current_node != null) {
      inorderTraversalHelper(current_node.getLeftChild());
      System.out.println(current_node);
      inorderTraversalHelper(current_node.getRightChild());

    }
  }

//The following method traverses tree inorder
  public void inorderTraversal(){
    inorderTraversalHelper(root);
  }


  public static void main(String[] args) throws FileNotFoundException {

      Tree<String> myTree = new Tree();

      Scanner myScanner = new Scanner(new File("words.txt"));
      while (myScanner.hasNext()) {
          myTree.addNode(myScanner.next());
      }

    //myTree.checkValue("Apple");
   //myTree.levelorderTraversal();
  }
}
