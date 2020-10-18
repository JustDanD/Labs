package Attacks;

import ru.ifmo.se.pokemon.*;

public class ShadowBall extends SpecialMove {
    public ShadowBall() {
        super(Type.GHOST, 80, 100);
    }
    protected void applyOppEffects(Pokemon p) {
        double chance = Math.random() * 10;
        if (chance <= 2)
            p.setMod(Stat.SPECIAL_DEFENSE, -1);
    }
    @Override
    protected String describe() {
        return super.describe() + " используя Shadow Ball";
    }
}
