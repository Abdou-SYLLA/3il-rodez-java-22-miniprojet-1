package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

/**
 * L'énumération TypeTerrain représente les différents types de terrains possibles avec leur nom et le nom du fichier
 * image associé.
 */
public enum TypeTerrain {
    OCEAN("ocean", "ocean.png"),
    PLAINE("plaine", "plain.png"),
    FORET_FEUILLUS("forêt de feuillus", "deciduous_forest.png"),
    MONTAGNE("montagne", "mountain.png"),
    DESERT("desert", "desert.png"),
    COLLINES("Collines", "hills.png"),
    MARAIS("marais", "marsh.png"),
    FORET_CONIFÈRES("foret conifiere", "coniferous_forest.png"),
    TOUNDRA("toundra", "toundra.png");

    private final String nomTerrain;
    private final String nomFich;

    /**
     * Constructeur de l'énumération TypeTerrain.
     *
     * @param nomTerrain Nom du terrain
     * @param nomFich    Nom du fichier image associé
     */
    TypeTerrain(String nomTerrain, String nomFich) {
        this.nomTerrain = nomTerrain;
        this.nomFich = nomFich;
    }

    /**
     * Obtient l'image représentant le type de terrain.
     *
     * @return Image du type de terrain
     */
    public BufferedImage getImage() {
        return Utils.chargerTuile(nomFich);
    }
}
