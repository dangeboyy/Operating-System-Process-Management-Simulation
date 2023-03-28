package adt;

public class LinkedPriorityQueue<T> {
    private Node firstNode;
    private Node lastNode;
    private int size;

    public LinkedPriorityQueue() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private class Node {
        private T data;
        private Node next;
        private int priority;

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        private Node(T data, Node next, int priority) {
            this.data = data;
            this.next = next;
            this.priority = priority;
        }

        private T getData() {

            return data;
        }

        private Node getNext() {

            return next;
        }


        private Node getNodeAt(int givenPosition) {
            assert ((firstNode != null) && (givenPosition >= 1) && (givenPosition <= getSize()));
            Node currentNode = firstNode;
            for (int i = 1; i < givenPosition; i++) {
                currentNode = currentNode.getNext();

            }
            assert (currentNode != null);
            return currentNode;
        }
    }

    public void add(T newEntry, int priority) {
        Node currentNode = firstNode;
        int position = 1;
        Node newNode = new Node(newEntry, null, priority);
        if (isEmpty()|| currentNode ==null) {
            firstNode = newNode;
            lastNode = newNode;
            size++;
            return;
        }

        while (true) {
            if(currentNode!=null){
                if (currentNode.getPriority() > priority) {
                    if (currentNode.equals(firstNode)) {
                        newNode.setNext(firstNode);
                        firstNode = newNode;
                        size++;
                        break;
                    } else if (currentNode.equals(lastNode)) {
                        Node nodeBefore = currentNode.getNodeAt(position - 1);
                        nodeBefore.setNext(newNode);
                        newNode.setNext(currentNode);
                        size++;
                        break;
                    } else {
                        Node nodeBefore = currentNode.getNodeAt(position - 1);
                        newNode.setNext(currentNode);
                        nodeBefore.setNext(newNode);
                        size++;
                        break;
                    }

                } else if(currentNode.getPriority()==priority) {
                    if (currentNode.equals(lastNode)) {
                        currentNode.setNext(newNode);
                        lastNode=newNode;
                        size++;
                        break;
                    }

                }
                currentNode=currentNode.getNext();
                position++;
            }else {
                lastNode.setNext(newNode);
                lastNode=newNode;
                size++;
                break;
            }

        }


    }
    public T remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");

        }
        if(size!=1){
            T removed=firstNode.getData();
            firstNode=firstNode.getNext();
            size--;
            if(size==1){
                firstNode=lastNode;
                lastNode=null;
            }
            return removed;
        }
        else{
            T removed=firstNode.getData();
            firstNode=null;
            size--;
            return removed;

        }



    }
    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        T first=null;
        first=firstNode.getData();
        return  first;
    }


    public int getSize() {

        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



}
