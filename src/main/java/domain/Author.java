package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.ManyToMany;
@Entity
public class Author {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

private String firstName;
private String lastName;
@ManyToMany(mappedBy="authors")
private Set<Book> books= new HashSet<>();

public Author() {
	
}

public Author( String firstName, String lastName) {
	
	
	this.firstName = firstName;
	this.lastName = lastName;
	//this.books = books;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Set<Book> getBooks() {
	return books;
}
public void setBooks(Set<Book> books) {
	this.books = books;
}

public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}




@Override
public String toString() {
	return "Author{ Id=" + Id + ", firstName='" + firstName + "', lastName='" + lastName + "', books=" + books + "}";
}

@Override
public int hashCode() {
	return Id != null ? Id.hashCode():0 ;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Author other = (Author) obj;
	if (Id != other.Id)
		return false;
	return true;
}




}