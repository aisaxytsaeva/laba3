
public class Book {
    private String name;
    private String author;
    private int copies;

    public Book(String _name, String _author, int _copies){
        this.name = _name;
        this.author = _author;
        this.copies = _copies;
    }
    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getCopies(){
        return copies;
    }

}