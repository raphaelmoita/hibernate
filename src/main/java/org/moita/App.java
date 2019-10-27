package org.moita;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.moita.entites.Author;
import org.moita.entites.Book;
import org.moita.entites.Isbn;
import org.moita.entites.Publisher;
import org.moita.util.HibernateUtil;

import java.util.List;

import static java.util.Collections.singletonList;

public class App 
{
    public static void main(String[] args) {

        Isbn isbn = new Isbn();
        isbn.setNumber("123-123-123-123");

        Author author = new Author();
        author.setName("Raphael");

        Book book = new Book();
        book.setAuthors(singletonList(author));
        book.setNumPages(1000);
        book.setIsbn(isbn);

        Publisher publisher = new Publisher();
        publisher.setBooks(singletonList(book));

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {

            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(publisher);
            // commit transaction
            transaction.commit();

            List<Publisher> books = session.createQuery("from Publisher", Publisher.class).list();
            books.forEach(System.out::println);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
