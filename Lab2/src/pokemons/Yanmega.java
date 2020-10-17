package pokemons;

import Attacks.Slash;

public class Yanmega extends Yanma{
    public Yanmega(String name, int lvl) {
        super(name, lvl);
        setStats(86, 76, 86, 116, 56, 95);
        addMove(new Slash());
    }
}
