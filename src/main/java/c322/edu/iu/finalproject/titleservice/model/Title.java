package c322.edu.iu.finalproject.titleservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String author;
    private int yearOfPublication;
    private int memberId;
    private Boolean reserveStatus;

    public Boolean getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(Boolean reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return id == title.id && yearOfPublication == title.yearOfPublication && name.equals(title.name) && author.equals(title.author) && memberId == title.memberId && reserveStatus == title.reserveStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, yearOfPublication, memberId, reserveStatus);
    }
}
