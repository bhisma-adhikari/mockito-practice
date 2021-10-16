package book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

//@Getter
//@Setter
//@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private int price;

    public Book(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Book)) return false;
//        Book book = (Book) o;
//        return getPrice() == book.getPrice() && getName().equals(book.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getPrice());
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
