package fr.ecole3il.rodez2023.perlin.terrain.carte;

/**
 * La classe TerrainInexistant est une exception spécifique indiquant qu'une tentative d'accès à une position
 * inexistante sur la carte a été effectuée.
 */
public class TerrainInexistant extends IndexOutOfBoundsException {

    /**
     * Constructeur de la classe TerrainInexistant.
     *
     * @param s Message d'erreur décrivant la raison de l'exception
     */
    public TerrainInexistant(String s) {
        super(s);
    }
}
