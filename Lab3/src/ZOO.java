import java.util.ArrayList;

public class ZOO {
    ArrayList<AnimalArea> animalAreas;
    Guard guard;
    Crowd crowd;
    IScoopFamily Scoop;


    public ZOO() {
        this.animalAreas = new ArrayList<AnimalArea>();
        this.animalAreas.add(new Pond());
        this.animalAreas.add(new Glade());
        double moodcoef = Math.random();
        if (moodcoef <= 0.1)
            this.guard = new Guard("Валера", Mood.WORST);
        else if (moodcoef <= 0.3)
            this.guard = new Guard("Валера", Mood.BAD);
        else if (moodcoef <= 0.5)
            this.guard = new Guard("Валера", Mood.NORMAl);
        else if (moodcoef <= 0.7)
            this.guard = new Guard("Валера", Mood.GOOD);
        else
            this.guard = new Guard("Валера", Mood.BEST);
        this.crowd = new Crowd((int)(Math.random() * 30 - 5));

        Scoop = new IScoopFamily() {
            String name = "Scooperfield";
            AnimalArea curArea;

            class Bread {
                private double size, cursize, instance = 100;

                public Bread(double size) {
                    this.instance = 100;
                    this.size = size;
                    this.cursize = size;
                }

                void use(double step, Animals type) throws WrongStepExp {
                    switch (type) {
                        case DUCK:
                            if (step <= 0.6 * size) {
                                while (instance > 50) {
                                    cursize = cursize - step;
                                    instance = cursize / size * 100;
                                    System.out.println("Скуперфильд крошит булку");
                                }
                                return;
                            }
                            else
                                throw new WrongStepExp("Шаг больше половины булки.");
                        case BEAR:
                            while (instance > 0) {
                                cursize = cursize - step;
                                instance = cursize / size * 100;
                                System.out.println("Скуперфильд крошит булку");
                            }
                            return;
                    }
                }
                @Override
                public int hashCode () {
                    return super.hashCode() + 25;
                }
                @Override
                public String toString() {
                    return "Cur bread size:" + this.size + "; cursize:" + this.cursize + "instance:" + this.instance;
                }
                @Override
                public boolean equals( Object o) {
                    if (o instanceof Bread) {
                        if (this.hashCode() == ((Bread)o).hashCode() && (this.toString() == ((Bread)o).toString()))
                            return true;
                    }
                    return false;
                }
            }

            Bread bread = new Bread(Math.random() * 20);

            @Override
            public void setCurArea( AnimalArea newArea) {
                this.curArea = newArea;
            }

            @Override
            public void feedAnimals() {
                if (curArea instanceof IFeedable) {
                    try {
                        bread.use(Math.random() * 5, curArea.animalType);
                        ((IFeedable) curArea).eat();
                    } catch(WrongStepExp e) {
                        System.out.println(e.getMessage());
                    }

                }
                else
                    System.out.println("Здравый смысл подсказывает: Животных  нельзя кормить!!!!");
            }

            @Override
            public void strokeAnimal() {
                if (curArea instanceof IInteractive) {
                    System.out.println("Скуперфильд гладит " + curArea.animalType);
                    ((IInteractive) curArea).beStroked();
                }
                else
                    System.out.println("Здравый смысл подсказывает:  Животных  нельзя трогать!!!!");
            }

            @Override
            public void kissAnimal() {
                if (curArea instanceof IInteractive) {
                    System.out.println("Скуперфильд целует " + curArea.animalType);
                    ((IInteractive)curArea).beStroked();
                }
                else
                    System.out.println("Здравый смысл подсказывает: Животных  нельзя трогать!!!!");
            }

            @Override
            public boolean askAccess() {
                if (curArea instanceof IInteractive) {
                    System.out.println("Скуперфильд: Можно погладить?");
                    if (guard.giveAccess(crowd.getPeopleAmount()) == true) {
                        System.out.println(guard.name + ":Да, только аккуратно и тихо.");
                        System.out.println("Скуперфильд: Спасибо!!");
                        return true;
                    } else {
                        System.out.println(guard.name + ":НЕТ! Для кого знак поставили...");
                        System.out.println("Скуперфильд: Не очень и хотелось");
                        return false;
                    }

                }
                return false;
            }
            public int hashCode () {
                return super.hashCode() + 25;
            }
            @Override
            public String toString() {
                return "Cur name:" + this.name + " animal area:" + this.curArea + "bread:" + this.bread.toString();
            }
            @Override
            public boolean equals( Object o) {
                if (o instanceof IScoopFamily) {
                    if (this.hashCode() == ((IScoopFamily)o).hashCode() && (this.toString() == ((IScoopFamily)o).toString()))
                        return true;
                }
                return false;
            }
        };
    }

    public void startAction() {
        int i = 0;
        System.out.println("*Скуперфильд приходит*");
        while(i < animalAreas.size()) {
            Scoop.setCurArea(animalAreas.get(i));
            Scoop.feedAnimals();
            if (Scoop.askAccess() == true) {
                Scoop.strokeAnimal();
                Scoop.kissAnimal();
            }
            i++;
        }
        System.out.println("*Скуперфильд  уходит*");
    }
    @Override
    public int hashCode () {
        return super.hashCode() + 25;
    }
    @Override
    public String toString() {
        return "Cur guard:" + guard.toString() + " animalAreas" + animalAreas.toString() + " crowd" + crowd.toString() + " Scoop:" + Scoop.toString();
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof ZOO) {
            if (this.hashCode() == ((ZOO)o).hashCode() && (this.toString() == ((ZOO)o).toString()))
                return true;
        }
        return false;
    }
}
