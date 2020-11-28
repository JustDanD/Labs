public class Pond extends AnimalArea implements IFeedable {
    public Pond() {
        super.animalType = Animals.DUCK;
    }
    @Override
    void printAnimalType() {
        System.out.println("Current animals type: ducks");
    }

    @Override
    public void eat() {
        System.out.println("*Утки едят*");
    }
    @Override
    public int hashCode () {
        return super.hashCode() + 25;
    }
    @Override
    public String toString() {
        return "Cur animal type:" + this.animalType;
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof Pond) {
            if (this.hashCode() == ((Pond)o).hashCode() && (this.toString() == ((Pond)o).toString()))
                return true;
        }
        return false;
    }
}