package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;
import java.util.Scanner;

/**
 * La classe Carte représente une carte générée avec des informations sur le terrain.
 */
public class Carte {
    private int largeur;        // Largeur de la carte
    private int hauteur;        // Hauteur de la carte
    private String nom;         // Nom de la carte
    private Terrain[][] tabTerrain; // Tableau bidimensionnel représentant le terrain

    /**
     * Constructeur de la classe Carte utilisé pour générer une nouvelle carte.
     *
     * @param nom Nom de la carte
     * @param largeur Largeur de la carte
     * @param hauteur Hauteur de la carte
     * @param generateurCarte Objet GenerateurCarte utilisé pour générer le terrain de la carte
     */
    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.tabTerrain = generateurCarte.genererCarte(largeur, hauteur);
    }

    /**
     * Constructeur de la classe Carte utilisé pour créer une carte à partir de données fournies.
     *
     * @param donneesCarte Chaîne de données représentant la carte
     */
    public Carte(String donneesCarte) {
        Scanner scanner = new Scanner(donneesCarte);

        // Lecture des métadonnées de la carte
        this.nom = scanner.nextLine();
        this.largeur = scanner.nextInt();
        this.hauteur = scanner.nextInt();

        this.tabTerrain = new Terrain[largeur][hauteur];

        // Lecture des données de terrain
        for (int y = 0; y < largeur; y++) {
            for (int x = 0; x < hauteur; x++) {
                double altitude = scanner.nextDouble();
                double hydrometrie = scanner.nextDouble();
                double temperature = scanner.nextDouble();

                tabTerrain[x][y] = new Terrain(altitude, hydrometrie, temperature);
            }
        }
        scanner.close();
    }

    /**
     * Retourne la largeur de la carte.
     *
     * @return La largeur de la carte
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Retourne la hauteur de la carte.
     *
     * @return La hauteur de la carte
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Retourne le nom de la carte.
     *
     * @return Le nom de la carte
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le terrain à la position spécifiée sur la carte.
     *
     * @param x Coordonnée x
     * @param y Coordonnée y
     * @return Terrain à la position spécifiée
     * @throws TerrainInexistant Si la position spécifiée est invalide
     */
    public Terrain getTerrain(int x, int y) throws TerrainInexistant {
        if (x < 0 || x >= tabTerrain.length || y < 0 || y >= tabTerrain[0].length) {
            throw new TerrainInexistant("La position [" + x + "][" + y + "] est invalide.");
        }
        return tabTerrain[x][y];
    }
}
