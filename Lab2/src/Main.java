import pokemons.Landorus;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Pokemon p1 = new Landorus("Eval", 35);
        Pokemon p2 = new Landorus("Rol", 35);
        Battle b1 = new Battle();
        b1.addAlly(p1);
        b1.addFoe(p2);
        b1.go();
    }
}
