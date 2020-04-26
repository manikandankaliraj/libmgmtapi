package org.mk.librarymgmt.repository;

import org.mk.librarymgmt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Manikandan
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllBylibraryId(Long libraryId);
}
