package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

/**
 * La classe VisualiseurTerrainEnonce étend la classe VisualiseurTerrain et représente un visualiseur spécifique
 * utilisé pour afficher une carte avec un détermineur de terrain enonce.
 */
public class VisualiseurTerrainEnonce extends VisualiseurTerrain {

	/**
	 * Constructeur de la classe VisualiseurTerrainEnonce.
	 *
	 * @param carte Carte à visualiser
	 */
	public VisualiseurTerrainEnonce(Carte carte) {
		super(new DetermineurTerrainEnonce(), carte);
	}
}
