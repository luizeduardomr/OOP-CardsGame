package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Deck extends Observable {

    public static final int NCARDS = 60;
    //public int quantityOfManaSource = NCARDS/2;
    //public int quantityOfCreatures = NCARDS/4;
    //public int getQuantityOfMagics = NCARDS/4;
    public int quantityOfManaSource = 60;
    public int quantityOfCreatures = 0;
    public int getQuantityOfMagics = 0;
    private List<Card> cartas;

    public Deck(int jogador) {
        cartas = new ArrayList<Card>(NCARDS);
        Random r = new Random();

        //montando deck do jogador 1
        if (jogador == 1) {
            //jogador 1 manaSources - só recebe a carta 1
            for (int i = 0; i < quantityOfManaSource; i++) {
                Card c = new TerrainCard("island", "islandimg", 1, TerrainCard.Colour.BLUE);
                cartas.add(c);
            }

            //jogador 1 creatures - cartas de 2 a 4 de forma aleatória
            BlueCreatures criaturasAzuis = new BlueCreatures();
            for (int i = 0; i < quantityOfCreatures; i++) {
                Card criatura = criaturasAzuis.pickRandomCreature();
                cartas.add(criatura);
            }

            //jogador 1 feitiços
            BlueSorceries magiasAzuis = new BlueSorceries();
            for (int i = 0; i < getQuantityOfMagics; i++) {
                Card magia = magiasAzuis.pickRandomSorcery();
                cartas.add(magia);
            }
        }

        //montando deck do jogador 2 com as cartas de 6 até 10
        else if (jogador == 2) {
            //jogador 2 manaSources - só recebe a carta 6
            for (int i = 0; i < quantityOfManaSource; i++) {
                Card c = new TerrainCard("mountain", "islandimg", 6, TerrainCard.Colour.RED);
                cartas.add(c);
            }

            //jogador 2 creatures - cartas de 7 a 9 de forma aleatória
            RedCreatures criaturasVermelhas = new RedCreatures();
            for (int i = 0; i < quantityOfCreatures; i++) {
                Card criatura = criaturasVermelhas.pickRandomCreature();
                cartas.add(criatura);
            }

            //jogador 2 feitiços
            RedSorceries magiasVermelhas = new RedSorceries();
            for (int i = 0; i < getQuantityOfMagics; i++) {
                Card magia = magiasVermelhas.pickRandomSorcery();
                cartas.add(magia);
            }
        }
    }

    public List<Card> getCards() {
        return (cartas);
    }

    public int getNumberOfCards() {
        return (cartas.size());
    }

    public Card buyACard(){
        Random r = new Random();
        Card buyedCard;
        int n = r.nextInt(60);
        buyedCard = cartas.get(n);
        return buyedCard;
    }

}



