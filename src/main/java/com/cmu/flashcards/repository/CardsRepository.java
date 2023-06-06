package com.cmu.flashcards.repository;

import com.cmu.flashcards.Entities.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardsRepository extends CrudRepository<Card, Long> {
}
