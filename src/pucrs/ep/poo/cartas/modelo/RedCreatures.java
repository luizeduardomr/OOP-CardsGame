package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedCreatures {

    private List<CreatureCard> creatures;

    public RedCreatures() {
        this.creatures = new ArrayList<>();
        addRedCreatures();
    }

    private void addRedCreatures(){

        CreatureCard ashenMonstrosity = new CreatureCard("ashen", "ashenimg", 9, 7,4,7, CreatureCard.Colour.RED);
        creatures.add(ashenMonstrosity);

        CreatureCard afflictedDeserter = new CreatureCard ("afflicted", "afflictedimg", 8, 3,2,4, CreatureCard.Colour.RED);
        creatures.add(afflictedDeserter);

        CreatureCard anabaBodyguard = new CreatureCard("anaba", "anabaimg", 7,2,3,4, CreatureCard.Colour.RED);
        creatures.add(anabaBodyguard);

    }

    public Card pickRandomCreature(){
        Random r = new Random();
        Card randomPickedCreature;
        int tamanho = creatures.size();
        int n = r.nextInt(tamanho);
        randomPickedCreature = creatures.get(n);
        return randomPickedCreature;
    }

}
