package geoand.ratdatajpa.book.service

import geoand.ratdatajpa.book.model.Book

/**
 * Created by gandrianakis on 22/10/2015.
 */
interface BookService {

    List<Book> findAll()

    List<Book> findByIsbn(String lastName)

    Book save(Book customer)
}
