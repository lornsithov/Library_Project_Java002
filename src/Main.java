import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

class Author{
    private String authorName;
    private String authorYear;

    public Author() {

    }

    //getter setter author
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorYear(String authorYear){
        this.authorYear = authorYear;
    }
    public String getAuthorYear() {
        return authorYear;
    }
}
class Book {
    private String bookTitle;
    boolean bookStatus;
    private int bookId, bookPublishYear, bookActiveYear;
    Author author = new Author();

    //book title
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    //book status
    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    //book id
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookID() {
        return bookId;
    }

    //book publish date
    public void setBookPublishDate(int bookPublishYear) {
        this.bookPublishYear = bookPublishYear;
    }

    public int getBookPublishDate() {
        return bookPublishYear;
    }

    //book active year
    public void setBookActiveYear(int bookActiveYear) {
        this.bookActiveYear = bookActiveYear;
    }

    public int getBookActiveYear() {
        return bookActiveYear;
    }

    //getter setter from author
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
public class Main{
    static Book[] book = new Book[200];
    static Author[] author = new Author[200];
    static int i = 4;
    public static String libraryName, libraryAddress;

    public static void main(String[] args) {
        //default values
        book[0] = new Book();
        book[0].setBookId(1);
        book[0].setBookTitle("The Amazing Spider-Man");
        book[0].author.setAuthorName("Stan Lee");
        book[0].author.setAuthorYear("1950-2018");
        book[0].setBookPublishDate(2021);
        book[0].setBookStatus(true);

        book[1] = new Book();
        book[1].setBookId(2);
        book[1].setBookTitle("Moon Knight");
        book[1].author.setAuthorName("Sithov Lorn");
        book[1].author.setAuthorYear("2014-Present");
        book[1].setBookPublishDate(2022);
        book[1].setBookStatus(true);

        book[2] = new Book();
        book[2].setBookId(3);
        book[2].setBookTitle("Skull (If I Die)");
        book[2].author.setAuthorName("Vannda Mon");
        book[2].author.setAuthorYear("2016-Present");
        book[2].setBookPublishDate(2021);
        book[2].setBookStatus(true);

        //1st and 2nd Functions (2nd contains all the cases)
        setUpLibrary();
        displayLibrary();
    }

    // da very 1st one, set up lib
    public static void setUpLibrary(){
        Scanner scanner = new Scanner(System.in);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        System.out.println("========= SET UP LIBRARY =========");
        libraryName = invalidateTexts("=> Enter Library's Name : ");
        libraryAddress = invalidateTexts("=> Enter Library's Address : ");
        System.out.println("\""+libraryName +"\", The library is already created in \""+libraryAddress+"\" successfully on "+ formattedDate);
    }

    // da 2nd one, display cases(1-6)
    public static void displayLibrary() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        String a;
        do {
            System.out.println("========= " + libraryName + " ," + libraryAddress + " =========");
            System.out.print("""
                    1- Add Book
                    2- Show All Books
                    3- Show Available Books
                    4- Borrow Book
                    5- Return Book
                    6- Remove Book
                    7- Exit
                    -----------------------------------------
                    \s""");
            choose = invalidateNum("=> Choose option(1-7) :",1,7);
            switch (choose) {
                case 1 -> addBook();
                case 2 -> showAllBooks();
                case 3 -> showAvailableBooks();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> removeBook();
                case 7 -> exitLibrary();
                default -> System.out.println("*****Invalidation Number*****");
            }
            System.out.println("(Press key e to exit, Press key Enter to continue)");
            String end = scanner.nextLine();
            //when press key e exit
            a = scanner.nextLine();
        } while (!(a.equalsIgnoreCase("e")));
    }

