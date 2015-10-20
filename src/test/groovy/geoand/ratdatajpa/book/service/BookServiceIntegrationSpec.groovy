package geoand.ratdatajpa.book.service

import geoand.ratdatajpa.book.model.Book
import geoand.ratdatajpa.test.support.basespec.AbstractBaseSpringTest
import org.springframework.beans.factory.annotation.Autowired

import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by gandrianakis on 22/10/2015.
 */
class BookServiceIntegrationSpec extends AbstractBaseSpringTest {

    @Autowired
    BookService bookService

    def "findAll"() {
        expect:
            assertThat(bookService.findAll()).isEmpty()
    }

    def "save"() {
        final String isbn = "test"

        when:
            final Book savedBook = bookService.save(new Book(isbn: isbn))

        then:
            savedBook.id
            savedBook.isbn == isbn
    }
}
