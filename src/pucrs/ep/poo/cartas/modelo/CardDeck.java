package pucrs.ep.poo.cartas.modelo;

import pucrs.ep.poo.cartas.gui.GameEvent;

import java.util.*;


// Esta classe tem de ser um container de cartas observavel ...
public class CardDeck extends Observable{
    public static final int NCARDS = 8;
    private List<Card> cartas;
    private Card selected;
    
    public CardDeck(int jogador){
       cartas = new ArrayList<Card>(NCARDS);
       selected = null;
       Random r = new Random();

       //jogador 1 só recebe as cartas de 1 até 5
       if (jogador==1) {
           for (int i = 0; i < NCARDS; i++) {
               int n = r.nextInt(5) + 1;
               Card c = new Card("C" + n, "img" + n, n);
               c.flip();
               cartas.add(c);
           }
       }

       //jogador 2 só recebe as cartas de 6 até 10
        else if (jogador==2) {
            for (int i = 0; i < NCARDS; i++) {
                int n = r.nextInt(5) + 6;
                Card c = new Card("C" + n, "img" + n, n);
                c.flip();
                cartas.add(c);
            }
        }
    }
        
    public List<Card> getCards(){
        return(cartas);
    }

    public int getNumberOfCards(){
        return(cartas.size());
    }
    
    public void removeSel(){
        if (selected == null){
            return;
        }
        cartas.remove(selected);
        selected = null;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.DECK,GameEvent.Action.REMOVESEL,"");
        setChanged();
        notifyObservers(gameEvent);
    }    
        
    public void setSelectedCard(Card card){
        selected = card;
    }
    
    public Card getSelectedCard(){
        return(selected);
    }
}

