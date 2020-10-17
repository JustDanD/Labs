package Attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 1);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.EVASION, 1);
    }
}
