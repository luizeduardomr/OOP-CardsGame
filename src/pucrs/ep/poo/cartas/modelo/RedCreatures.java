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

        //CreatureCard ashenMonstrosity = new CreatureCard("ashen", "ashenimg", 9, 7,4,7, CreatureCard.Colour.RED);
        //creatures.add(ashenMonstrosity);

        //CreatureCard afflictedDeserter = new CreatureCard ("afflicted", "afflictedimg", 8, 3,2,4, CreatureCard.Colour.RED);
        //creatures.add(afflictedDeserter);

        //CreatureCard anabaBodyguard = new CreatureCard("anaba", "anabaimg", 7,2,3,4, CreatureCard.Colour.RED);
        //creatures.add(anabaBodyguard);

        CreatureCard aprendiz = new CreatureCard("aprendiz", "aprendizimg", 1,1,1, CreatureCard.Colour.RED);
        creatures.add(aprendiz);

        CreatureCard mek = new CreatureCard("mek", "mekimg", 1,1,1, CreatureCard.Colour.RED);
        creatures.add(mek);

        CreatureCard amor = new CreatureCard("amor", "amorimg", 3, 3, 2, CreatureCard.Colour.RED);
        creatures.add(amor);

        CreatureCard Magnata = new CreatureCard("magnata", "magnataimg", 5,6,4, CreatureCard.Colour.RED);
        creatures.add(Magnata);

        CreatureCard forca = new CreatureCard("forca", "forcaimg", 2,2,2, CreatureCard.Colour.RED);
        creatures.add(forca);

        CreatureCard IntelliJ = new CreatureCard("IntelliJ", "intellijimg", 5,5,4, CreatureCard.Colour.RED);
        creatures.add(IntelliJ);

        CreatureCard mago = new CreatureCard("mago", "magoimg", 3,3,3, CreatureCard.Colour.RED);
        creatures.add(mago);

        CreatureCard mexicans = new CreatureCard("mexicans", "meximg", 4,4,3, CreatureCard.Colour.RED);
        creatures.add(mexicans);

        CreatureCard ra = new CreatureCard("ra", "raimg", 1,2,1, CreatureCard.Colour.RED);
        creatures.add(ra);



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
