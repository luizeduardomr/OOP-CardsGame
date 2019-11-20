package pucrs.ep.poo.cartas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedCreatures {

    private List<CreatureCard> smallCreatures;
    private List<CreatureCard> bigCreatures;

    public RedCreatures() {
        this.smallCreatures = new ArrayList<>();
        this.bigCreatures = new ArrayList<>();
        addBigRedCreatures();
        addSmallRedCreatures();
    }

    private void addSmallRedCreatures() {

        CreatureCard aprendiz = new CreatureCard("aprendiz", "aprendizimg", 1, 1, 1, CreatureCard.Colour.RED);
        smallCreatures.add(aprendiz);

        CreatureCard mek = new CreatureCard("mek", "mekimg", 1, 1, 1, CreatureCard.Colour.RED);
        smallCreatures.add(mek);

        CreatureCard amor = new CreatureCard("amor", "amorimg", 3, 3, 2, CreatureCard.Colour.RED);
        smallCreatures.add(amor);

        CreatureCard forca = new CreatureCard("forca", "forcaimg", 2, 2, 2, CreatureCard.Colour.RED);
        smallCreatures.add(forca);

        CreatureCard mago = new CreatureCard("mago", "magoimg", 3, 3, 3, CreatureCard.Colour.RED);
        smallCreatures.add(mago);

        CreatureCard mexicans = new CreatureCard("mexicans", "meximg", 4, 4, 3, CreatureCard.Colour.RED);
        smallCreatures.add(mexicans);

        CreatureCard ra = new CreatureCard("ra", "raimg", 1, 2, 1, CreatureCard.Colour.RED);
        smallCreatures.add(ra);

    }

    private void addBigRedCreatures() {

        CreatureCard IntelliJ = new CreatureCard("IntelliJ", "intellijimg", 5,5,4, CreatureCard.Colour.RED);
        bigCreatures.add(IntelliJ);

        CreatureCard Magnata = new CreatureCard("magnata", "magnataimg", 5, 6, 4, CreatureCard.Colour.RED);
        smallCreatures.add(Magnata);

    }

    public Card pickRandomSmallCreature() {
        Random r = new Random();
        Card randomPickedCreature;
        int tamanho = smallCreatures.size();
        int n = r.nextInt(tamanho);
        randomPickedCreature = smallCreatures.get(n);
        return randomPickedCreature;
    }

    public Card pickRandomBigCreature() {
        Random r = new Random();
        Card randomPickedCreature;
        int tamanho = bigCreatures.size();
        int n = r.nextInt(tamanho);
        randomPickedCreature = bigCreatures.get(n);
        return randomPickedCreature;
    }

}
