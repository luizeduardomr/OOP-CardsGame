package pucrs.ep.poo.cartas.modelo;

import pucrs.ep.poo.cartas.gui.GameEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import pucrs.ep.poo.cartas.gui.GameEvent;

public class RealDeck extends Observable {

    public static final int NCARDS = 60;
    //public int quantityOfManaSource = NCARDS/2;
    //public int quantityOfCreatures = NCARDS/4;
    //public int getQuantityOfMagics = NCARDS/4;
    public int quantityOfManaSource = 30;
    public int quantityOfCreatures = 20;
    public int getQuantityOfMagics = 10;
    private List<Card> cartas;

    public RealDeck(int jogador) {
        cartas = new ArrayList<Card>(NCARDS);
        Random r = new Random();

        //montando deck do jogador 1 com as cartas de 1 até 5
        if (jogador == 1) {
            //jogador 1 manaSources - só recebe a carta 1
            for (int i = 0; i < quantityOfManaSource; i++) {
                Card c = new Card("C1", "img1", 1);
                cartas.add(c);
            }

            //jogador 1 creatures - cartas de 2 a 4 de forma aleatória
            for (int i = 0; i < quantityOfCreatures; i++) {
                int n = r.nextInt(3) + 2;
                Card c = new Card("C" + n, "img" + n, n);
                cartas.add(c);
            }

            //jogador 1 mágicas - só recebe carta 5
            for (int i = 0; i < getQuantityOfMagics; i++) {
                //int n = r.nextInt(1) + 5;
                Card c = new Card("C5", "img5", 5);
                cartas.add(c);
            }
        }

        //montando deck do jogador 2 com as cartas de 6 até 10
        else if (jogador == 2) {
            //jogador 2 manaSources - só recebe a carta 6
            for (int i = 0; i < quantityOfManaSource; i++) {
                Card c = new Card("C6", "img6", 6);
                cartas.add(c);
            }

            //jogador 2 creatures - cartas de 7 a 9 de forma aleatória
            for (int i = 0; i < quantityOfCreatures; i++) {
                int n = r.nextInt(3) + 7;
                Card c = new Card("C" + n, "img" + n, n);
                cartas.add(c);
            }

            //jogador 2 mágicas - só recebe carta 10
            for (int i = 0; i < getQuantityOfMagics; i++) {
                int n = r.nextInt(1) + 10;
                Card c = new Card("C" + n, "img" + n, n);
                cartas.add(c);
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



