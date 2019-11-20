package pucrs.ep.poo.cartas.modelo;

public class SorceryCard extends Card {

    public enum Colour {RED, BLUE}

    private Colour colour;
    private int cost;


    public SorceryCard(String anId, String anImageId, Colour cor, int custo) {
        super(anId, anImageId);
        colour = cor;
        cost = custo;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
