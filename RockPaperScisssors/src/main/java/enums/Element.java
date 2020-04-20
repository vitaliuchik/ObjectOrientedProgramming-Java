package enums;

public enum Element {
    PAPER(0), ROCK(0), SCISSORS(0);

    private int weight;

    Element(int weight) {
        this.weight = weight;
    }

    public boolean complete(Element el) {
        return false;
    }
}
