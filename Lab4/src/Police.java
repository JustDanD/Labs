import java.lang.reflect.*;

public class Police extends InternalAffairs {
    private static boolean instance = false;
    private boolean isScoopsPolice;

    private Police() {
        this.faithLvl = (int)(Math.random() * 10);
        this.nerves = 0;
        this.isScoopsPolice = Math.random() > 0.5 ? true : false;
        this.instance = true;
    }

    public  int getFaithLvl() {
        return faithLvl;
    }

    public  int getNerves() {
        return nerves;
    }

    public boolean getIsScoopsPolice() {
        return isScoopsPolice;
    }

    static public Police createPD() {
        if (instance == false)
            return new Police();
        else {
            System.out.println("Полицейский департамент уже существует!");
            return null;
        }
    }

     public boolean acceptRequest() {
        if (Math.random() >= 0.4) {
            System.out.println("Диспетчер: Отправляю к вам отряд, ожидайте.");
            return true;
        }
        else {
            System.out.println("Диспетчер: Извините, но сейчас свободных отрядов нет.");
            return false;
        }
    }
    public void coming() {
        System.out.println("Полицейский: Добрый день! Капитан полиции Дмитрий Валерьевич Карпов. Вызывали?");
    }
    public void leaving() {
        System.out.println("Полицейский: Хорошего вам дня, до свидания!");
    }
    public void disarm(IScoopFamily sc) {
        try {
            Field f = sc.getClass().getDeclaredField("isArmed");
            f.setAccessible(true);
            f.set(sc, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void arest(Object prisoner, Jail j) {
        System.out.println("Полицейский: Вы арестованы!");
        j.addPrisoner(prisoner);
    }
    public boolean acceptBribe( int amount ) {
        int csum = (10 - this.faithLvl) * amount / 250;
        if (csum >= 100)
            return true;
        else {
            this.nerves = this.nerves + (100 - csum);
            return false;
        }
    }

}
