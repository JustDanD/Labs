package pokemons;

import Attacks.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Yanma extends Pokemon {
    public Yanma (String name, int  lvl) {
        super(name, lvl);
        setStats(65, 65, 45, 75, 45, 95);
        setType(Type.BUG, Type.FLYING);
        setMove(new LeechLife(), new DoubleTeam(), new ShadowBall());
    }
}
