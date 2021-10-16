package bookbak;

//@Getter
//@Setter
//@AllArgsConstructor
public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
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
