package com.authors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Optional<String> getAuthorsByFullName(String fullName) {
        String[] firstAndLastName = fullName.split(" ");
        return authorRepository.findByFirstNameAndLastName(firstAndLastName[0], firstAndLastName[1])
                .map(Author::getFullName);
    }

    public String saveAuthor(String fullName) {
        String[] firstAndLastName = fullName.split(" ");
        Author author = Author.builder().firstName(firstAndLastName[0]).lastName(firstAndLastName[1]).build();
        return authorRepository.save(author).getFullName();
    }
}
