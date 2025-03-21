package org.example.eksamenweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Gjør at frontend får lov til å sende
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Lagrer bok
    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book) {
        // Skriv ut data som kommer inn (debug)
        System.out.println("Mottatt bok: " + book.getName() + ", " + book.getAuthor());

        // Lagre boka
        bookRepository.save(book);

        return "Book saved!";
    }

    // Henter alle bøker
    @GetMapping("/getBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return "Book dleted successfully";
        }else {
            return "Book Id has not found";
        }
    }
}


