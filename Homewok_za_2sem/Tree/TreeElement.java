package Tree;

public class TreeElement<T extends Comparable<T>> {

    private T value;
    private TreeElement<T> left;
    private TreeElement<T> right;

    TreeElement(T value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(TreeElement<T> left) {
        this.left = left;
    }

    public void setRight(TreeElement<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public TreeElement<T> getLeft() {
        return left;
    }

    public TreeElement<T> getRight() {
        return right;
    }
}