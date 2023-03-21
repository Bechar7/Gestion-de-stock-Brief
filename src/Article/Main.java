package Article;

import java.util.Arrays;
import java.util.Scanner;

import static Article.LibraryArticle.listArticles;

public class Main {
    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        LibraryArticle library = new LibraryArticle();

        int retour = -1;

        System.out.println("Ajoutez 1 ou plusieurs articles");
        System.out.println("----------------------------");
        saisirArticle();

        while (retour != 0)
        {
            System.out.println("1) Trouver un article spécifique via sa Référence");
            System.out.println("2) Trouver un article via son nom");
            System.out.println("3) Supprimer un article via sa Référence");
            System.out.println("4) Modifier un article");
            System.out.println("5) Rechercher un article via une intervalle de prix");
            System.out.println("6) Afficher tous les articles");
            System.out.println("0) Quitter");
            retour = Integer.parseInt(value.nextLine());

            switch (retour)
            {
                case 1:
                    library.findArticleByRef();
                    break;
                case 2:
                    library.findArticleByName();
                    break;
                case 3:
                    deleteArticle();
                    break;
                case 4:
                    updateArticle();
                    break;
                case 5:
                    library.articleParIntervalle();
                    break;
                case 6:
                    library.afficherArticle();
                    break;
                default:
                    break;


            }
        }
    }

    public static void saisirArticle()
    {
        char reponse = ' ';
        do{
            Scanner value = new Scanner(System.in);
            Article article = new Article();
            LibraryArticle library = new LibraryArticle();

            System.out.println("Saisisez l'id : ");
            article.setId(Integer.parseInt(value.nextLine()));

            System.out.println("Saisisez le nom : ");
            article.setName(value.nextLine());

            System.out.println("Saisisez le prix : ");
            article.setPrice(Float.parseFloat(value.nextLine()));

            if(library.uniqueId(article.getId()))
            {
                LibraryArticle.addArticle(article);
            }
            else {
                System.out.println("L'id existe déjà");
            }
                do{
                    System.out.println("Voulez-vous introduire un autre article ? O/N ");
                    reponse = value.nextLine().charAt(0);
                }while(reponse != 'N' && reponse !='O');

        }while(reponse == 'O');
    }

    public static void deleteArticle()
    {
        Scanner value = new Scanner(System.in);
        System.out.println("Saisir un ID : ");
        int ref = Integer.parseInt(value.nextLine());
        for(Article i : listArticles)
        {
            if(ref == i.getId())
            {
                LibraryArticle.deleteArticle(i.getId());
            }
        }
    }

    public static void updateArticle()
    {
        Scanner value = new Scanner(System.in);
        System.out.println("Saisir un ID : ");
        int ref = Integer.parseInt(value.nextLine());
        for(Article i : listArticles)
        {
            if(ref == i.getId())
            {
                Article article = new Article();

                System.out.println("Saisisez le nom : ");
                article.setName(value.nextLine());

                System.out.println("Saisisez le prix : ");
                article.setPrice(Float.parseFloat(value.nextLine()));

                LibraryArticle.updateArticle(i.getId(), article);
            }
        }
    }
}