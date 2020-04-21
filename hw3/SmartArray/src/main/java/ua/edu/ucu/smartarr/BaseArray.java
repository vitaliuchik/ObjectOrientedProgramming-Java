package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{

    private Object[] array;
    private int length;

    public BaseArray(Object[] array) {
        this.array = array;
        this.length = array.length;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[this.length];
        System.arraycopy(this.array, 0, newArray, 0, this.length);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "basic array";
    }

    public void setValue(int index) {
        array[index] = 0;
    }

//    public String toString() {
//        String result = this.array[0].toString();
//        for (int i = 1; i < this.length; i++)
//            result += ", " + this.array[i].toString();
//        return result;
//    }
}
