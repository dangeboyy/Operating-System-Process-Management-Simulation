package adt;

public interface IList<T> {
    void add(int newPosition,T newEntry);
    void add(T newEntry);
    T remove(int givenPosition);
    T replace(int givenPosition,T newEntry);
    T getEntry(int givenPosition);
    T[] toArray();
    boolean contains(T entry);
    int getLength();
    boolean isEmpty();
    void clear();

}
