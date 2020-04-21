package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {

    private final Object[] arr;

    public ImmutableArrayList(Object[] arr) {
        this.arr = arr;
    }


    private void checkIndex(int index, boolean forInserting) {
//        checker for add(), addAll() and similar
        if ((index > arr.length || index < 0) && forInserting)
            throw new IndexOutOfBoundsException();
//        checker for get(), remove(), set() and similar
        if ((index >= arr.length || index < 0) && !forInserting)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(arr.length, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        checkIndex(index, true);
        Object[] result = new Object[arr.length + 1];
        System.arraycopy(arr, 0, result, 0, index);
        result[index] = e;
        System.arraycopy(arr, index, result, index + 1, arr.length - index);
        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(arr.length, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index, true);
        Object[] result = new Object[arr.length + c.length];
        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(c, 0, result, index, c.length);
        System.arraycopy(arr, index, result, index + c.length, arr.length - index);
        return new ImmutableArrayList(result);
    }

    @Override
    public Object get(int index) {
        checkIndex(index, false);
        return arr[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index, false);
        Object[] result = new Object[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index, false);
        arr[index] = e;
        return new ImmutableArrayList(arr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(e))
                return i;
        return -1;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList(new Object[]{});
    }

    @Override
    public boolean isEmpty() {
        return arr.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);
        return result;
    }

    public String toString() {
        if (arr.length == 0)
            return "";
        StringBuilder result = new StringBuilder(arr[0].toString());
        for (int i = 1; i < arr.length; i++)
            result.append(", ").append(arr[i].toString());
        return result.toString();
    }
}
