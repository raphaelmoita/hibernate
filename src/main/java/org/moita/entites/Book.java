package org.moita.entites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.moita.util.Tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Tables.BOOK)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;

    @OneToOne()
    @JoinColumn(name = "isbn_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Isbn isbn;

    @ManyToMany(cascade = { javax.persistence.CascadeType.ALL })
    @JoinTable(
            name = Tables.AUTHOR,
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private List<Author> authors;

    private String description;

    private int numPages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(id, book.id)
                .append(numPages, book.numPages)
                .append(isbn, book.isbn)
                .append(authors, book.authors)
                .append(description, book.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(isbn)
                .append(authors)
                .append(description)
                .append(numPages)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("isbn", isbn)
                .append("authors", authors)
                .append("description", description)
                .append("numPages", numPages)
                .toString();
    }
}
