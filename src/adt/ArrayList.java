package adt;

import java.util.Arrays;

public class ArrayList<T> implements IList<T> {
    private T[] myList = (T[]) new Object[DEFAULT_CAPACITY];
    private int numberOfEntries;
    private boolean initialized=false;
    private static final int DEFAULT_CAPACITY=10;
    private static final int MAX_CAPACITY=10000;


    public ArrayList(boolean initialized) {
        this.initialized = initialized;
    }

    @Override
    public void add(int newPosition, T newEntry) {//ege
        checkInit();
        if((newPosition<=numberOfEntries+1)&&(newPosition>=1)){
            if(newPosition<=numberOfEntries){
                makeRoom(newPosition);
            }
            myList[newPosition]=newEntry;
            numberOfEntries++;
            ensureCapacity();
        }
        else {
            throw new IndexOutOfBoundsException("Givem position is not valid");
        }



    }
    private void ensureCapacity() {
        int capacity= myList.length-1;
        if (numberOfEntries>= capacity){
            int newCapacity=2*capacity;
            checkCapacity(newCapacity);
            myList= Arrays.copyOf(myList,newCapacity);
        }
    }

    private void checkCapacity(int newCapacity) {
        if (newCapacity >= MAX_CAPACITY) throw new SecurityException("Capacity Oversized");
    }
    private void makeRoom(int newPosition){
        assert (newPosition>=1) && (newPosition<=numberOfEntries+1);
        int newIndex=newPosition;
        int lastIndex=numberOfEntries;

        for(int index=lastIndex;index>=newIndex;index--){
            myList[index+1]=myList[index];
        }
    }

    @Override
    public void add(T newEntry) {
        checkInit();
        myList[numberOfEntries+1]=newEntry;
        numberOfEntries++;
        ensureCapacity();

    }

    @Override
    public T remove(int givenPosition) {//ege
        checkInit();
        if((givenPosition>=1)&&(givenPosition<=numberOfEntries)){
            assert !isEmpty();
            T removed=myList[givenPosition];
            if(givenPosition<numberOfEntries){
                removeGap(givenPosition);
            }
            numberOfEntries--;
            return removed;
        }
        else {
            throw new IndexOutOfBoundsException("Invalid position given to remove operation");
        }
    }
    private void removeGap(int givenPosition){
        assert (givenPosition>=1) &&(givenPosition<numberOfEntries);
        int removedIndex=givenPosition;
        int lastIndex=numberOfEntries;
        for (int index=removedIndex;index<lastIndex;index++){
            myList[index]=myList[index+1];
        }
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        checkInit();
        if ((givenPosition>=1) && (givenPosition<=numberOfEntries)){
            assert !isEmpty();
            T removedEntry = myList[givenPosition];
            myList[givenPosition] = newEntry;
            return removedEntry;
        }else throw new IndexOutOfBoundsException("Given position is not valid");
    }

    @Override
    public T getEntry(int givenPosition) {//ege
        checkInit();
        if((givenPosition>=1)&& (givenPosition<=numberOfEntries)){
            assert !isEmpty();
            return myList[givenPosition];
        }
        else {
            throw new IndexOutOfBoundsException("Invalid position given to getEntry operation");
        }
    }

    @Override
    public T[] toArray() {
        checkInit();
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i]=myList[i];
        }
        return result;
    }

    @Override
    public boolean contains(T entry) {//ege
       checkInit();
       boolean isContains=false;
       int index=1;
       while (!isContains && (index<=numberOfEntries)){
           if(entry.equals(myList[index])){
               isContains=true;
           }
           index++;
       }
       return isContains;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries==0;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            remove(numberOfEntries);
        }
    }
    private void checkInit(){
        if(!initialized){
            throw new SecurityException("Array List object is not initialized");
        }
    }
}
