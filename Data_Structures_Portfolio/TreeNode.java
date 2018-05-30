/*
Jessica Schenkman
TreeNode.java
January/Febuary 2016
The following class includes the necessary methods and constructors for tree nodes used in the implimentation of a binary search tree.
See Tree.java for the implimentation of a binary search tree.
*/

public class TreeNode<T extends Comparable> {

    private T value;
    private TreeNode<T> left_child;
    private TreeNode<T> right_child;

//constructor for tree node, describes all the information associated with each tree node
    public TreeNode(T _value) {
      value = _value;
      left_child = null;
      right_child = null;
    }

//The following method adds a left child - O(1)
    public void addLeftChild(TreeNode<T> _child) {
      left_child = _child;
    }

//The following method adds a right child - O(1)
    public void addRightChild(TreeNode<T> _child) {
      right_child = _child;
    }

//The following method reutrns the value for the left child -O(1)
    public TreeNode<T> getLeftChild() {
      return left_child;
    }

//The following method reutrns the value for the right child - O(1)
    public TreeNode<T> getRightChild() {
      return right_child;
    }

//The following method reutrns the value contain in a node - O(1)
    public T getValue() {
      return value;
  }

    public String toString() {
      return "TreeNode: " + value.toString();
    }

}
