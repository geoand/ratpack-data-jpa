package geoand.ratdatajpa.handler

import geoand.ratdatajpa.book.model.Book
import geoand.ratdatajpa.test.configurations.BookConfiguration
import geoand.ratdatajpa.test.support.basespec.AbstractBaseSpringMainClassApplicationUnderTestProviderSpec
import geoand.ratdatajpa.test.support.MainApplicationUnderTestConfiguration
import groovy.json.JsonSlurper
import spock.lang.Shared

import static groovy.json.JsonOutput.toJson
import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by gandrianakis on 21/10/2015.
 */
@MainApplicationUnderTestConfiguration(BookConfiguration)
class BookFunctionalSpec extends AbstractBaseSpringMainClassApplicationUnderTestProviderSpec {

    @Shared
    JsonSlurper jsonSlurper = new JsonSlurper()

    def "book isbn handler empty"() {
        when:
            final List<Book> result = getBooks("-1")

        then:
            [] == result
    }

    def "book isbn handler non empty"() {
        when:
            final List<Book> result = getBooks(BookConfiguration.ISBN_WITH_BOOKS)

        then:
            assertThat(result).hasSize(1)
            result[0].isbn == BookConfiguration.ISBN_WITH_BOOKS
    }

    def "all books"() {
        when:
            final List<Book> result = getBooks()

        then:
            assertThat(result).hasSize(1)
    }

    def "create book"() {
        final def isbn = "test"
        when:
            requestSpec { spec ->
                spec.body { b ->
                    b.type("application/json")
                    b.text(toJson(new Book(isbn: isbn)))
                }
            }
            post("book")

        then:
            final Book savedBook = parseBooks(response.body.text)
            savedBook.id
            savedBook.isbn == isbn
    }

    private List<Book> getBooks() {
        parseBooks(getText("book"))
    }

    private List<Book> getBooks(String lastName) {
        parseBooks(getText("book/$lastName"))
    }

    private def parseBooks(String booksStr) {
        return jsonSlurper.parseText(booksStr)
    }
}
