class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

class TicketCircularList {
    private Ticket head = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicket(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            return;
        }
        Ticket current = head;
        Ticket prev = null;
        do {
            if (current.ticketId == ticketId) {
                if (current == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("ID: " + temp.ticketId + ", Name: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomerOrMovie(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + temp.ticketId + ", Name: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No matching ticket found.");
    }

    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketCircularList system = new TicketCircularList();
        system.addTicket(101, "Alice", "Inception", "A1", "10:00AM");
        system.addTicket(102, "Bob", "Matrix", "B2", "11:30AM");
        system.addTicket(103, "Charlie", "Inception", "C3", "01:00PM");

        system.displayTickets();

        System.out.println("Search Results:");
        system.searchByCustomerOrMovie("Inception");

        System.out.println("Total Booked Tickets: " + system.countTickets());

        system.removeTicket(102);

        System.out.println("After Removal:");
        system.displayTickets();
    }
}
