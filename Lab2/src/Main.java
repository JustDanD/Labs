import pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

/*Landorus p1 = new Landorus("Rocky", 43);
        Igglybuff p2 = new Igglybuff("Iggy", 1);
        Jigglypuff p3 = new Jigglypuff("JIggy", 41);
        Wigglytuff p4 = new Wigglytuff("WIggy", 1);
        Yanma p5 = new Yanma("Yan", 11);
        Yanmega p6 = new Yanmega("Mega", 43);*/

public class Main {
    public static void main(String[] args) {

        int i = 0;
        Pokemon[] Pokemons = new Pokemon[args.length / 3];
        while(i < args.length / 3) {
            switch(args[i*3]) {
                case "Landorus":
                    Pokemons[i] = new Landorus(args[i * 3 + 1], Integer.valueOf(args[i * 3 + 2]));
                    break;
                case "Igglybuff":
                    Pokemons[i] = new Igglybuff(args[i * 3 + 1], Integer.valueOf(args[i * 3 + 2]));
                    break;
                case "Jigglypuff":
                    Pokemons[i] = new Jigglypuff(args[i * 3 + 1], Integer.valueOf(args[i * 3 + 2]));
                    break;
                case "Wigglytuff":
                    Pokemons[i] = new Wigglytuff(args[i * 3 + 1], Integer.valueOf(args[i * 3 + 2]));
                    break;
                case "Yanma":
                    Pokemons[i] = new Yanma(args[i * 3 + 1], Integer.valueOf(args[i * 3 + 2]));
                    break;
                case "Yanmega":
                    Pokemons[i] = new Yanmega(args[i * 3 + 1], Integer.valueOf(args[i * 3 + 2]));
                    break;
            }
            i++;
        }
        Battle b1 = new Battle();
        i = 0;
        while (i <= args.length / 6) {
            if (i < args.length / 3)
                b1.addAlly(Pokemons[i]);
            if (i + 1 < args.length / 3)
                b1.addFoe(Pokemons[i + 1]);
            i++;
        }

        if (args.length / 6 >= 1)
          b1.go();
        else
            System.out.println("Мало покемонов");
    }
}
