import java.util.HashMap;

public class Library {
    private final HashMap<String, Book> Books;

    public Library(){
        Books = new HashMap<>();
    }

    public void addBook(String isbn, Book book){
        if (!Books.containsKey(isbn)){
            Books.put(isbn, book);
        }
    }

    public Book getbook(String isbn){
        return Books.get(isbn);
    }

    public void removebook(String isbn){
        Books.remove(isbn);
    }

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Overcoat", "Nikolai Gogol", 201510);
        library.addBook("978-3-16-148410-0", book1);

        Book foundBook = library.getbook("978-3-16-148410-0");
        if (foundBook == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println(foundBook.getName());
            System.out.println(foundBook.getAuthor());
            System.out.println(foundBook.getCopies());
        }

        library.removebook("978-3-16-148410-0");
        foundBook = library.getbook("978-3-16-148410-0");
        
        if (foundBook == null) {
            System.out.println("Book successfully removed.");
        } else {
            System.out.println("Failed to remove the book.");
        }
    }
}
// Book book1 = new Book("The Overcoat", "Nikolai Gogol", 201510)