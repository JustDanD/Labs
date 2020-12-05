public class Crowd {
    private int peopleAmount;

    public Crowd(int cnt)
    {
        this.peopleAmount = cnt;
    }

    int getPeopleAmount() {
        return peopleAmount;
    }
    @Override
    public int hashCode () {
        return peopleAmount  * 171;
    }
    @Override
    public String toString() {
        return "Cur crowd size:" + this.peopleAmount;
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof Crowd) {
            if (this.hashCode() == ((Crowd)o).hashCode() && (this.toString() == ((Crowd)o).toString()))
                return true;
        }
        return false;
    }
}

