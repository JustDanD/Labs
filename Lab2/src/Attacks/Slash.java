package Attacks;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.Messages;
public class Slash extends PhysicalMove {
    public Slash() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
        if (def.getStat(Stat.SPEED) / 170.0D > Math.random())
            return 2 * super.calcBaseDamage(att, def);
       else
            return super.calcBaseDamage(att, def);

    }
    @Override
    protected String describe() {
        return super.describe() + " используя Slash";
    }
}
