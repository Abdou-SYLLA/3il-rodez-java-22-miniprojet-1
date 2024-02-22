package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

/**
 * Cette classe représente un générateur de carte utilisant le bruit de Perlin héritant de la classe GenerateurCarte.
 * Elle utilise le bruit de Perlin pour générer des valeurs d'altitude, d'hydrométrie et de température de manière
 * cohérente et réaliste.
 * @author [Nom de l'auteur]
 */
public class GenerateurPerlin extends GenerateurCarte {

    private BruitPerlin2D bruitAltitude;
    private BruitPerlin2D bruitHydrometrie;
    private BruitPerlin2D bruitTemperature;

    /**
     * Constructeur du générateur de carte utilisant le bruit de Perlin avec une graine spécifique.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurPerlin(long graine) {
        super(graine);
        bruitAltitude = new BruitPerlin2D(graine * 4, 1.0);
        bruitHydrometrie = new BruitPerlin2D(graine, 1.0);
        bruitTemperature = new BruitPerlin2D(graine * 2, 1.0);
    }

    /**
     * Implémente la génération d'un terrain à une position donnée en utilisant le bruit de Perlin.
     *
     * @param i       La position verticale dans la carte.
     * @param j       La position horizontale dans la carte.
     * @param largeur La largeur totale de la carte.
     * @param hauteur La hauteur totale de la carte.
     * @return Le terrain généré avec le bruit de Perlin pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double x = (double) i / largeur;
        double y = (double) j / hauteur;

        double altitude = bruitAltitude.bruit2D(x, y);
        double hydrometrie = bruitHydrometrie.bruit2D(x, y);
        double temperature = bruitTemperature.bruit2D(x, y);

        return new Terrain(altitude, hydrometrie, temperature);
    }
}
