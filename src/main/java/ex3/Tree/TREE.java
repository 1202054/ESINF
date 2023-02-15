
package ex3.Tree;

import java.util.ArrayList;
import java.util.List;

public class TREE<E extends Comparable<E>> extends BST<E>{
 
   /*
   * @param element A valid element within the tree
   * @return true if the element exists in tree false otherwise
   */   
    public boolean contains(E element) {
         if (element == null)
             return false;
         else return find(root, element) != null;
    }

 
    public boolean isLeaf(E element){
         if(element == null)
             return false;
         Node<E> node = find(root,element);
         if (node == null)
             return false;
         if (node.getLeft() == null && node.getRight() == null)
             return true;
         return false;
    }

   /*
   * build a list with all elements of the tree. The elements in the 
   * left subtree in ascending order and the elements in the right subtree 
   * in descending order. 
   *
   * @return    returns a list with the elements of the left subtree 
   * in ascending order and the elements in the right subtree is descending order.
   */
    public Iterable<E> ascdes(){
        List<E> nodeList = new ArrayList<>();
        if (root != null) {
            ascSubtree(root.getLeft(), nodeList);
            nodeList.add(root.getElement());
            desSubtree(root.getRight(), nodeList);
        }
        return nodeList;
    }

    private void ascSubtree(Node<E> node, List<E> snapshot) {
        if (node == null)
            return;
        if (node.getLeft()!= null)
            ascSubtree(node.getLeft(),snapshot);
        snapshot.add(node.getElement());
        if (node.getRight() != null)
            ascSubtree(node.getRight(),snapshot);
    }
    
    private void desSubtree(Node<E> node, List<E> snapshot) {
        if (node == null)
            return;
        if (node.getRight() != null)
            desSubtree(node.getRight(),snapshot);
        snapshot.add(node.getElement());
        if (node.getLeft() != null)
            desSubtree(node.getLeft(),snapshot);
    }
   
    /**
    * Returns the tree without leaves.
    * @return tree without leaves
    */
    public BST<E> autumnTree() {
        TREE<E> autumnTree = new TREE<>();
        autumnTree.root= copyRec(this.root);
        return autumnTree;
    }
    
    private Node<E> copyRec(Node<E> node){
        if (node == null)
            return null;
        if (!isLeaf(node.getElement()))
            return new Node<>(node.getElement(), copyRec(node.getLeft()),copyRec(node.getRight()));
        return null;
    }
    
    /**
    * @return the number of nodes by level.
    */
    public int[] numNodesByLevel(){
        int[] nodesByLevel = new int[this.height() + 1];
        numNodesByLevel(root, nodesByLevel, 0);
        return nodesByLevel;
    }
    
    private void numNodesByLevel(Node<E> node, int[] result, int level){
        if (node == null)
            return;
        result[level]++;
        numNodesByLevel(node.getLeft(),result,level+1);
        numNodesByLevel(node.getRight(),result,level+1);
    }
    
    public boolean perfectBalanced(){
        return perfectBalanced(root);
    }
    
    private boolean perfectBalanced(Node<E> node){
        if (node ==null)
            return true;
        int lh;
        int rh;
        lh = height(node.getLeft());
        rh = height(node.getRight());
        if (Math.abs(lh - rh) <= 1 && perfectBalanced(node.getLeft()) && perfectBalanced(node.getRight()))
            return true;
        return false;
    }
    
    
    public E lowestCommonAncestor(E elem1, E elem2){
        return lowestCommonAncestor(root,elem1,elem2).getElement();
    }

    //está mal
    private Node<E> lowestCommonAncestor(Node<E> node, E elem1, E elem2){
        if (node== null)
            return null;
        if (node.getElement().compareTo(elem1)>0 && node.getElement().compareTo(elem2)>0)
            return lowestCommonAncestor(node.getLeft(),elem1,elem2);
        if (node.getElement().compareTo(elem1)<0 && node.getElement().compareTo(elem2)<0)
            return lowestCommonAncestor(node.getLeft(),elem1,elem2);
        return node;
    }
    
    
    public BST<E>  minCompletSubtree(E elem1, E elem2){
            
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    public BST<E>  construcTreeposOrder (ArrayList<E> posOrder){
            
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public E predecessor(E element) {
        if (element == null)
            return null;
        return predecessor2(root, element, null, false);
    }

    public E predecessor2(Node<E> node, E element, E pred, boolean found) {
        if (node == null)
            return null;
        if (node.getElement().compareTo(element) < 0)
            predecessor2(node.getLeft(), element, pred, found);
        if (node.getElement().compareTo(element) > 0)
            predecessor2(node.getLeft(),element, node.getElement(), found);
        return predecessor2(node.getLeft(), element, pred, true);
    }

}
