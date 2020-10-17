package pokemons;

import Attacks.Swagger;
import Attacks.WakeUpSlap;

public class Wigglytuff extends Jigglypuff  {
    public Wigglytuff(String name, int lvl) {
        super(name, lvl);
        setStats(140, 70, 45, 85, 50, 45);
        addMove(new Swagger());
    }
}
