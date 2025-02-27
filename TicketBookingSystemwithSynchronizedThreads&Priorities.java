import java.util.concurrent.locks.*;

class TicketBooking {
    private int seats = 10;
    private final Lock lock = new ReentrantLock();

    void book(String user, int priority) {
        Thread t = new Thread(() -> {
            lock.lock();
            try {
                if (seats > 0) {
                    System.out.println(user + " booked a seat. Seats left: " + --seats);
                } else {
                    System.out.println(user + " booking failed. No seats left.");
                }
            } finally {
                lock.unlock();
            }
        });
        t.setPriority(priority);
        t.start();
    }

    public static void main(String[] args) {
        TicketBooking tb = new TicketBooking();
        tb.book("VIP1", Thread.MAX_PRIORITY);
        tb.book("User1", Thread.NORM_PRIORITY);
        tb.book("VIP2", Thread.MAX_PRIORITY);
        tb.book("User2", Thread.MIN_PRIORITY);
        tb.book("User3", Thread.NORM_PRIORITY);
    }
}
