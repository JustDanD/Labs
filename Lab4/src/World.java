import java.util.ArrayList;
import java.util.Scanner;

public class World {
    ArrayList<AnimalArea> animalAreas;
    Guard guard;
    Crowd crowd;
    IScoopFamily Scoop;
    private static int maxVisiters = 30;
    FSBGroup fsbGroup;
    boolean karlsonIsAlive = true;
    boolean gangIsAlive = true;
    boolean isKnown = true;
    String gangName = "Афоня";
    String killedBy = "";
    Police pd = Police.createPD();
    Jail jail = new Jail();


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
            private boolean isArmed = true/*Math.random() > 0.4 ? true : false*/, isProtected;
            private int balance = 30000;
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

            public int getBalance() {
                return balance;
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

            public boolean bribe(InternalAffairs trg) {
                System.out.println("Скуперфильд: Думаю мы могли бы дговориться.");
                while (pd.getNerves() < 100) {
                    int sum = UI.bribeUI(pd, Scoop);
                    System.out.println("Скуперфильд: Как насчёт " + sum + "$?");
                    if(pd.acceptBribe(sum)) {
                        System.out.println("Полицейский: Хорошее предложение. Согласен.");
                        return true;
                    }
                }
                System.out.println("Нет, так не пойдёт!");
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
            while (i < animalAreas.size()) {
                Scoop.setCurArea(animalAreas.get(i));
                Scoop.feedAnimals();
                if (Scoop.askAccess()) {
                    Scoop.strokeAnimal();
                    Scoop.kissAnimal();
                }
                if (Scoop.getIsArmed() && Math.random() < 0.9) {
                    System.out.println("Охранник замечает пистолет у Скуперфильда под пальто и решает вызвать полицию.");
                    guard.callThePolice();
                    if (pd.acceptRequest()) {
                        pd.coming();
                        System.out.println(guard.name + ":Да, офицер! У того мужчины пистолет!");
                        if (pd.getIsScoopsPolice()) {
                            System.out.println("Полицейский: У этого? Ты уверен? \n" + guard.name + ": Да! Точно он!\n" +
                                   "Полицейский: Что ж... Ты совершил ошибку, а значит должен понести наказание...\n" +
                                    guard.name + "в шоке сдаётся полиции");
                            pd.arest(guard, jail);
                        }
                        else {
                            System.out.println("Полицейский: Гражданин, стойте. *Обыскивает и находит пистолет.* Незаконное ношение оружия.");
                            if (Scoop.bribe(pd)) {
                                pd.leaving();
                                System.out.println("Скуперфильд: Ты совершил большую ошибку...Надеюсь, ты отныне будешь думать, что делаешь! Вали отсюда.\n*"+guard.name+" уходит*");
                            }
                            else {
                                pd.arest(Scoop, jail);
                                System.out.println("Скуперфильд: Вы все ещё ответите за это!");
                                System.out.println("Продолжение в следующей серии...");
                                return;
                            }
                        }

                    } else {
                        System.out.println(guard.name +": Вот дьявол!");
                    }
                    break;
                }
                i++;
            }
            System.out.println("Звонит телефон Скуперфильда.\n" + gangName + ": Шеф, покушение не удалось. Цель жива...");
            System.out.println("Скуперфильд: Чёрт! Они что-то заподозрили?");
            if (isKnown) {
                System.out.println(gangName + ": Да, я еле оттуда ноги унёс.");
                System.out.println("Скуперфильд: ... \"Отсрые пропеллеры\" будут мстить, война лишь усугубится...");
                System.out.println("Входящее сообщение\n Получатель: Скуперфильд\n Отправитель Ярослав \"Малыш\" Абузов\n Завтра в 16:00 в детском саду Ромашка. Нам есть, что обсудить.");
                System.out.println("Скуперфильд: Хм...");
                System.out.println("1.Принять предложение. \n2.Отказаться.");
                Scanner in = new Scanner(System.in);
                if (in.nextInt() == 1)
                    System.out.println("Скуперфильд: Ну послушаем, что он скажет.");
                else {
                    System.out.println("Скуперфильд:" + gangName + ", пора закончить с пропеллерами навсегда. Возьми людей и уладь вопрос. И чтобы в этот раз в случае провала живым не возвращался.");
                    System.out.println(gangName + ": Есть босс");
                }
            }
            else {
                System.out.println(gangName + ": Нет, никто ничего не знает .");
                System.out.println("Скуперфильд: Что ж... Тогда мы должны уничтожить \"Отсрые пропеллеры\" раньше, чем они поймут, что случилось.");
                System.out.println("Продолжение в следующей серии...");
            }
            System.out.println("Скуп уходит");
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
