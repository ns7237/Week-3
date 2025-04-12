class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private Movie head;
    private Movie tail;

    public MovieLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        Movie temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        }
        temp.next = newMovie;
        if (newMovie.next == null) {
            tail = newMovie;
        }
    }

    public void removeMovieByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie with title " + title + " not found.");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
    }

    public Movie searchMovieByDirectorOrRating(String director, double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateRatingByTitle(String title, double newRating) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp != null) {
            temp.rating = newRating;
        } else {
            System.out.println("Movie with title " + title + " not found.");
        }
    }

    public void displayAllMoviesForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayAllMoviesReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();
        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 1);

        System.out.println("Movies displayed in forward order:");
        movieList.displayAllMoviesForward();

        Movie movie = movieList.searchMovieByDirectorOrRating("Christopher Nolan", 8.6);
        if (movie != null) {
            System.out.println("\nMovie found: " + movie.title + ", " + movie.director + ", " + movie.yearOfRelease + ", " + movie.rating);
        } else {
            System.out.println("\nMovie not found.");
        }

        movieList.updateRatingByTitle("Interstellar", 9.2);

        System.out.println("\nMovies displayed in reverse order:");
        movieList.displayAllMoviesReverse();

        movieList.removeMovieByTitle("Inception");

        System.out.println("\nMovies after deletion:");
        movieList.displayAllMoviesForward();
    }
}
