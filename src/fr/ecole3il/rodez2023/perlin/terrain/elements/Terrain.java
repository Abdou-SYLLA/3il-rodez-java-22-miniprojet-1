package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double altitude;
    private double temperature;
    private double hydrometrie;

    public Terrain(double altitude, double temperature, double hydrometrie) {
        if(Math.abs(temperature) > 1 )
            throw new MauvaiseValeurException("la valeur temperature entrée n'est pas correcte");

        if(Math.abs(hydrometrie) > 1 )
            throw new MauvaiseValeurException("la valeur hydometrie entrée n'est pas correcte");

        if(altitude > 1 || altitude < -1)
            throw new MauvaiseValeurException("la valeur altitude entrée n'est pas correcte");

        this.altitude = altitude;
        this.temperature = Math.abs(temperature);
        this.hydrometrie = Math.abs(hydrometrie);
    }


    public double getAltitude() {
        return this.altitude;
    }

    TypeTerrain getTypeTerrain(DetermineurTerrain dt){
        return dt.determinerTerrain(altitude, hydrometrie, temperature);
    }
    public double getHydrometrie() {
        return this.hydrometrie;
    }

    public double getTemperature() {
        return this.temperature;
    }
}
