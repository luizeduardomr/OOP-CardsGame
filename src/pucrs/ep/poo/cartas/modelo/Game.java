package pucrs.ep.poo.cartas.modelo;

import pucrs.ep.poo.cartas.gui.GameEvent;

import java.util.*;

public class Game extends Observable {
    private static Game game = new Game();
    private int lifeJ1, lifeJ2;
    private CardDeck deckJ1, deckJ2;
    private Table tableJ1, tableJ2;
    private int manaReserveJ1, manaReserveJ2;
    private int player;
    private int jogadas;
    private boolean terrenoBaixado;

    public static Game getInstance() {
        return (game);
    }

    private Game() {
        lifeJ1 = 20;
        lifeJ2 = 20;
        manaReserveJ1 = 0;
        manaReserveJ2 = 0;
        deckJ1 = new CardDeck(1);
        deckJ2 = new CardDeck(2);
        tableJ1 = new Table(1);
        tableJ2 = new Table(2);
        player = 1;
        jogadas = CardDeck.NCARDS;
        terrenoBaixado = false;
    }

    public void nextPlayer() {
        player++;
        if (player == 4) {
            player = 1;
        }
        terrenoBaixado = false;
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

    public CardDeck getDeckJ1() {
        return (deckJ1);
    }

    public CardDeck getDeckJ2() {
        return (deckJ2);
    }

    public Table getTableJ1() {
        return tableJ1;
    }

    public Table getTableJ2() {
        return tableJ2;
    }

    public void play(CardDeck deckAcionado) {
        GameEvent gameEvent = null;

        if (player == 3) {
            player = 1;
        }
        if (deckAcionado == deckJ1) {
            if (player != 1) {
                gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "2");
                setChanged();
                notifyObservers((Object) gameEvent);
            } else {
                //Adiciona carta na mesa
                addCardToTable(deckJ1.getSelectedCard(), player);

                //Manda as mudanças
                setChanged();
                notifyObservers((Object) gameEvent);

            }
        } else if (deckAcionado == deckJ2) {
            if (player != 2) {
                gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, "1");
                setChanged();
                notifyObservers((Object) gameEvent);
            } else {
                //Adiciona carta na mesa
                addCardToTable(deckJ2.getSelectedCard(), player);

                //Manda as mudanças
                setChanged();
                notifyObservers((Object) gameEvent);
            }
        }
    }

    public void addCardToTable(Card carta, int jogador) {

        if (jogador == 1) {

            if (carta instanceof TerrainCard && !terrenoBaixado) {
                terrenoBaixado = true;
                manaReserveJ1++;
            } else {
                GameEvent gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVCARD, "");
                setChanged();
                notifyObservers((Object) gameEvent);
                return;
            }

            tableJ1.addToTable(carta);

            //Remove a carta selecionada
            this.removeSelected();

        }

        if (jogador == 2) {

            if (carta instanceof TerrainCard && !terrenoBaixado) {
                terrenoBaixado = true;
                manaReserveJ2++;
            } else {
                GameEvent gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVCARD, "");
                setChanged();
                notifyObservers((Object) gameEvent);
                return;
            }


            tableJ2.addToTable(carta);

            //Remove a carta selecionada
            this.removeSelected();

        }


    }

    // Acionada pelo botao de limpar    
    public void removeSelected() {
        GameEvent gameEvent = null;
        deckJ1.removeSel();
        deckJ2.removeSel();
    }
}
