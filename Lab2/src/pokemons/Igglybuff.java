package pokemons;

import Attacks.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Igglybuff extends Pokemon {
    public Igglybuff(String name, int  lvl) {
        super(name, lvl);
        setStats(90, 30, 13, 40, 20, 15);
        setType(Type.NORMAL, Type.FAIRY);
        setMove(new DoubleTeam(), new Sing());
    }
}
