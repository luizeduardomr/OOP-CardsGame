package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlueCreatures {

    private List<CreatureCard> smallCreatures;
    private List<CreatureCard> bigCreatures;

    public BlueCreatures() {
        this.smallCreatures = new ArrayList<>();
        this.bigCreatures = new ArrayList<>();
        addBlueSmallCreatures();
        addBlueBigCreatures();
    }

    private void addBlueSmallCreatures(){

        CreatureCard roberto = new CreatureCard("roberto", "robertoimg", 1,1,1, CreatureCard.Colour.BLUE);
        smallCreatures.add(roberto);

        CreatureCard luiz = new CreatureCard("luiz", "luizimg", 1,1,1,CreatureCard.Colour.BLUE);
        smallCreatures.add(luiz);

        CreatureCard lucas = new CreatureCard("lucas", "lucasimg", 1, 1, 1, CreatureCard.Colour.BLUE);
        smallCreatures.add(lucas);

        CreatureCard pedro = new CreatureCard("pedro", "pedroimg", 0,1,2,CreatureCard.Colour.BLUE);
        smallCreatures.add(pedro);

        CreatureCard alex = new CreatureCard("alex", "aleximg", 3, 5, 4,CreatureCard.Colour.BLUE);
        smallCreatures.add(alex);

        CreatureCard aloisio = new CreatureCard("aloisio", "aloisioimg", 2, 1, 3, CreatureCard.Colour.BLUE);
        smallCreatures.add(aloisio);


    }

    private void addBlueBigCreatures(){

        CreatureCard BlueJ = new CreatureCard("BlueJ", "bluejimg",4,4,5, CreatureCard.Colour.BLUE);
        bigCreatures.add(BlueJ);

        CreatureCard gabi = new CreatureCard("gabi", "gabiimg", 3,2,4,CreatureCard.Colour.BLUE);
        bigCreatures.add(gabi);

        CreatureCard nos = new CreatureCard("nos", "nosimg", 3,3,4, CreatureCard.Colour.BLUE);
        bigCreatures.add(nos);

        CreatureCard renato = new CreatureCard("renato", "renatoimg", 5,5, 6, CreatureCard.Colour.BLUE);
        bigCreatures.add(renato);

    }

    public Card pickRandomSmallCreature(){
        Random r = new Random();
        Card randomPickedCreature;
        int tamanho = smallCreatures.size();
        int n = r.nextInt(tamanho);
        randomPickedCreature = smallCreatures.get(n);
        return randomPickedCreature;
    }

    public Card pickRandomBigCreature(){
        Random r = new Random();
        Card randomPickedCreature;
        int tamanho = bigCreatures.size();
        int n = r.nextInt(tamanho);
        randomPickedCreature = bigCreatures.get(n);
        return randomPickedCreature;
    }

}
