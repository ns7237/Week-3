class Book {
    String title, author, genre, status;
    int id;
    Book next, prev;
    public Book(String title, String author, String genre, int id, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.status = status;
    }
}

class Library {
    private Book head, tail;

    public void addBookAtEnd(String title, String author, String genre, int id, String status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    public void addBookAtBeginning(String title, String author, String genre, int id, String status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    public void addBookAtPosition(String title, String author, String genre, int id, String status, int position) {
        if (position <= 1) {
            addBookAtBeginning(title, author, genre, id, status);
            return;
        }
        Book newBook = new Book(title, author, genre, id, status);
        Book temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            addBookAtEnd(title, author, genre, id, status);
            return;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeBookById(int id) {
        Book temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.genre + " " + temp.status);
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.genre + " " + temp.status);
            }
            temp = temp.next;
        }
    }

    public void updateStatus(int id, String newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.status = newStatus;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.genre + " " + temp.status);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.title + " " + temp.author + " " + temp.genre + " " + temp.status);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        Book temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBookAtEnd("Book1", "Author1", "Fiction", 101, "Available");
        lib.addBookAtEnd("Book2", "Author2", "Horror", 102, "Issued");
        lib.addBookAtBeginning("Book3", "Author3", "Drama", 103, "Available");
        lib.addBookAtPosition("Book4", "Author1", "Sci-Fi", 104, "Available", 2);
        lib.displayForward();
        System.out.println("Reverse:");
        lib.displayReverse();
        System.out.println("Total: " + lib.countBooks());
        lib.updateStatus(102, "Available");
        lib.removeBookById(101);
        System.out.println("After updates:");
        lib.displayForward();
        System.out.println("Search by Author1:");
        lib.searchByAuthor("Author1");
    }
}
