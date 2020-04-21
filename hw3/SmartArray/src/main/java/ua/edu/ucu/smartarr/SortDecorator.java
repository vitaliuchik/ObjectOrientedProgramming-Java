package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator predicate)
    {
        super(smartArray);
        this.comparator = predicate;
    }


    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>(Arrays.asList(smartArray.toArray()));
        result.sort(comparator);
        return result.toArray();
    }

    @Override
    public String operationDescription() {
        return "sorted " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
