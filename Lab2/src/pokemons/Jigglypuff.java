package pokemons;

import Attacks.Slash;
import Attacks.WakeUpSlap;

public class Jigglypuff extends Igglybuff {
    public Jigglypuff(String name, int lvl) {
        super(name, lvl);
        setStats(115, 45, 20, 45, 25, 20);
        addMove(new WakeUpSlap());
    }
}
