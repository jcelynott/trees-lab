/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab9;

/**
 *
 * @author James
 * @param <T>
 */
public class TreeNode<T> {
    
    T nodeContent;
    TreeNode<T> left;
    TreeNode<T> right;
    
    TreeNode(T newItem) 
    {
        nodeContent = newItem;
        left = null;
        right = null;
    }
    
public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) //Constructur to define left and right branches along with node
{
    nodeContent = newItem;
    this.left = left;
    this.right = right;
}

public T getItem() //Returns item value of the item
{
    return nodeContent;
}

public boolean isLeaf() //Checks if this branch has no further questions i.e. is a guess
{
    return left == null && right == null;
}
    
    
}
