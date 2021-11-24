package l6exerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandTimes= Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < commandTimes; i++) {
            String[] input = scanner.nextLine().split(",\\s+");
            Article article = new Article(input[0],input[1],input[2] );
            article.setTitle(input[0]);
            article.setContent(input[1]);
            article.setAuthor(input[2]);
            articles.add(article);
        }
        String sortBy = scanner.nextLine();
        if (sortBy.equals("title")){
            articles.sort(Comparator.comparing(Article::getTitle));
        }
        else if (sortBy.equals("content")){
            articles.sort(Comparator.comparing(Article::getContent));
        }
        else if (sortBy.equals("author")){
            articles.sort(Comparator.comparing(Article::getAuthor));
        }



        for (Article art :articles){
            System.out.println(art.totString());
        }


    }

}
