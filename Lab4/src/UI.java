import java.io.IOException;
import java.util.Scanner;

public class UI {
    static public int bribeUI(InternalAffairs target, IScoopFamily Scoop) {
        Scanner in = new Scanner(System.in);
        System.out.println("Харктеристики полицейского:\nУровень честности:" + target.getFaithLvl() + " из 10 \nРаздражённость:" + target.getNerves() + "%\nВаш баланс:" + Scoop.getBalance()
                + "$\n Введите размер взятки:");
        while (true) {

            int sum = in.nextInt();
            if (sum > Scoop.getBalance()) {
                System.out.println("Введённая сумма больше, чем у вас есть. Введите значение меньше " + Scoop.getBalance() + ":");
            } else
                return sum;
        }
    }
}
