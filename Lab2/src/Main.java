import pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

public class Main {
    public static void main(String[] args) {
        Landorus p1 = new Landorus("Rocky", 43);
        Igglybuff p2 = new Igglybuff("Iggy", 1);
        Jigglypuff p3 = new Jigglypuff("JIggy", 41);
        Wigglytuff p4 = new Wigglytuff("WIggy", 1);
        Yanma p5 = new Yanma("Yan", 11);
        Yanmega p6 = new Yanmega("Mega", 43);
        Battle b1 = new Battle();
        b1.addAlly(p6);
        b1.addAlly(p2);
        b1.addAlly(p4);
        b1.addFoe(p5);
        b1.addFoe(p3);
        b1.addFoe(p1);
        b1.go();
    }
}
