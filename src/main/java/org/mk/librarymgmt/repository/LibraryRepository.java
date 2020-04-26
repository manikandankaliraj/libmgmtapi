package org.mk.librarymgmt.repository;

import org.mk.librarymgmt.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manikandan
 */
@Repository
public interface LibraryRepository  extends JpaRepository<Library,Long> {
}