    //case 1
    public static void addBook(){
        Scanner scanner = new Scanner(System.in);

        //input books
        System.out.println("========= ADD BOOK INFO =========");
//        System.out.println("=> Book ID :  "+(i+1));
        String bookTitle = invalidateTexts("=> Enter Book's Title : ");
        String authorName = invalidateTexts("=> Enter Book Author Name : ");
        System.out.print("=> Enter Author Year Active : ");
        String authorYear = scanner.nextLine();
        int bookPublishedYear = invalidateNum("=> Enter Published Year : ",0,2023);
        System.out.println("Book successfully added.");


        //array objects (ADD BOOKS)
        book[i-1] = new Book();
        book[i-1].setBookId(i);
        book[i-1].setBookTitle(bookTitle);
        book[i-1].setBookPublishDate(bookPublishedYear);
        book[i-1].setBookStatus(true);
        Author author = new Author();
        author.setAuthorName(authorName);
        author.setAuthorYear(authorYear);
        book[i-1].setAuthor(author);
        i++;
    }

    //case 2
    public static void showAllBooks(){
        System.out.println("========= ALL BOOKS INFO =========");
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
        table.setColumnWidth(0,5,5);
        table.setColumnWidth(1,24,24);
        table.setColumnWidth(2,28,28);
        table.setColumnWidth(3,15,15);
        table.setColumnWidth(4,15,15);

        table.addCell("ID",numberStyle);
        table.addCell("TITLE",numberStyle);
        table.addCell("AUTHOR",numberStyle);
        table.addCell("PUBLISH DATE",numberStyle);
        table.addCell("STATUS",numberStyle);

        for (int j=0; j<i; j++){
            if(book[j]!=null) {
                table.addCell(String.valueOf(book[j].getBookID()), numberStyle);
                table.addCell(String.valueOf(book[j].getBookTitle()), numberStyle);
                table.addCell(String.valueOf(book[j].getAuthor().getAuthorName() + "   (" + book[j].getAuthor().getAuthorYear() + ")"), numberStyle);
                table.addCell(String.valueOf(book[j].getBookPublishDate()), numberStyle);
                table.addCell(String.valueOf(book[j].getBookStatus() ? "Available" : "Unavailable"), numberStyle);
            }
            else{
                break;
            }
        }
        System.out.println(table.render());
    }

