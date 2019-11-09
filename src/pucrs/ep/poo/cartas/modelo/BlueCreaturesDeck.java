package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlueCreaturesDeck {

    private List<CreatureCard> creatures;

    public BlueCreaturesDeck() {
        this.creatures = new ArrayList<>();
        addBlueCreatures();
    }

    private void addBlueCreatures(){

        CreatureCard aethersquallAncient = new CreatureCard("aether", "aetherimg", 2, 6,6,7, CreatureCard.Colour.BLUE);
        creatures.add(aethersquallAncient);

        CreatureCard aeronautTinkerer = new CreatureCard ("aeronaut", "aeronautimg", 3, 2,3,3, CreatureCard.Colour.BLUE);
        creatures.add(aeronautTinkerer);

        CreatureCard aberrantResearcher = new CreatureCard("aberrant", "aberrantimg", 4,3,2,4, CreatureCard.Colour.BLUE);
        creatures.add(aberrantResearcher);

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
