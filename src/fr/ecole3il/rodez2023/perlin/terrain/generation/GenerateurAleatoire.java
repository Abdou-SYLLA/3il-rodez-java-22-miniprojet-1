package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitAleatoire;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

import java.util.Random;

/**
 * Cette classe représente un générateur de carte aléatoire héritant de la classe GenerateurCarte.
 * Initialise des valeurs au hasard pour les trois caractéristiques de terrain.
 * Utilise la méthode Perlin pour générer un tableau de terrains en fonction d'une graine aléatoire.
 * @author proussille
 */
public class GenerateurAleatoire extends GenerateurCarte {
    private Random random;
    /**
     * Constructeur du générateur de carte aléatoire avec une graine spécifique.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
         this.random = new Random();
    }

    /**
     * Implémente la génération d'un terrain aléatoire à une position donnée.
     *
     * @param i       La position verticale dans la carte.
     * @param j       La position horizontale dans la carte.
     * @param largeur La largeur totale de la carte.
     * @param hauteur La hauteur totale de la carte.
     * @return Le terrain généré aléatoirement pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
       // BruitAleatoire bruitAleatoire = new BruitAleatoire(this.getGraine(), 1.0);

        // Utilisation du bruit aléatoire pour générer l'altitude, l'hydrométrie et la température
        /*
        double altitude = bruitAleatoire.bruit2D((double) i / largeur, (double) j / hauteur);
        double hydrometrie = bruitAleatoire.bruit2D((double) i / largeur, (double) j / hauteur);
        double temperature = bruitAleatoire.bruit2D((double) i / largeur, (double) j / hauteur);
    */
        double altitude = this.random.nextDouble(-1.0, 1.0);
        double hydrometrie = this.random.nextDouble(0.0, 1.0);
        double temperature =this.random.nextDouble(0.0, 1.0);
        try {

            return new Terrain(altitude, hydrometrie, temperature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
