package l6exerciseObjectsAndClasses;

public class Article {
    String title;
    String content;
    String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public String totString() {
        String result = String.format("%s - %s: %s", this.title, this.content, this.author);
        return result;
    }
}
