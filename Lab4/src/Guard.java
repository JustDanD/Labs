public class Guard extends Human {
    Mood mood;

    public Guard( String name, Mood mood) {
        super(name);
        this.mood = mood;
    }

    boolean giveAccess(final int crowdSize) {
        class brain {
            double checker = 0;
            void countChecker() {
                checker = (100 - crowdSize) * mood.getCof();
            }
        }
        brain mind = new brain();
        mind.countChecker();
        if (crowdSize >= 0) {
            if (mind.checker < 80)
                return false;
            else
                return true;
        }
        else
            throw new WrongParamExp("Количество людей отрицательно!!!");

    }
    @Override
    public int hashCode () {
        return this.mood.hashCode() + super.name.hashCode();
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
