package org.moita.entites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.moita.util.Tables;

import javax.persistence.*;

@Entity
@Table(name = Tables.ISBN)
public class Isbn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn_id")
    private long id;

    private String number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Isbn isbn = (Isbn) o;

        return new EqualsBuilder()
                .append(id, isbn.id)
                .append(number, isbn.number)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(number)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("number", number)
                .toString();
    }
}
