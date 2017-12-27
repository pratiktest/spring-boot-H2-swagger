package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.exception.BookAlreadyExistsException;
import com.example.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(final BookRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Book saveBook(@NotNull @Valid final Book book) {
        LOGGER.debug("Creating {}", book);
        Book existing = repository.findOne(book.getId());
        if (existing != null) {
            throw new BookAlreadyExistsException(
                    String.format("There already exists a book with id=%s", book.getId()));
        }
        return repository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

    @Override
    public Book getBook(Long bookId) {
        return repository.findOne(bookId);
    }

    @Override
    @Transactional
    public void deleteBook(final Long bookId) {
        LOGGER.debug("deleting {}", bookId);
        repository.delete(bookId);
    }

}
