package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {

    private final Object[] elementArrayList;

    public ImmutableArrayList(Object[] elements) {
        this.elementArrayList = elements.clone();
    }

    public ImmutableArrayList() {
        this.elementArrayList = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(elementArrayList.length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(elementArrayList.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        Object[] newArray = new Object[elementArrayList.length + c.length];

        if (index >= 0) System.arraycopy(elementArrayList, 0, newArray, 0, index);

        System.arraycopy(c, 0, newArray, index, c.length);

        if (elementArrayList.length - index >= 0)
            System.arraycopy(elementArrayList, index, newArray, index + c.length, elementArrayList.length - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        if (index >= elementArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        return elementArrayList[index];
    }

    @Override
    public ImmutableList remove(int index) {

        if (index >= elementArrayList.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArray = new Object[elementArrayList.length - 1];

        if (index >= 0) System.arraycopy(elementArrayList, 0, newArray, 0, index);

        if (elementArrayList.length - 1 - index >= 0)
            System.arraycopy(elementArrayList, index + 1, newArray, index, elementArrayList.length - 1 - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {

        if (index >= elementArrayList.length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArray = new Object[elementArrayList.length];

        System.arraycopy(elementArrayList, 0, newArray, 0, elementArrayList.length);

        newArray[index] = e;

        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;
        // Return the first occurence or -1
        for (int i = 0; i < elementArrayList.length; i++) {
            if (elementArrayList[i].equals(e)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return elementArrayList.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return (elementArrayList.length == 0);
    }

    @Override
    public Object[] toArray() {

        Object[] newArray = new Object[elementArrayList.length];

        System.arraycopy(elementArrayList, 0, newArray, 0, elementArrayList.length);

        return newArray;
    }
}