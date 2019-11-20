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
    private boolean ataque;
    private String nomeGremistaJ1;
    private String nomeColoradoJ2;


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
        ataque = false;
        nomeGremistaJ1 = "Lucas";
        nomeColoradoJ2 = "Alexandre";

    }

    public String getNomeGremistaJ1(){
        return nomeGremistaJ1;
    }

    public String getNomeColoradoJ2(){
        return nomeColoradoJ2;
    }

    public String getJogadorAtivo(){
        if (player==1) return getNomeGremistaJ1();
        return getNomeColoradoJ2();
    }

    public void nextPlayer() {
        player++;
        if (player == 3) {
            player = 1;
        }
        terrenoBaixado = false;
        cartaComprada = false;
        setManaReserveJ1(tableJ1.getNumberOfMana());
        setManaReserveJ2(tableJ2.getNumberOfMana());
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

    public void play(Hand maoAcionada) {
        GameEvent gameEvent = null;

        if (player == 3) {
            player = 1;
        }
        if (maoAcionada == handJ1) {
            if (player != 1) {
                gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, getNomeColoradoJ2());
                setChanged();
                notifyObservers((Object) gameEvent);
            } else {


                //Adiciona carta na mesa
                addCardToTable(handJ1.getSelectedCard(), player);
                setChanged();
                notifyObservers((Object) gameEvent);

            }
        } else if (maoAcionada == handJ2) {
            if (player != 2) {
                gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.INVPLAY, getNomeGremistaJ1());
                setChanged();
                notifyObservers((Object) gameEvent);
            } else {

                //Adiciona carta na mesa
                addCardToTable(handJ2.getSelectedCard(), player);
                setChanged();
                notifyObservers((Object) gameEvent);
            }
        }
    }

    public void attack() {
        if (player == 1 && ataque == false) {
            ArrayList<CreatureCard> atacantes = tableJ1.getCreatures();
            ArrayList<CreatureCard> defensores = tableJ2.getCreatures();

            int numeroDeAtaques = atacantes.size();

            //Se há mais atacantes, calcula o dano
            if (atacantes.size() > defensores.size()) {
                numeroDeAtaques = defensores.size();
                int dano = 0;
                {
                    int diferenca = atacantes.size() - defensores.size();
                    for (int j = atacantes.size() - 1; j >= atacantes.size() - diferenca; j--) {
                        CreatureCard atacante = atacantes.get(j);
                        dano += atacante.getAttack();
                    }
                }

                lifeJ2 -= dano;

                //Verifica se o jogador perdeu toda vida
                if (lifeJ2 <= 0) {
                    GameEvent gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.WIN, getNomeGremistaJ1());
                    setChanged();
                    notifyObservers((Object) gameEvent);
                }
            }

            for (int i = 0; i < numeroDeAtaques; i++) {
                CreatureCard atacante = atacantes.get(i);
                CreatureCard defensor = defensores.get(i);

                int poderDeAtaqueAtacante = atacante.getAttack();
                int poderDeDefesaAtacante = atacante.getDefense();
                int poderAtaqueDefensor = defensor.getAttack();
                int poderDefesaDefensor = defensor.getDefense();

                //atacante é suficientemente forte para matar o defensor
                if (poderDeAtaqueAtacante >= poderDefesaDefensor) {

                    //checa se o atacante também vai morrer
                    if (poderAtaqueDefensor >= poderDeDefesaAtacante) {
                        removeCreature(tableJ1, atacante);
                        atacantes.remove(atacante);
                    }

                    //remove o defensor da mesa do adversário
                    removeCreature(tableJ2, defensor);
                    defensores.remove(defensor);
                }

                //atacante NÃO é suficientemente forte para matar o defensor
                if (poderDeAtaqueAtacante < poderDefesaDefensor) {

                    //checa se o atacante vai morrer
                    if (poderAtaqueDefensor >= poderDeDefesaAtacante) {
                        removeCreature(tableJ1, atacante);
                    }

                }
            }

        }

        if (player == 2 && ataque == false) {
            ArrayList<CreatureCard> atacantes = tableJ2.getCreatures();
            ArrayList<CreatureCard> defensores = tableJ1.getCreatures();

            int numeroDeAtaques = atacantes.size();

            //Se há mais atacantes, calcula o dano
            if (atacantes.size() > defensores.size()) {
                numeroDeAtaques = defensores.size();
                int dano = 0;
                {
                    int diferenca = atacantes.size() - defensores.size();
                    for (int j = atacantes.size() - 1; j >= atacantes.size() - diferenca; j--) {
                        CreatureCard atacante = atacantes.get(j);
                        dano += atacante.getAttack();
                    }
                }

                lifeJ1 -= dano;

                //Verifica se o jogador perdeu toda vida
                if (lifeJ1 <= 0) {
                    GameEvent gameEvent = new GameEvent(GameEvent.Target.GWIN, GameEvent.Action.WIN, getNomeColoradoJ2());
                    setChanged();
                    notifyObservers((Object) gameEvent);
                }
            }

            for (int i = 0; i < numeroDeAtaques; i++) {
                CreatureCard atacante = atacantes.get(i);
                CreatureCard defensor = defensores.get(i);

                int poderDeAtaqueAtacante = atacante.getAttack();
                int poderDeDefesaAtacante = atacante.getDefense();
                int poderAtaqueDefensor = defensor.getAttack();
                int poderDefesaDefensor = defensor.getDefense();

                //atacante é suficientemente forte para matar o defensor
                if (poderDeAtaqueAtacante >= poderDefesaDefensor) {

                    //checa se o atacante também vai morrer
                    if (poderAtaqueDefensor >= poderDeDefesaAtacante) {
                        removeCreature(tableJ2, atacante);
                    }

                    //remove o defensor da mesa do adversário
                    removeCreature(tableJ1, defensor);
                }

                //atacante NÃO é suficientemente forte para matar o defensor
                if (poderDeAtaqueAtacante < poderDefesaDefensor) {

                    //checa se o atacante vai morrer
                    if (poderAtaqueDefensor >= poderDeDefesaAtacante) {
                        removeCreature(tableJ2, atacante);
                    }

                }
            }


        } else return;

    }

    public void buyoneCard() {
        if (player == 1 && cartaComprada == false) {
            handJ1.buyOneCard(grimorioJ1);
            cartaComprada = true;
        }

        if (player == 2 && cartaComprada == false) {
            handJ2.buyOneCard(grimorioJ2);
            cartaComprada = true;
        } else return;
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

    public void removeCreature(Table table, CreatureCard criatura) {
        table.removeCreature(criatura);
    }

    // Acionada pelo botao de limpar    
    public void removeSelected(Hand hand) {
        GameEvent gameEvent = null;
        hand.removeSel();
    }
}
