package adt;

public class LinkedList<T> {

    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    public LinkedList() {
        initDataFields();
    }
    private void initDataFields(){
        firstNode=null;
        lastNode=null;
        numberOfEntries=0;
    }
    public void add(T newEntry){
        Node newNode = new Node(newEntry);
        if (isEmpty()){
            firstNode=newNode;
        }else {
            lastNode.setNext(newNode);
        }
        lastNode=newNode;
        numberOfEntries++;
    }
    public void add(T newEntry,int givenPosition){
        if ((givenPosition>=1) && (givenPosition<=numberOfEntries+1)){
            Node newNode = new Node(newEntry);
            if (isEmpty()){
                firstNode= newNode;
                lastNode = newNode;
            }else if (givenPosition==1){
                newNode.setNext(firstNode);
                firstNode=newNode;
            }else if (givenPosition==numberOfEntries+1){
                lastNode.setNext(newNode);
                lastNode=newNode;
            }else {
                Node nodeBefore = getNodeAt(givenPosition-1);
                Node nodeAfter = nodeBefore.next;
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
            numberOfEntries++;
        }else {
            throw new IndexOutOfBoundsException("Given Position is not valid");
        }
    }

    public T remove(int givenPosition){
        T result=null;
        if ((givenPosition>=1) && (givenPosition<=numberOfEntries)){
            assert !isEmpty();
            if (givenPosition==1){
                result=firstNode.getData();
                firstNode=firstNode.getNext();
                if (numberOfEntries==1) lastNode=null;
            }else{
                Node nodeBefore = getNodeAt(givenPosition-1);
                Node nodeToRemove= nodeBefore.getNext();
                Node nodeAfter = nodeToRemove.getNext();
                nodeBefore.setNext(nodeAfter);
                result=nodeToRemove.getData();
                if (numberOfEntries==givenPosition) lastNode=nodeBefore;

            }
            numberOfEntries--;
        }
        else
            throw new IndexOutOfBoundsException("Given Position is not valid");
        return result;
    }
    public boolean contains(T entry){
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && currentNode !=null){
            if (entry.equals(currentNode.getData())){
                found=true;
            }else{
                currentNode=currentNode.getNext();
            }
        }
        return found;
    }

    public Node getNodeAt(int givenPosition) {
        assert ((firstNode != null) && (givenPosition >= 1) && (givenPosition <= numberOfEntries));
        Node currentNode = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            currentNode = currentNode.getNext();
        }
        assert (currentNode != null);
        return currentNode;
    }
    public T getDataAt(int givenPosition){
        assert ((firstNode != null) && (givenPosition >= 1) && (givenPosition <= numberOfEntries));
        Node currentNode = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            currentNode = currentNode.getNext();
        }
        assert (currentNode != null);
        return currentNode.getData();

    }


    public boolean isEmpty(){
        boolean result;
        if (numberOfEntries==0){
            assert firstNode==null;
            result=true;
        }else {
            assert firstNode!=null;
            result=false;
        }
        return result;
    }

    private class Node{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }
}
