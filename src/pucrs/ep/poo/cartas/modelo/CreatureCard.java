package pucrs.ep.poo.cartas.modelo;

public class CreatureCard extends Card {

    public enum Colour {RED, BLUE}

    private int attack;
    private int defense;
    private int cost;
    private Colour colour;

    public CreatureCard(String anId, String anImageId, int val, int ataque, int defesa, int custo, Colour cor) {
        super(anId, anImageId, val);
        attack = ataque;
        defense = defesa;
        cost = custo;
        colour = cor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour cor) {
        this.colour = cor;
    }

    @Override
    public String toString() {
        return super.toString() + " Ataque: " + attack + " Defesa: " + defense +" Custo: " + cost;
    }
}
