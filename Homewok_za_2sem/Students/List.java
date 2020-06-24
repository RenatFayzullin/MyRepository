package Students;

public class List<T extends Student> {
    private ListElement<T> head;
    private ListElement<T> tail;
    List(){
        head = null;
        tail = null;
    }

    public void add(ListElement<T> newSt){
        if(head == null) {
            head = newSt; tail = newSt;
        }
        else {
            tail.setNext(newSt);
            tail = tail.getNext();
        }
    }

    public void doExercise(int start, int end){
        int i = 0;
        ListElement<T> elem = this.head;
        while(i<start){
            elem = elem.getNext();
            i++;
        }
        while(i<end && elem.getNext()!=null){
            elem.upCountOfEx();
            elem = elem.getNext();
            i++;
        }
    }
    public boolean checkFiloning(){
        ListElement<T> elem = this.head;
        boolean check = true;
        while(elem != null && check){
            if(elem.getValue().getExercises() == 0){
                check = false;
            }
            elem = elem.getNext();
        }
        return check;
    }
}