package pucrs.ep.poo.cartas.modelo;

public class TerrainCard extends Card {

    public enum Colour {RED, BLUE}

    private Colour colour;

    public TerrainCard(String anId, String anImageId, Colour cor) {
        super(anId, anImageId);
        colour = cor;
    }

    public Colour getColour() {
        return colour;
    }
}
