package Graou.pkgItems;

import Graou.pkgItems.Item;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
/**
 * Classe représentant une collection d'Item.
 *
 * @author Nathan SUK
 */
public class ItemList
{

    private HashMap<String, Item> aListeItem;
    
    /**
     * Constructeur
     */
    public ItemList()
    {
        this.aListeItem = new HashMap<String, Item>();
    } // ItemList()
    
    /**
     * @return La collection d'Item
     */
    public HashMap<String, Item> getItemList()
    {
        return this.aListeItem;
    } // getItemList()
    
    /**
     * Ajoute un item dans la collection
     * @param pItem L'item à ajouter
     */
    public void ajouter(final Item pItem)
    {
        this.aListeItem.put(pItem.getNom(), pItem);  
    } // ajouter()
    
    /**
     * Retire un item de l'inventaire
     * @param pItemName Nom de l'item à supprimer
     */
    public void retirer(final String pItemName)
    {
        this.aListeItem.remove(pItemName);
    } // retirer()
    
    /**
     * @return true si la collection contient l'item recherché, false sinon
     * @param pItemName le nom de l'item à rechercher
     */
    public boolean contient(final String pItemName)
    {
        return this.aListeItem.containsKey(pItemName);
    } // contient()
    
    /**
     * @return true si la collection est vide, false sinon.
     */
    public boolean estVide()
    {
        return this.aListeItem.size() == 0;
    } // estVide()
    
    /**
     * @return le poids cumulé des objets contenus dans la collection
     */
    public double getTotalWeight()
    {
        double vTotalWeight = 0;
        for(Item vItem : this.aListeItem.values())
        {
            vTotalWeight += vItem.getWeight();
        }
                
        return vTotalWeight;
    } // getTotalWeight()

    /**
     * @return une chaîne de caractère listant tous les items de la collection
     */
    public String getItemsString()
    {
        String vString = "\n";
        if(this.estVide())
        {
            vString += "Aucun objet";
        } else {
            Set<String> vItems = this.aListeItem.keySet();
            for(String vItem : vItems){
                vString += vItem+", \n";
            }   
        }
        
        return vString;
        
    } // getItemString()
    
    /**
     * @return un item en particulier de la collection
     */
    public Item getItem(final String pItemName)
    {
        return this.aListeItem.get(pItemName);
    } // getItem()
    
    
}
