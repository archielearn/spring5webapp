package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Book {
	private Long id;
private String title;
private String isbn;
@ManyToMany
@JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"),
inverseJoinColumns = @JoinColumn(name="author_id")
)
private Set<Author> authors= new HashSet<>();



public Book() {
	
}
public Book(String title, String isbn) {
	
	this.title = title;
	this.isbn = isbn;
	//this.authors = authors;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public Set<Author> getAuthors() {
	return authors;
}
public void setAuthors(Set<Author> authors) {
	this.authors = authors;
}
/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
@Override
public int hashCode() {
	return id != null ? id.hashCode():0 ;
}
@Override
public String toString() {
	return "Book {id='" + id + "', title='" + title + "', isbn='" + isbn + "', authors=" + authors + "}";
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (id != other.id)
		return false;
	return true;
}

}
