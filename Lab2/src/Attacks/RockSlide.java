package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class RockSlide extends PhysicalMove {
    public RockSlide() {
        super(Type.ROCK, 75, 90 );
    }
    protected void applyOppEffects(Pokemon p) {
        double chance = Math.random() * 10;
        if (chance <= 3)
            Effect.flinch(p);
    }
    @Override
    protected String describe() {
        return super.describe() + " используя RockSlide";
    }
}
