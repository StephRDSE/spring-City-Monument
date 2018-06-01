package co.simplon.patrimoine.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.patrimoine.spring.crud.model.Monument;

public interface MonumentRepo extends JpaRepository<Monument, Long> {

}
