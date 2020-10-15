package pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Landorus extends Pokemon {
    public Landorus(String name, int  lvl) {
        super(name, lvl);
        setStats(89, 125, 90, 115, 80, 101);
        setType(Type.GROUND, Type.FLYING);
    }
}
