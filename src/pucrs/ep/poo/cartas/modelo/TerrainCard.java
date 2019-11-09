package pucrs.ep.poo.cartas.modelo;

public class TerrainCard extends Card {

    public enum Colour {RED, BLUE}

    private Colour colour;

    public TerrainCard(String anId, String anImageId, int val, Colour cor) {
        super(anId, anImageId, val);
        colour = cor;
    }

    public Colour getColour() {
        return colour;
    }
}
