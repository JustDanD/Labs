public class Human {
    String name;
    public Human( String name) {
        this.name = name;
    }
    @Override
    public int hashCode () {
        return super.hashCode() + 25;
    }
    @Override
    public String toString() {
        return "Cur name:" + this.name;
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof Human) {
            if (this.hashCode() == ((Human)o).hashCode() && (this.toString() == ((Human)o).toString()))
                return true;
        }
        return false;
    }
}
