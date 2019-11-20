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
    public int quantityOfManaSource = 30;
    public int quantityOfSmallCreatures = 20;
    public int quantityOfBigCreatures = 10;
    public int getQuantityOfMagics = 0;
    private List<Card> cartas;

    public Deck(int jogador) {
        cartas = new ArrayList<Card>(NCARDS);
        Random r = new Random();

        //montando deck do jogador 1
        if (jogador == 1) {
            //jogador 1 manaSources - só recebe a carta 1
            for (int i = 0; i < quantityOfManaSource; i++) {
                Card c = new TerrainCard("arena", "arenaimg", TerrainCard.Colour.BLUE);
                cartas.add(c);
            }

            //jogador 1 creatures - cartas de 2 a 4 de forma aleatória
            BlueCreatures criaturasAzuis = new BlueCreatures();
            for (int i = 0; i < quantityOfSmallCreatures; i++) {
                Card criatura = criaturasAzuis.pickRandomSmallCreature();
                cartas.add(criatura);
            }

            for (int i = 0; i < quantityOfBigCreatures; i++) {
                Card criatura = criaturasAzuis.pickRandomBigCreature();
                cartas.add(criatura);
            }

            //jogador 1 feitiços
            BlueSorceries magiasAzuis = new BlueSorceries();
            for (int i = 0; i < getQuantityOfMagics; i++) {
                Card magia = magiasAzuis.pickRandomSorcery();
                cartas.add(magia);
            }
        }

        //montando deck do jogador 2 - Colorado
        else if (jogador == 2) {
            //jogador 2 manaSources
            for (int i = 0; i < quantityOfManaSource; i++) {
                Card c = new TerrainCard("beira", "beiraimg", TerrainCard.Colour.RED);
                cartas.add(c);
            }

            //jogador 2 creatures
            RedCreatures criaturasVermelhas = new RedCreatures();
            for (int i = 0; i < quantityOfSmallCreatures; i++) {
                Card criatura = criaturasVermelhas.pickRandomSmallCreature();
                cartas.add(criatura);
            }

            for (int i = 0; i < quantityOfBigCreatures; i++) {
                Card criatura = criaturasVermelhas.pickRandomBigCreature();
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



