package Article;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LibraryArticle {
    Scanner value = new Scanner(System.in);

    public static ArrayList<Article> listArticles = new ArrayList<Article>();

    public ArrayList<Article> getListArticles() {
        return (ArrayList<Article>) listArticles;
    }

    public void setListArticles(ArrayList<Article> listArticles) {
        LibraryArticle.listArticles = listArticles;
    }

    public static void addArticle(Article article)
    {
        listArticles.add(article);
    }

    public void afficherArticle()
    {
        for(Article i : listArticles)
        {
            System.out.println("=============================");
            System.out.println("L'id est : "+i.getId());
            System.out.println("Le nom est : "+i.getName());
            System.out.println("Le prix est : "+i.getPrice());
        }
    }

    public void findArticleByRef()
    {
        Scanner value = new Scanner(System.in);
        System.out.println("Saisir un ID : ");
        int ref = Integer.parseInt(value.nextLine());
        for(Article i : listArticles)
        {
            if(ref == i.getId())
            {
                System.out.println("--------------");
                System.out.println(i.getId());
                System.out.println(i.getName());
                System.out.println(i.getPrice());
                System.out.println("--------------");
            }
        }
    }

    public void findArticleByName()
    {
        Scanner value = new Scanner(System.in);
        System.out.println("Saisir un nom : ");
        String ref = value.nextLine();
        for(Article i : listArticles)
        {
            if(Objects.equals(ref, i.getName()))
            {
                System.out.println("--------------");
                System.out.println(i.getId());
                System.out.println(i.getName());
                System.out.println(i.getPrice());
                System.out.println("--------------");
            }
        }
    }

    public static void deleteArticle(int article)
    {
        listArticles.remove(article);
    }

    public static void updateArticle(int index, Article article)
    {
        listArticles.set(index, article);
    }

    public void articleParIntervalle()
    {
        Scanner value = new Scanner(System.in);

        System.out.println("Saisir un prix minimum: ");
        float minimum = Float.parseFloat(value.nextLine());

        System.out.println("Saisir un prix maximum: ");
        float maximum = Float.parseFloat(value.nextLine());

        for(Article i : listArticles)
        {
            if(i.getPrice() > minimum && i.getPrice() < maximum)
            {
                System.out.println(i.getId());
                System.out.println(i.getName());
                System.out.println(i.getPrice());
            }
        }
    }

    public boolean uniqueId(int id)
    {
        for(Article i : listArticles)
        {
            if(id == i.getId())
            {
                return false;
            }
        }
        return true;
    }

}
