package ua.edu.ucu.smartarr;

import java.util.ArrayList;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate)
    {
        super(smartArray);
        this.predicate = predicate;
    }


    @Override
    public Object[] toArray() {
        ArrayList<Object> result = new ArrayList<>();
        for (Object el: smartArray.toArray())
            if (predicate.test(el))
                result.add(el);
        return result.toArray();
    }

    @Override
    public String operationDescription() {
        return "filtered " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
