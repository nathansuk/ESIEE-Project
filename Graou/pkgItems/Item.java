package Graou.pkgItems;

/**
 * Classe représentant un objet.
 *
 * @author Nathan SUK
 * @version (un numéro de version ou une date)
 */
public class Item
{
    private String aNom;
    private String aDescription;
    private double aWeight;

    /**
     * Constructeur d'objets de classe Item
     */
    public Item(final String pNom, final String pDescription, final double pWeight)
    {
        // initialisation des variables d'instance
        this.aNom = pNom;
        this.aDescription = pDescription;
        this.aWeight = pWeight;
    } // Item()
    
    /**
     * @return le nom de l'item
     */
    public String getNom()
    {
        return this.aNom;
    } // getNom()
    
    /**
     * Change le nom de l'item
     * @param pNom Le nouveau nom de l'item
     */
    public void setNom( final String pNom)
    {
        this.aNom = pNom;
    } // setNom()
    
    /**
     * @return la description de l'Item
     */
    public String getDescription()
    {
        return this.aDescription;
    } // getDescription()
    
    /**
     * Change la description de l'item
     * @param pDescription la nouvelle description
     */
    public void setDescription( final String pDescription )
    {
        this.aDescription = pDescription;
    } // setDescription()

    /**
     * @return le poids de l'objet
     */
    public double getWeight()
    {
        return this.aWeight;
    } // getWeight()
    
    /**
     * Change le poids de l'item
     * @param pPoids le nouveau poids
     */
    public void setPoids( final double pPoids )
    {
        this.aWeight = pPoids;
    } // setPoids()
}
