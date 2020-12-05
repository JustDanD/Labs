public class Glade extends AnimalArea implements IFeedable, IInteractive {
    public Glade() {
        super.animalType = Animals.BEAR;
    }
    @Override
    void printAnimalType() {
        System.out.println("В данном вальере находятся медвежата");
    }


    @Override
    public void eat(double step, IBread food) {
        while (food.getInstance() > 0) {
            System.out.println("*Мишки едят*");
            food.beBitten(step);
        }
    }

    @Override
    public void beKissed() {
        System.out.println("*Мишка радостно урчит*");
    }

    @Override
    public void beStroked() {
        System.out.println("*Мишка трётся о руку*");
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
        if (o instanceof Glade) {
            if (this.hashCode() == ((Glade)o).hashCode() && (this.toString() == ((Glade)o).toString()))
                return true;
        }
        return false;
    }
}
