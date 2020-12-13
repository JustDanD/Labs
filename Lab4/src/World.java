import sun.nio.cs.Surrogate;

import java.util.ArrayList;

public class World {
    ArrayList<AnimalArea> animalAreas;
    Guard guard;
    Crowd crowd;
    IScoopFamily Scoop;
    private static int maxVisiters = 30;
    FSBGroup fsbGroup;
    boolean karlsonIsAlive = true;

    public static class Plan {
        private int id;
        ArrayList<String> availableAnimalTypes = new ArrayList<>();

        public Plan( int id) {
            this.id = id;
            availableAnimalTypes.add("Ducks");
            availableAnimalTypes.add("Bears");
        }
            public ArrayList<String> getAvailableAnimalTypes() {
                return availableAnimalTypes;
            }

        public int getMaxVisiters() {
            return maxVisiters;
        }

        public int getId() {
            return id;
        }
    }
    public World() {
        this.animalAreas = new ArrayList<>();
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
        this.crowd = new Crowd((int)(Math.random() * maxVisiters - 5));


        Scoop = new IScoopFamily() {
            private String name = "Scooperfield";
            private AnimalArea curArea;
            private boolean isArmed = Math.random() > 0.4 ? true : false, isProtected;
            class Bread implements IBread {
                private double size, cursize, instance;

                public Bread(double size) {
                    this.instance = 100;
                    this.size = size;
                    this.cursize = size;
                }

                public double getInstance() {
                    return this.instance;
                }
                public double getSize() {
                    return this.size;
                }
                public void beBitten(double step) {
                    cursize = cursize - step;
                    instance = cursize / size * 100;
                }

                @Override
                public int hashCode () {
                    return  (int)(31 * size - 25 * cursize + 43 * instance);

                }
                @Override
                public String toString() {
                    return "Cur bread size:" + this.size + "; cursize:" + this.cursize + "instance:" + this.instance;
                }
                @Override
                public boolean equals( Object o) {
                    if (o instanceof Bread) {
                        return this.hashCode() == ((Bread) o).hashCode() && (this.toString() == ((Bread) o).toString());
                    }
                    return false;
                }
            }
            Bread bread = new Bread(Math.random() * 20);
            public boolean getIsArmed() {
                return isArmed;
            }
            public boolean getIsProtected() {
                return isProtected;
            }
            public void setIsProtected( boolean inst) {
                this.isProtected = inst;
            }
            @Override
            public void setCurArea( AnimalArea newArea) {
                this.curArea = newArea;
            }

            @Override
            public void feedAnimals() {
                if (curArea instanceof IFeedable) {
                    try {
                        System.out.println("Скуперфильд крошит булку");
                        ((IFeedable) curArea).eat(Math.random() * 5, bread);
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
                    if (guard.giveAccess(crowd.getPeopleAmount())) {
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
                return this.bread.hashCode() + this.curArea.hashCode() + this.name.hashCode();
            }
            @Override
            public String toString() {
                return "Cur name:" + this.name + " animal area:" + this.toString() + "bread:" + this.bread.toString();
            }
            @Override
            public boolean equals( Object o) {
                if (o instanceof IScoopFamily) {
                    return this.hashCode() == ((IScoopFamily) o).hashCode() && (this.toString() == ((IScoopFamily) o).toString());
                }
                return false;
            }
        };
        if (karlsonIsAlive) {
            Scoop.setIsProtected(false);
            fsbGroup = null;
        }
    }

    public void startAction() {
        int i = 0;
        System.out.println("*Скуперфильд приходит в зоопарк*");
        if (karlsonIsAlive) {
            while(i < animalAreas.size()) {
            Scoop.setCurArea(animalAreas.get(i));
            Scoop.feedAnimals();
            if (Scoop.askAccess()) {
                Scoop.strokeAnimal();
                Scoop.kissAnimal();
            }
            i++;
        }
        System.out.println("*Скуперфильд  уходит*");
        }
    }
    @Override
    public int hashCode () {
        return animalAreas.hashCode() + guard.hashCode() + crowd.hashCode() + Scoop.hashCode();
    }
    @Override
    public String toString() {
        return "Cur guard:" + guard.toString() + " animalAreas" + animalAreas.toString() + " crowd" + crowd.toString() + " Scoop:" + Scoop.toString();
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof World) {
            return this.hashCode() == ((World) o).hashCode() && (this.toString() == ((World) o).toString());
        }
        return false;
    }
}
