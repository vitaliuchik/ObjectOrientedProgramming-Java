package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction func;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        Object[] result = smartArray.toArray();
        for (int i = 0; i < result.length; i++)
            result[i] = func.apply(result[i]);
        return result;
    }

    @Override
    public String operationDescription() {
        return "mapped " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
