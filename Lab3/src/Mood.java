public enum Mood {
    WORST(0.1),
    BAD(0.3),
    NORMAl(0.5),
    GOOD(0.7),
    BEST(1);

    private double coef;

    Mood( double cof ) {
        this.coef = cof;
    }
    public double getCof() {
        return coef;
    }
    @Override
    public String toString() {
        return "Mood coefficient:" + coef + '\n';
    }
}
