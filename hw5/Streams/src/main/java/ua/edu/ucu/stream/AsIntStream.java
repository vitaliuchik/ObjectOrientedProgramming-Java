package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;

public class AsIntStream implements IntStream {

    private ArrayList<Integer> stream;

    private AsIntStream() {
         this.stream = new ArrayList<Integer>();
    }

    private AsIntStream(ArrayList<Integer> stream) {
        this.stream = stream;
    }

    public static IntStream of(int... values) {
        AsIntStream strm = new AsIntStream();
        for (int val: values) {
            strm.stream.add(val);
        }
        return strm;
    }


    @Override
    public Double average() {
        emptyStream();
        return ((double) sum()) / count();
    }

    @Override
    public Integer max() {
        emptyStream();
        int maxVal = stream.get(0);
        for (int val: stream)
            if (val > maxVal)
                maxVal = val;
        return maxVal;
    }

    @Override
    public Integer min() {
        emptyStream();
        int minVal = stream.get(0);
        for (int val: stream)
            if (val < minVal)
                minVal = val;
        return minVal;
    }

    @Override
    public long count() {
        return stream.size();
    }

    @Override
    public Integer sum() {
        emptyStream();
        int res = 0;
        for (int val: stream)
            res += val;
        return res;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        AsIntStream new_stream = new AsIntStream();
        for (int val: stream)
            if (predicate.test(val))
                new_stream.stream.add(val);
        return new_stream;
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int val: stream)
            action.accept(val);
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        AsIntStream new_stream = new AsIntStream();
        for (int val: stream)
            new_stream.stream.add(mapper.apply(val));
        return new_stream;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<IntStream> new_stream = new ArrayList<>();
        for (Integer val: stream)
            new_stream.add(func.applyAsIntStream(val));

        ArrayList<Integer> res_stream = new ArrayList<>();
        for (IntStream val: new_stream)
            for (int element: val.toArray())
                res_stream.add(element);
        return new AsIntStream(res_stream);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int res = identity;
        for (int val: stream)
            res = op.apply(res, val);
        return res;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[stream.size()];
        for (int i = 0; i < stream.size(); i++)
            arr[i] = stream.get(i);
        return arr;
    }

    private void emptyStream() {
        if (stream.isEmpty()){
            throw new IllegalArgumentException("Stream is empty");
        }
    }

}
