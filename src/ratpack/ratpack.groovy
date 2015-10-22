import geoand.ratdatajpa.SpringConfig
import geoand.ratdatajpa.book.model.Book
import geoand.ratdatajpa.book.service.BookService
import geoand.ratdatajpa.customer.model.Customer
import geoand.ratdatajpa.customer.service.CustomerService
import org.springframework.boot.SpringApplication
import org.springframework.context.ApplicationContext
import ratpack.exec.Blocking

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.fromJson
import static ratpack.jackson.Jackson.json
import static ratpack.spring.Spring.spring

ratpack {

  bindings {
      bindInstance(ApplicationContext, SpringApplication.run(SpringConfig))
  }

  handlers {  ApplicationContext ctx ->
      register(spring(ctx))

      /**
       * Customer
       */

      post("customer") { CustomerService customerService ->
          parse(fromJson(Customer)).then({ customer ->
              Blocking.get {
                  customerService.save(customer)
              } then { Customer savedCustomer ->
                  render(json(savedCustomer))
              }
          })
      }

      get("customer/:lastName") { CustomerService customerService ->
          Blocking.get {
              customerService.findByLastName pathTokens["lastName"]
          } then { List<Customer> customers ->
              render(json(customers))
          }
      }

      /**
       * Book
       */

      path("book") { BookService bookService ->
          byMethod {
              get {
                  Blocking.get {
                      bookService.findAll()
                  } then { List<Book> books ->
                      render(json(books))
                  }
              }


              post {
                  parse(fromJson(Book)).then({ book ->
                      Blocking.get {
                          bookService.save(book)
                      } then { Book savedCustomer ->
                          render(json(savedCustomer))
                      }
                  })
              }
          }

      }

      get("book/:isbn") { BookService bookService ->
          Blocking.get {
              bookService.findByIsbn pathTokens["isbn"]
          } then { List<Book> books ->
              render(json(books))
          }
      }


  }
}
