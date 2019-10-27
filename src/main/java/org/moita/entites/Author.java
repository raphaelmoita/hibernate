package org.moita.entites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.moita.util.Tables;

import javax.persistence.*;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Entity
@Table(name = Tables.AUTHOR)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    private List<Book> books = newArrayList();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return new EqualsBuilder()
                .append(id, author.id)
                .append(name, author.name)
                .append(books, author.books)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
                .append(books)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("books", books)
                .toString();
    }
}
