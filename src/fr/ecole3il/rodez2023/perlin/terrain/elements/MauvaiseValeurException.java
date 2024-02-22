package fr.ecole3il.rodez2023.perlin.terrain.elements;

/**
 * La classe MauvaiseValeurException est une exception spécifique indiquant qu'une valeur incorrecte a été fournie
 * pour un élément du terrain.
 */
public class MauvaiseValeurException extends IllegalArgumentException {

    /**
     * Constructeur de la classe MauvaiseValeurException.
     *
     * @param s Message d'erreur décrivant la raison de l'exception
     */
    public MauvaiseValeurException(String s) {
        super(s);
    }
}
