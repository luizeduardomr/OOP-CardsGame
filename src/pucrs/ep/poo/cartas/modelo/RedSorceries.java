package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedSorceries {

    private List<SorceryCard> magias;

    public RedSorceries() {
        this.magias = new ArrayList<>();
        addRedSorceries();
    }

    private void addRedSorceries(){

        //SorceryCard agility = new SorceryCard("agility", "agilityimg",10, SorceryCard.Colour.RED, 2);
        //magias.add(agility);

    }

    public Card pickRandomSorcery(){
        Random r = new Random();
        Card randomPickedSorcery;
        int tamanho = magias.size();
        int n = r.nextInt(tamanho);
        randomPickedSorcery = magias.get(n);
        return randomPickedSorcery;
    }
}
