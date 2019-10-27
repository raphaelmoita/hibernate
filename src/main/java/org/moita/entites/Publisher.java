package org.moita.entites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.moita.util.Tables;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Tables.PUBLISHER)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private long id;

    private String description;

    @OneToMany(mappedBy = "id") // mappedBy is used for specifying name of the field in class with @ManyToOne annotation.
    private List<Book> books;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        Publisher that = (Publisher) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(description, that.description)
                .append(books, that.books)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(description)
                .append(books)
                .toHashCode();
    }

    @Override
    public String
    toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("description", description)
                .append("books", books)
                .toString();
    }
}
