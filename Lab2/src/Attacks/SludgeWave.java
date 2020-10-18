package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class SludgeWave extends SpecialMove {
    public SludgeWave() {
        super(Type.POISON, 95, 100 );
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        double chance = Math.random() * 10;
        if (chance <= 1)
            Effect.poison(p);
    }
    @Override
    protected String describe() {
        return super.describe() + " используя Sludge Wave";
    }
}
