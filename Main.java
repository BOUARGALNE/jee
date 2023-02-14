import metier.IMetierProduit;
import metier.MetierProduitImpl;
import metier.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produit> produits=new ArrayList<>();
        System.out.println("--------------------------------------------");
        Produit pr1= new Produit("sjjs","samsung","pour les travaux ",120,12);
        Produit pr2= new Produit("phone","apple","tres tres efficace ",160,6);
        Produit pr3= new Produit("machine","LG","pour les igna ",110,12);
        Produit pr4= new Produit("igna","samsung","pour les travaux ",150,2);
        IMetierProduit iMetierProduit= new MetierProduitImpl(produits);
        iMetierProduit.Produitadd(pr1);
        int menu=0;
        while (menu!=6){
            Scanner scanner = new Scanner( System.in );
            System.out.println("1--->afficher la liste des produits.\n" +
                    "2--->rechercher les produits par mot cle.\n" +
                    "3--->Ajouter un nouveau produit dans la liste.\n" +
                    "4--->Récupérer et afficher un produit par ID.\n" +
                    "5--->Supprimer un produit par id.\n" +
                    "6--->quitter le programme.\n" +
                    "\n");
            System.out.println("------ veuillez choisir une operation -------");
            menu = scanner.nextInt();
            int i;
            switch (menu){
                case 1:
                     i =1;
                    for (Produit p:iMetierProduit.getALL()) {
                        System.out.println("- le produit1 : "+i+"  | id: "+p.getId()+"  | nom: "+p.getNom()+"  | marque: "+ p.getMarque()+"  | description: "
                        +p.getDescreption()+"  | prix: "+p.getPrix()+"  | nombre en stock: "+p.getNombStock());
                        i++;
                    }
                     break;
                case 2:
                     i =1;
                    scanner.nextLine();
                    System.out.println("veuillez enter le nom de produit a rechercher");
                    String str = scanner.nextLine();
                    if(iMetierProduit.findByNom(str).size()==0){
                            System.out.println("aucun produit existe avec ce nom!!");
                        break;
                    }
                     else {
                        System.out.println("**** la liste des produit de nom '"+str+"' ****\n");
                         for (Produit p:iMetierProduit.findByNom(str)) {
                        System.out.println("- le produit1 : "+i+"  | id: "+p.getId()+"  | nom: "+p.getNom()+"  | marque: "+ p.getMarque()+"  | description: "
                                +p.getDescreption()+"  | prix: "+p.getPrix()+"  | nombre en stock: "+p.getNombStock());
                        i++;
                    }
                     }
                    break;

                case 3:
                    String str1;
                    int nmStock;
                    float prix;
                    System.out.println("enter le produit a ajouter:");
                    Produit pr=new Produit();
                    System.out.println("nom:");
                    str1=scanner.nextLine();
                    pr.setNom(str1);
                    scanner.nextLine();
                    System.out.println("marque:");
                    str1=scanner.nextLine();
                    pr.setMarque(str1);
                    System.out.println("description:");
                    str1=scanner.nextLine();
                    pr.setDescreption(str1);
                    System.out.println("prix:");
                    prix=scanner.nextFloat();
                    pr.setPrix(prix);
                    System.out.println("nombre en Stock:");
                    nmStock=scanner.nextInt();
                    pr.setNombStock(nmStock);
                    iMetierProduit.Produitadd(pr);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("veuillez enter le id de produit a rechercher");
                    int iD=scanner.nextInt();
                    if(iMetierProduit.findById(iD)==null){
                        System.out.println("aucun produit existe avec ce id!!");
                        break;
                    }
                    else {
                        System.out.println("**** la liste des produit de id '" + iD + "' ****\n");
                        Produit p = iMetierProduit.findById(iD);
                        System.out.println("- le produit :  id: " + p.getId() + "  | nom: " + p.getNom() + "  | marque: " + p.getMarque() + "  | description: "
                                + p.getDescreption() + "  | prix: " + p.getPrix() + "  | nombre en stock: " + p.getNombStock());
                    }
                        break;
                case 5:
                    scanner.nextLine();
                    System.out.println("veuillez enter le id de produit a supprimer");
                    int iDS=scanner.nextInt();
                    iMetierProduit.delete(iDS);
            }
        }

    }
}