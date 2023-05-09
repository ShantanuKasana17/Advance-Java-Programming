*************************************************question 10***************************************************************
Write a java program for Library details using Interface for the data members like book_name, book_title,
acctype, date and bal. Next to calculate the return date and fine amount if any, to display all the details.



import java.time.LocalDate;

// Define an interface for library book details
interface LibraryBook {
    String getBookName();
    String getBookTitle();
    String getAccountType();
    LocalDate getDate();
    double getBalance();
}

// Implement the LibraryBook interface for a specific book
class MyLibraryBook implements LibraryBook {
    private String bookName;
    private String bookTitle;
    private String accountType;
    private LocalDate date;
    private double balance;
    private LocalDate returnDate;
    private double fineAmount;

    // Constructor for MyLibraryBook
    public MyLibraryBook(String bookName, String bookTitle, String accountType, LocalDate date, double balance) {
        this.bookName = bookName;
        this.bookTitle = bookTitle;
        this.accountType = accountType;
        this.date = date;
        this.balance = balance;
    }

    // Getters and setters for return date and fine amount
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public double getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    // Implement the LibraryBook interface methods
    @Override
    public String getBookName() {
        return bookName;
    }
    @Override
    public String getBookTitle() {
        return bookTitle;
    }
    @Override
    public String getAccountType() {
        return accountType;
    }
    @Override
    public LocalDate getDate() {
        return date;
    }
    @Override
    public double getBalance() {
        return balance;
    }
}

// Main class for running the program
public class LibraryDetails {
    public static void main(String[] args) {
        // Create a library book and set its return date and fine amount
        LibraryBook myBook = new MyLibraryBook("The Catcher in the Rye", "Novel", "Student", LocalDate.of(2023, 4, 1), 0.0);
        LocalDate today = LocalDate.now();
        LocalDate returnDate = myBook.getDate().plusDays(14);
        myBook.setReturnDate(returnDate);
        if (today.isAfter(returnDate)) {
            double daysLate = today.toEpochDay() - returnDate.toEpochDay();
            double fineAmount = daysLate * 0.50;
            myBook.setFineAmount(fineAmount);
        }

        // Print the book's details, including return date and fine amount
        System.out.println("Book Name: " + myBook.getBookName());
        System.out.println("Book Title: " + myBook.getBookTitle());
        System.out.println("Account Type: " + myBook.getAccountType());
        System.out.println("Due Date: " + myBook.getDate());
        System.out.println("Return Date: " + myBook.getReturnDate());
        System.out.println("Balance: $" + myBook.getBalance());
        if (myBook.getFineAmount() > 0) {
            System.out.println("Fine Amount: $" + myBook.getFineAmount());
        } else {
            System.out.println("No fine due.");
        }
    }
}

