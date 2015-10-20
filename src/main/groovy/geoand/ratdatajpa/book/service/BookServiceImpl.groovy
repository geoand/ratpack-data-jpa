package geoand.ratdatajpa.book.service

import geoand.ratdatajpa.book.repository.BookRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by gandrianakis on 22/10/2015.
 */
@Service
@CompileStatic
class BookServiceImpl implements BookService {

    @Delegate(interfaces = false)
    private final BookRepository repository

    @Autowired
    BookServiceImpl(BookRepository repository) {
        this.repository = repository
    }
}
