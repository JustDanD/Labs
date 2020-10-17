import pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Pokemon p1 = new Landorus("Rocky", 43);
        Pokemon p2 = new Igglybuff("Iggy", 1);
        Pokemon p3 = new Jigglypuff("JIggy", 41);
        Pokemon p4 = new Wigglytuff("WIggy", 1);
        Pokemon p5 = new Yanma("Yan", 11);
        Pokemon p6 = new Yanmega("Mega", 43);

        Battle b1 = new Battle();
        b1.addAlly(p3);
        b1.addAlly(p1);
        b1.addAlly(p5);
        b1.addFoe(p4);
        b1.addFoe(p2);
        b1.addFoe(p6);
        b1.go();
    }
}
