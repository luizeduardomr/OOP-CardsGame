package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlueSorceries {
    private List<SorceryCard> magias;

    public BlueSorceries() {
        this.magias = new ArrayList<>();
        addBlueSorceries();
    }

    private void addBlueSorceries(){

        SorceryCard aerial = new SorceryCard("aerial", "aerialimg",5, SorceryCard.Colour.BLUE, 1);
        magias.add(aerial);

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
