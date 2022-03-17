package com.example.springintroexercise.service.impl;

import com.example.springintroexercise.model.entity.Author;
import com.example.springintroexercise.repository.AuthorRepository;
import com.example.springintroexercise.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private static final String AUTHOR_PATH = "C:\\Users\\F3\\Desktop\\springIntroExercise\\src\\main\\resources\\files\\authors.txt";

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of(AUTHOR_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(authorName ->{
                    String[] fullName = authorName.split("\\s+");
                    Author author = new Author(fullName[0],fullName[1]);
                    authorRepository.save(author);

                });

    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom.current().nextLong(1,authorRepository.count());
        return authorRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfBooks() {
        return authorRepository
                .findAllByBooksSizeDescending()
                .stream()
                .map(author -> String.format
                        ("%s %s %d",
                                author.getFirstName(),
                                author.getLastName(),
                                author.getBooks().size()))
                .collect(Collectors.toList());
    }


}
