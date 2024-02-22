package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;


public class VisualiseurTerrain {
        private Carte carte;
        private DetermineurTerrain determineurTerrain;

    /**
     * Constructeur de la classe `VisualiseurTerrain`.
     *
     * @param determineurTerrain Le détermineur de terrain utilisé pour déterminer le type de terrain.
     * @param carte              La carte à visualiser.
     */
    public VisualiseurTerrain(DetermineurTerrain determineurTerrain, Carte carte) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    // Méthodes pour obtenir des informations affichées sur l'altitude, l'hydrométrie et la température

    /**
     * Obtient l'altitude affichée à une position spécifique sur la carte.
     *
     * @param x Coordonnée x.
     * @param y Coordonnée y.
     * @return L'altitude affichée.
     */
    public String getAltitudeAffichee(int x, int y) {
        return altitudeAffichee(carte.getTerrain(x, y).getAltitude());
    }

    /**
     * Obtient l'hydrométrie affichée à une position spécifique sur la carte.
     *
     * @param x Coordonnée x.
     * @param y Coordonnée y.
     * @return L'hydrométrie affichée.
     */
    public String getHydrometrieAffichee(int x, int y) {
        return hydrometrieAffichee(carte.getTerrain(x, y).getHydrometrie());
    }

    /**
     * Obtient la température affichée à une position spécifique sur la carte.
     *
     * @param x Coordonnée x.
     * @param y Coordonnée y.
     * @return La température affichée.
     */
    public String getTemperatureAffichee(int x, int y) {
        return temperatureAffichee(carte.getTerrain(x, y).getTemperature());
    }
    /**
     * Obtient une représentation textuelle de l'altitude en fonction de sa valeur.
     *
     * @param valeur La valeur de l'altitude.
     * @return Représentation textuelle de l'altitude.
     */
    public String altitudeAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Basse";
        } else if (valeur < 0.66) {
            return "Moyenne";
        } else {
            return "Élevée";
        }
    }

    /**
     * Obtient une représentation textuelle de l'hydrométrie en fonction de sa valeur.
     *
     * @param valeur La valeur de l'hydrométrie.
     * @return Représentation textuelle de l'hydrométrie.
     */
    public String hydrometrieAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Sec";
        } else if (valeur < 0.66) {
            return "Moyen";
        } else {
            return "Humide";
        }
    }

    /**
     * Obtient une représentation textuelle de la température en fonction de sa valeur.
     *
     * @param valeur La valeur de la température.
     * @return Représentation textuelle de la température.
     */
    public String temperatureAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Froide";
        } else if (valeur < 0.66) {
            return "Tempérée";
        } else {
            return "Chaud";
        }
    }

    // Méthodes pour évaluer les caractéristiques du terrain

    /**
     * Vérifie si la valeur est basse.
     *
     * @param valeur La valeur à évaluer.
     * @return True si la valeur est basse, sinon False.
     */
    public boolean basse(double valeur) {
        return valeur < 0.3;
    }

    /**
     * Vérifie si la valeur est moyenne.
     *
     * @param valeur La valeur à évaluer.
     * @return True si la valeur est moyenne, sinon False.
     */
    public boolean moyenne(double valeur) {
        return valeur >= 0.3 && valeur < 0.7;
    }

    /**
     * Vérifie si la valeur est haute.
     *
     * @param valeur La valeur à évaluer.
     * @return True si la valeur est haute, sinon False.
     */
    public boolean haute(double valeur) {
        return valeur >= 0.7;
    }

    /**
     * Vérifie si la valeur est dans la plage des fonds marins.
     *
     * @param valeur La valeur à évaluer.
     * @return True si la valeur est inférieure à zéro, sinon False.
     */
    public boolean fond_marrin(double valeur) {
        return valeur < 0;
    }
    public boolean estPlaine(double altitude, double hydrometrie, double temperature) {
        return basse(hydrometrie) && basse(altitude) && (basse(temperature) || moyenne(temperature) || haute(temperature));
    }

    public boolean estForetFeuillus(double altitude, double hydrometrie, double temperature) {
        return basse(hydrometrie) && (basse(altitude) || moyenne(altitude)) && (moyenne(temperature) || haute(temperature));
    }

    public boolean estToundra(double altitude, double hydrometrie, double temperature) {
        return basse(hydrometrie) && basse(altitude) && haute(temperature);
    }

    public boolean estForetConiferes(double altitude, double hydrometrie, double temperature) {
        return basse(hydrometrie) || haute(hydrometrie) && basse(altitude) && moyenne(temperature);
    }

    public boolean estMontagne(double altitude, double hydrometrie, double temperature) {
        return (basse(hydrometrie) || moyenne(hydrometrie) || haute(hydrometrie)) && haute(altitude)
                && (basse(temperature) || moyenne(temperature) || haute(temperature));
    }

    public boolean estDesert(double altitude, double hydrometrie, double temperature) {
        return basse(hydrometrie) && haute(altitude) && basse(temperature);
    }

    public boolean estCollines(double altitude, double hydrometrie, double temperature) {
        return (basse(hydrometrie) || moyenne(hydrometrie) || haute(hydrometrie))
                && (moyenne(altitude) || haute(altitude))
                && (basse(temperature) || moyenne(temperature) || haute(temperature));
    }

    public boolean estMarais(double altitude, double hydrometrie, double temperature) {
        return (moyenne(hydrometrie) || haute(hydrometrie)) && basse(altitude)
                && (basse(temperature) || moyenne(temperature));
    }

    /**
     * Obtient le type de terrain à une position spécifique sur la carte en utilisant les méthodes d'évaluation du terrain.
     *
     * @param x Coordonnée x.
     * @param y Coordonnée y.
     * @return Le type de terrain à la position spécifiée.
     */
    public TypeTerrain getTypeTerrain(int x, int y) {
        double altitude = this.carte.getTerrain(x, y).getAltitude();
        double hydrometrie = this.carte.getTerrain(x, y).getHydrometrie();
        double temperature = this.carte.getTerrain(x, y).getTemperature();

        if (estPlaine(altitude, hydrometrie, temperature)) {
            return TypeTerrain.PLAINE;
        } else if (estForetFeuillus(altitude, hydrometrie, temperature)) {
            return TypeTerrain.FORET_FEUILLUS;
        } else if (estToundra(altitude, hydrometrie, temperature)) {
            return TypeTerrain.TOUNDRA;
        } else if (estForetConiferes(altitude, hydrometrie, temperature)) {
            return TypeTerrain.FORET_CONIFÈRES;
        } else if (estMontagne(altitude, hydrometrie, temperature)) {
            return TypeTerrain.MONTAGNE;
        } else if (estDesert(altitude, hydrometrie, temperature)) {
            return TypeTerrain.DESERT;
        } else if (estCollines(altitude, hydrometrie, temperature)) {
            return TypeTerrain.COLLINES;
        } else if (estMarais(altitude, hydrometrie, temperature)) {
            return TypeTerrain.MARAIS;
        } else {
            return TypeTerrain.OCEAN;
        }

    }


}