    //case 3
    public static void showAvailableBooks(){
        System.out.println("========= AVAILABLE BOOKS INFO =========");
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
        table.setColumnWidth(0,5,5);
        table.setColumnWidth(1,24,24);
        table.setColumnWidth(2,28,28);
        table.setColumnWidth(3,15,15);
        table.setColumnWidth(4,15,15);

        table.addCell("ID",numberStyle);
        table.addCell("TITLE",numberStyle);
        table.addCell("AUTHOR",numberStyle);
        table.addCell("PUBLISH DATE",numberStyle);
        table.addCell("STATUS",numberStyle);

        for (int j=0; j<i; j++){
            if(book[j]!=null) {
                if(book[j].getBookStatus()){
                    table.addCell(String.valueOf(book[j].getBookID()), numberStyle);
                    table.addCell(String.valueOf(book[j].getBookTitle()), numberStyle);
                    table.addCell(String.valueOf(book[j].getAuthor().getAuthorName() + "   (" + book[j].getAuthor().getAuthorYear() + ")"), numberStyle);
                    table.addCell(String.valueOf(book[j].getBookPublishDate()), numberStyle);
                    table.addCell(String.valueOf(book[j].getBookStatus() ? "Available" : "Unavailable"), numberStyle);
                }
            }
            else{
                break;
            }
        }
        System.out.println(table.render());
    }
    //case 4
    public static void borrowBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("========= BORROW BOOK INFO =========");
        int bookId = invalidateNum("Enter book ID: ",1,200);
        boolean found = true;
        for (int j = 0; j < book.length; j++) {
            if(book[j] != null) {
                if (book[j].getBookID() == bookId  ) {
                    if(book[j].getBookStatus() == true ){
                        System.out.println("Details of borrowed book: ");
                        System.out.println("ID: " + book[j].getBookID());
                        System.out.println("Title: " + book[j].getBookTitle());
                        System.out.println("Author: " + book[j].getAuthor().getAuthorName() + " (" + book[j].getAuthor().getAuthorYear() + ")");
                        System.out.println("Published Year: " + book[j].getBookPublishDate());
                        System.out.println("Book borrowed successfully!");
                        System.out.println();
                        book[j].setBookStatus(false);
                        found=true;
                        break;
                    }//if available or not
                    else{
                        System.out.println("ID " + bookId + ", the book is already borrowed. (Unavailable)");
                        break;}
                }//if bookID the same
            }//if not null
            else{
                System.out.println("ID " + bookId + " is not exist.");
                break;
            }
        } //end loop
    }

    //case 5
    public static void returnBook(){
        System.out.println("========= RETURN BOOK INFO =========");
        int bookId = invalidateNum("=> Enter Book ID to Return : ",0,200);
        boolean found = false;
        for (int j = 0; j < book.length; j++) {
            if(book[j] != null) {
                if (book[j].getBookID() == bookId  ) {
                    if(!book[j].getBookStatus()){
                        System.out.println("Details of returned book: ");
                        System.out.println("ID: " + book[j].getBookID());
                        System.out.println("Title: " + book[j].getBookTitle());
                        System.out.println("Author: " + book[j].getAuthor().getAuthorName() + " (" + book[j].getAuthor().getAuthorYear() + ")");
                        System.out.println("Published Year: " + book[j].getBookPublishDate());
                        System.out.println("Book returned successfully!");
                        System.out.println();
                        book[j].setBookStatus(true);
                        found=true;
                        break;
                    }//if available or not
                    else{
                        System.out.println("ID " + bookId + ", the book hasn't been borrowed yet!\nit can not be returned. ");
                        break;}
                }//if bookID the same
            }//if not null
            else{
                System.out.println("ID " + bookId + " is not exist.");
                break;
            }
        } //end loop
    }

    //case 6 remove book
    public static void removeBook(){
        Scanner input = new Scanner(System.in);
        System.out.println("========= REMOVE BOOK INFO =========");
        int bookId = invalidateNum("Enter book ID: ",1,200);

        for (int j = 0; j < book.length; j++) {
            if (book[j].getBookID() == bookId  ) {
                if(book[j].getBookStatus() == true ){
                    System.out.println("Details of borrowed book: ");
                    System.out.println("ID: " + book[j].getBookID());
                    System.out.println("Title: " + book[j].getBookTitle());
                    System.out.println("Author: " + book[j].getAuthor().getAuthorName() + " (" + book[j].getAuthor().getAuthorYear() + ")");
                    System.out.println("Published Year: " + book[j].getBookPublishDate());
                    System.out.println("Book removed successfully!");
                    System.out.println();
                    for(int l = bookId-1; l < book.length -1; l++){
                        book[l] = book[l + 1];
                    }
                    break;
                }//if available or not
                else{
                    System.out.println("ID " + bookId + ", the book is already borrowed. (Unavailable)");
                    break;
                }
            }//if bookID the same
            else {
                System.out.println("ID " + bookId + " is not exist.");
                break;
            }
        } //end loop
    }//HELLO TEACHERS! THIS CASE CAN ONLY REMOVE THE FIRST ELEMENT, AND I DON'T KNOW WHY TOO! BEST REGARD....


    // case 7
    public static void exitLibrary(){
        System.out.println("(^-^) Good Bye! (^-^)");
        System.exit(0);
    }

    //invalidate number
    public static Integer invalidateNum(String ouputText, int min, int max){
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[\\d -]+");
        boolean check;
        String inputText;
        do{
            System.out.print(ouputText);
            inputText = scanner.nextLine();

//            check = pattern.matcher(inputText).matches()?(Integer.valueOf(inputText)>=min && Integer.valueOf(inputText)<=max):false;
            if(pattern.matcher(inputText).matches()){
                check = (Integer.valueOf(inputText)>=min && Integer.valueOf(inputText)<=max);
            }else
                check=false;
            if(!check)
                System.out.println("*****Invalidation Numbers*****");
        }while (!check);
        return Integer.valueOf(inputText);
    }

    //invalidate string
    public static String invalidateTexts(String outputText){
        Scanner cin = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^[a-zA-Z]+( [a-zA-Z]+)*$");
        boolean check;
        String inputText;
        do{
            System.out.print(outputText);
            inputText = cin.nextLine();
            check = pattern.matcher(inputText.trim()).matches();
            if(!check)
                System.out.println("*****Invalidation Texts*****");
        }while (!check);
        return String.valueOf(inputText);
    }
}
