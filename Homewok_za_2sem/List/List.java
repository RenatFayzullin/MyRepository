package List;

public class List {
    private ListElement head;

    public void setHead(ListElement obj){
        head=obj;
    }
    public ListElement getHead(){
        return head;
    }
    public void emptyList(){
        head=null;
    }
    public void add(ListElement listElement){
        ListElement elem = head;
        while (elem.getNext() != null){
            elem = elem.getNext();
        }
        elem.setNext(listElement);
    }
    public void insert(ListElement listElement, int l){
        int k=1;
        ListElement elem=head;
        ListElement elem1=head;
        while (k!=l || elem.getNext()!=null){
            elem.getNext();
            k++;
        }
        k=1;
        while (k+1!=l || elem.getNext()!=null){
            elem1.getNext();
            k++;
        }
        listElement.setNext(elem);
        elem1.setNext(listElement);
    }
    public void findValue(int value){
        ListElement element=head;
        int k=0;
        while (element.getValue()!=value || element.getNext()!=null){
            element.getNext();
        }
    }
    public void deleteNextElement(ListElement listElement){
        listElement.setNext(listElement.getNext().getNext());
    }
    public void join(List list){
        ListElement element=head;
        while (element.getNext()!=null){
            element.getNext();
        }
        element.setNext(list.getHead());
    }

}