package geoand.ratdatajpa.test.configurations

import geoand.ratdatajpa.book.model.Book
import geoand.ratdatajpa.book.service.BookService
import geoand.ratdatajpa.test.support.AbstractMainClassApplicationUnderTestConfiguration
import geoand.ratdatajpa.test.support.IsolatedConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Created by gandrianakis on 22/10/2015.
 */

@IsolatedConfiguration
class BookConfiguration extends AbstractMainClassApplicationUnderTestConfiguration {

    static final ISBN_WITH_BOOKS = '321'

    Map<String, List<Book>> map = [
            (ISBN_WITH_BOOKS): [new Book(isbn: ISBN_WITH_BOOKS)]
    ]

    @Bean
    public BookService dummyBookService() {

        return new BookService() {

            @Override
            List<Book> findAll() {
                return new ArrayList<>(map.values().findAll{it.isbn})
            }

            @Override
            List<Book> findByIsbn(String isbn) {
                return map.get(isbn) ?: []
            }

            @Override
            Book save(Book book) {
                book.id = -1
                return book
            }
        }
    }
}
