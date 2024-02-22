package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;


public class VisualiseurTerrain {
        private Carte carte;
        private DetermineurTerrain determineurTerrain;

        public VisualiseurTerrain( DetermineurTerrain determineurTerrain,Carte carte) {
            this.carte = carte;
            this.determineurTerrain = determineurTerrain;
        }


    public String getAltitudeAffichee(int x, int y) {
        return altitudeAffichee(carte.getTerrain(x,y).getAltitude()) ;
    }

    public String getHydrometrieAffichee(int x, int y) {
        return hydrometrieAffichee(carte.getTerrain(x,y).getHydrometrie());
    }

    public String getTemperatureAffichee(int x, int y) {
        return temperatureAffichee(carte.getTerrain(x,y).getTemperature());
    }

    public String altitudeAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Basse";
        } else if (valeur < 0.66) {
            return "Moyenne";
        } else {
            return "Elevee";
        }
    }

    public String hydrometrieAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Sec";
        } else if (valeur < 0.66) {
            return "Moyen";
        } else {
            return "Humide";
        }
    }

    public String temperatureAffichee(double valeur) {
        if (valeur < 0.33) {
            return "Froid";
        } else if (valeur < 0.66) {
            return "Tempere";
        } else {
            return "Chaud";
        }
    }

    public boolean basse(double valeur) {
        return valeur < 0.3;
    }

    public boolean moyenne(double valeur) {
        return valeur >= 0.3 && valeur < 0.7;
    }

    public boolean haute(double valeur) {
        return valeur >= 0.7;
    }

    public boolean fond_marrin(double valeur){
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



