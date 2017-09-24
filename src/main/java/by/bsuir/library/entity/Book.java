package by.bsuir.library.entity;

import by.bsuir.library.util.IdGenerator;

import java.io.Serializable;

public class Book implements Serializable{
    private long id;
    private String name;
    private String author;
    private BookType bookType;

    public Book(String name, String author, BookType bookType) {
        this.id = IdGenerator.getInstance().nextBookId();
        this.name = name;
        this.author = author;
        this.bookType = bookType;
    }

    public Book(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (bookType != null ? bookType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookType=" + bookType +
                '}';
    }
}
