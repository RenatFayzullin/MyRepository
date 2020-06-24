package Students;

public class ListElement<T extends Student> {
    private T value;
    private ListElement<T> next;

    ListElement(T student){
        value = student;
    }

    public T getValue() {
        return value;
    }

    public ListElement<T> getNext() {
        return next;
    }

    public void upCountOfEx() {
        this.value.doExercise();
    }

    public void setNext(ListElement<T> next) {
        this.next = next;
    }
}