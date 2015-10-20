package geoand.ratdatajpa.book.repository

import geoand.ratdatajpa.book.model.Book
import org.springframework.data.repository.Repository

/**
 * Created by gandrianakis on 22/10/2015.
 */
interface BookRepository extends Repository<Book, Long>{

    List<Book> findAll()

    List<Book> findByIsbn(String lastName)

    Book save(Book customer)

}