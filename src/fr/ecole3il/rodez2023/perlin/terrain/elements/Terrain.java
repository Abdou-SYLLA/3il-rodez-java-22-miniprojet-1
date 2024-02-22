package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

/**
 * La classe Terrain représente un élément du terrain avec des propriétés telles que l'altitude, la température et
 * l'hydrométrie.
 */
public class Terrain {
    private double altitude;     // Altitude du terrain
    private double temperature;  // Température du terrain
    private double hydrometrie;  // Hydrométrie du terrain

    /**
     * Constructeur de la classe Terrain.
     *
     * @param altitude     Altitude du terrain
     * @param temperature  Température du terrain
     * @param hydrometrie  Hydrométrie du terrain
     * @throws MauvaiseValeurException Si les valeurs fournies ne sont pas correctes
     */
    public Terrain(double altitude, double temperature, double hydrometrie) {
        if (Math.abs(temperature) > 1)
            throw new MauvaiseValeurException("La valeur de la température entrée n'est pas correcte");

        if (Math.abs(hydrometrie) > 1)
            throw new MauvaiseValeurException("La valeur de l'hydrométrie entrée n'est pas correcte");

        if (altitude > 1 || altitude < -1)
            throw new MauvaiseValeurException("La valeur de l'altitude entrée n'est pas correcte");

        this.altitude = altitude;
        this.temperature = Math.abs(temperature);
        this.hydrometrie = Math.abs(hydrometrie);
    }

    /**
     * Retourne l'altitude du terrain.
     *
     * @return L'altitude du terrain
     */
    public double getAltitude() {
        return this.altitude;
    }

    /**
     * Retourne le type de terrain en utilisant le détermineur de terrain spécifié.
     *
     * @param dt DetermineurTerrain utilisé pour déterminer le type de terrain
     * @return Type de terrain
     */
    TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(altitude, hydrometrie, temperature);
    }

    /**
     * Retourne l'hydrométrie du terrain.
     *
     * @return L'hydrométrie du terrain
     */
    public double getHydrometrie() {
        return this.hydrometrie;
    }

    /**
     * Retourne la température du terrain.
     *
     * @return La température du terrain
     */
    public double getTemperature() {
        return this.temperature;
    }
}
