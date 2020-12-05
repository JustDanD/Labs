public class Pond extends AnimalArea implements IFeedable {
    public Pond() {
        super.animalType = Animals.DUCK;
    }
    @Override
    void printAnimalType() {
        System.out.println("Current animals type: ducks");
    }

    @Override
    public void eat(double step,  IBread food) throws WrongStepExp {

        if (step <= 0.6 * food.getSize()) {
            while (food.getInstance() > 50) {
                System.out.println("*Утки едят*");
                food.beBitten(step);
            }
            return;
        }
        else
            throw new WrongStepExp("Шаг больше половины булки.");

    }
    @Override
    public int hashCode () {
        return super.animalType.hashCode();
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