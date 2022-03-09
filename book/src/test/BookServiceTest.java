package test;

import org.junit.Test;
import pojo.Book;
import pojo.Page;
import service.BookService;
import service.iml.BookServiceImpl;

import java.math.BigDecimal;


/**
 * @author Charley
 * @creat 2021-07-09 14:45
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(21,"计算机网络", "1125", new BigDecimal(1000000),
                100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24,"计算机网络", "1125", new BigDecimal(100),
                100, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(19));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookService.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }
}