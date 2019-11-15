package pucrs.ep.poo.cartas.modelo;

import pucrs.ep.poo.cartas.gui.GameEvent;

import java.util.*;

public class Game extends Observable {
    private static Game game = new Game();
    private int lifeJ1, lifeJ2;
    private Hand handJ1, handJ2;
    private Deck grimorioJ1, grimorioJ2;
    private Table tableJ1, tableJ2;
    private int manaReserveJ1, manaReserveJ2;
    private int player;
    private int jogadas;
    private boolean terrenoBaixado;
    private boolean cartaComprada;
    private boolean manaResetado;

    public static Game getInstance() {
        return (game);
    }

    private Game() {
        lifeJ1 = 20;
        lifeJ2 = 20;
        manaReserveJ1 = 0;
        manaReserveJ2 = 0;
        grimorioJ1 = new Deck(1);
        grimorioJ2 = new Deck(2);
        handJ1 = new Hand(1, grimorioJ1);
        handJ2 = new Hand(2, grimorioJ2);
        tableJ1 = new Table(1);
        tableJ2 = new Table(2);
        player = 1;
        jogadas = Hand.NCARDS;
        terrenoBaixado = false;
        cartaComprada = false;
        manaResetado = false;

    }

    public void nextPlayer() {
        player++;
        if (player == 4) {
            player = 1;
        }
        terrenoBaixado = false;
        cartaComprada = false;
        manaResetado = false;
    }

    public int getManaReserveJ1() {
        return manaReserveJ1;
    }

    public void setManaReserveJ1(int manaReserveJ1) {
        this.manaReserveJ1 = manaReserveJ1;
    }

    public int getManaReserveJ2() {
        return manaReserveJ2;
    }

    public void setManaReserveJ2(int manaReserveJ2) {
        this.manaReserveJ2 = manaReserveJ2;
    }

    public int getLifeJ1() {
        return (lifeJ1);
    }

    public int getLifeJ2() {
        return (lifeJ2);
    }

    public Hand getHandJ1() {
        return (handJ1);
    }

    public Hand getHandJ2() {
        return (handJ2);
    }

    public Table getTableJ1() {
        return tableJ1;
    }

    public Table getTableJ2() {
        return tableJ2;
    }

    public void play(Hand deckAcionado) {
        GameEvent gameEvent = null;

        if (player == 3) {
            player = 1;
        }
        if (deckAcionado == handJ1) {
            if (player != 1) {
                gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
                setChanged();
                notifyObservers((Object) gameEvent);
            } else {
                //compra carta
                buyoneCard(grimorioJ1, player);
                setChanged();
                notifyObservers((Object) gameEvent);

                //resetMana
                if (manaResetado == false) {
                    setManaReserveJ1(tableJ1.getNumberOfMana());
                    manaResetado = true;
                }

                //Adiciona carta na mesa
                addCardToTable(handJ1.getSelectedCard(), player);
                setChanged();
                notifyObservers((Object) gameEvent);

            }
        } else if (deckAcionado == handJ2) {
            if (player != 2) {
                gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "1");
                setChanged();
                notifyObservers((Object) gameEvent);
            } else {
                //compra carta
                buyoneCard(grimorioJ2, player);
                setChanged();
                notifyObservers((Object) gameEvent);

                //resetMana
                if (manaResetado == false) {
                    setManaReserveJ2(tableJ2.getNumberOfMana());
                    manaResetado = true;
                }

                //Adiciona carta na mesa
                addCardToTable(handJ2.getSelectedCard(), player);
                setChanged();
                notifyObservers((Object) gameEvent);
            }
        }
    }

    public void buyoneCard(Deck grimorio, int jogador) {

        if (jogador == 1 && cartaComprada == false) {

            handJ1.buyOneCard(grimorio);
            cartaComprada = true;

        }

        if (jogador == 2 && cartaComprada == false) {

            handJ2.buyOneCard(grimorio);
            cartaComprada = true;

        }

    }

    public void addCardToTable(Card carta, int jogador) {

        if (jogador == 1) {

            if (carta instanceof TerrainCard && !terrenoBaixado) {
                terrenoBaixado = true;
                manaReserveJ1++;
            } else if (carta instanceof CreatureCard && manaReserveJ1 >= ((CreatureCard) carta).getCost()) {
                manaReserveJ1 = manaReserveJ1 - ((CreatureCard) carta).getCost();
            } else if (carta instanceof SorceryCard && manaReserveJ1 >= ((SorceryCard) carta).getCost()) {
                manaReserveJ1 = manaReserveJ1 - ((SorceryCard) carta).getCost();
            } else {
                GameEvent gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVCARD, "");
                setChanged();
                notifyObservers((Object) gameEvent);
                return;
            }

            tableJ1.addToTable(carta);

            //Remove a carta selecionada
            this.removeSelected(handJ1);

        }

        if (jogador == 2) {

            if (carta instanceof TerrainCard && !terrenoBaixado) {
                terrenoBaixado = true;
                manaReserveJ2++;
            } else if (carta instanceof CreatureCard && manaReserveJ2 >= ((CreatureCard) carta).getCost()) {
                manaReserveJ2 = manaReserveJ2 - ((CreatureCard) carta).getCost();
            } else if (carta instanceof SorceryCard && manaReserveJ2 >= ((SorceryCard) carta).getCost()) {
                manaReserveJ2 = manaReserveJ2 - ((SorceryCard) carta).getCost();
            } else {
                GameEvent gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVCARD, "");
                setChanged();
                notifyObservers((Object) gameEvent);
                return;
            }

            tableJ2.addToTable(carta);

            //Remove a carta selecionada
            this.removeSelected(handJ2);

        }

    }

    // Acionada pelo botao de limpar    
    public void removeSelected(Hand hand) {
        GameEvent gameEvent = null;
        hand.removeSel();
            }
}
