package BST;

public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {
    public E element;
    public TreeNode<E> right;
    public TreeNode<E> left;

    public TreeNode(E o){
        element = o;
        right = null;
        left = null;
    }
    @Override
	public int compareTo(TreeNode<E> o) {
		return element.compareTo(o.element);
	}
}

