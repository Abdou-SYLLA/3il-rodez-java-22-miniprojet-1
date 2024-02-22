package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

public enum TypeTerrain {
    OCEAN("ocean", "ocean.png"), PLAINE("plaine", "plain.png"), FORET_FEUILLUS("forêt de feuillus", "deciduous_forest.png"),
    MONTAGNE("montagne", "mountain.png"), DESERT("desert", "desert.png"), COLLINES("Collines", "hills.png"), MARAIS("marais", "marsh.png"),
    FORET_CONIFÈRES("foret conifiere", "coniferous_forest.png"), TOUNDRA("toundra", "toundra.png");

    private final String nomTerrain;
    private final String nomFich;

    TypeTerrain(String nomTerrain, String nomFich) {
        this.nomTerrain = nomTerrain;
        this.nomFich = nomFich;
    }

    public BufferedImage getImage() {
        return Utils.chargerTuile(nomFich);
    }

}
