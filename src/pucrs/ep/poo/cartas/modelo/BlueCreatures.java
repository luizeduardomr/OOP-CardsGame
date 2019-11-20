package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlueCreatures {

    private List<CreatureCard> creatures;

    public BlueCreatures() {
        this.creatures = new ArrayList<>();
        addBlueCreatures();
    }

    private void addBlueCreatures(){

        //CreatureCard aethersquallAncient = new CreatureCard("aether", "aetherimg", 2, 6,6,7, CreatureCard.Colour.BLUE);
        //creatures.add(aethersquallAncient);

        //CreatureCard aeronautTinkerer = new CreatureCard ("aeronaut", "aeronautimg", 3, 2,3,3, CreatureCard.Colour.BLUE);
        //creatures.add(aeronautTinkerer);

        //CreatureCard aberrantResearcher = new CreatureCard("aberrant", "aberrantimg", 4,3,2,4, CreatureCard.Colour.BLUE);
        //creatures.add(aberrantResearcher);

        CreatureCard roberto = new CreatureCard("roberto", "robertoimg", 1,1,1, CreatureCard.Colour.BLUE);
        creatures.add(roberto);

        CreatureCard luiz = new CreatureCard("luiz", "luizimg", 1,1,1,CreatureCard.Colour.BLUE);
        creatures.add(luiz);

        CreatureCard lucas = new CreatureCard("lucas", "lucasimg", 1, 1, 1, CreatureCard.Colour.BLUE);
        creatures.add(lucas);

        CreatureCard pedro = new CreatureCard("pedro", "pedroimg", 0,1,2,CreatureCard.Colour.BLUE);
        creatures.add(pedro);

        CreatureCard alex = new CreatureCard("alex", "aleximg", 3, 5, 4,CreatureCard.Colour.BLUE);
        creatures.add(alex);

        CreatureCard aloisio = new CreatureCard("aloisio", "aloisioimg", 2, 1, 3, CreatureCard.Colour.BLUE);
        creatures.add(aloisio);

        CreatureCard BlueJ = new CreatureCard("BlueJ", "bluejimg",4,4,5, CreatureCard.Colour.BLUE);
        creatures.add(BlueJ);

        CreatureCard gabi = new CreatureCard("gabi", "gabiimg", 3,2,4,CreatureCard.Colour.BLUE);
        creatures.add(gabi);

        CreatureCard nos = new CreatureCard("nos", "nosimg", 3,3,4, CreatureCard.Colour.BLUE);
        creatures.add(nos);

        //CreatureCard Padawan = new CreatureCard("Padawan", "Padawanimg", 1,1,1, CreatureCard.Colour.BLUE);
        //creatures.add(Padawan);

        CreatureCard renato = new CreatureCard("renato", "renatoimg", 5,5, 6, CreatureCard.Colour.BLUE);
        creatures.add(renato);




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
