public class Guard extends Human {
    Mood mood;

    public Guard( String name, Mood mood) {
        super(name);
        this.mood = mood;
    }

    boolean giveAccess(int crowdSize) {
        double checker = (100 - crowdSize) * mood.getCof();
        if (checker  < 80)
            return false;
        else
            return true;
    }
    @Override
    public int hashCode () {
        return super.hashCode() + 25;
    }
    @Override
    public String toString() {
        return "Cur guard mood:" + this.mood + "; name:" + this.name;
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof Guard) {
            if (this.hashCode() == ((Guard)o).hashCode() && (this.toString() == ((Guard)o).toString()))
                return true;
        }
        return false;
    }
}
