package geoand.ratdatajpa.customer.model

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by gandrianakis on 20/10/2015.
 */
@Entity
@ToString
class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id
    String firstName
    String lastName

}
