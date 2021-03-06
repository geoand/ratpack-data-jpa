package geoand.ratdatajpa.book.model

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by gandrianakis on 22/10/2015.
 */
@Entity
@ToString
class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id

    String isbn
}
