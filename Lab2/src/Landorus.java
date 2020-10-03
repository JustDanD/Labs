import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Landorus extends Pokemon {
    public Landorus(String name, int  lvl, double hp, double def, double attack, double spatck, double spdef, double spd, Type type) {
        super(name, lvl);
        setStats(hp, attack, def, spatck, spdef, spd);
        setType(type);
    }
    
}
