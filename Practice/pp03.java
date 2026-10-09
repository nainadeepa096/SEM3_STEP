import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getBorrowDurationDays();

    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowDurationDays());
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowDurationDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getBorrowDurationDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowDurationDays() {
        return 3;
    }
}

public class pp03{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        LocalDate baseDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            // Split into ItemType and Title (handles quoted title strings)
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String rawTitle = line.substring(firstSpace + 1).trim();

            // Strip enclosing quotes if present
            if (rawTitle.startsWith("\"") && rawTitle.endsWith("\"")) {
                rawTitle = rawTitle.substring(1, rawTitle.length() - 1);
            }

            LibraryItem item = null;
            switch (type) {
                case "BOOK":
                    item = new Book(rawTitle);
                    break;
                case "DVD":
                    item = new DVD(rawTitle);
                    break;
                case "MAGAZINE":
                    item = new Magazine(rawTitle);
                    break;
            }

            if (item != null) {
                LocalDate dueDate = item.calculateDueDate(baseDate);
                System.out.printf("%s: %s\n", item.getTitle(), dueDate.format(formatter));
            }
        }

        sc.close();
    }
}