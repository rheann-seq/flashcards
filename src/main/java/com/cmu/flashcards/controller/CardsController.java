package com.cmu.flashcards.controller;

import com.cmu.flashcards.Entities.Card;
import com.cmu.flashcards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CardsController {

    @Autowired
    CardsRepository repository;

    @GetMapping("/getCards")
    Map<String, Object> getFlashCard() {
        Map<String, Object> cards = new LinkedHashMap<>();
        List<Card> dbCards = (List<Card>) repository.findAll();
        cards.put("totalCards", dbCards.size());
        cards.put("cards", dbCards);
        return cards;
    }

    @PostMapping("/addCard")
    String addCard(@RequestBody Map<String, Object> cardMap) {
        try {
            Card card = new Card();
            card.setFrontData(cardMap.get("frontData").toString());
            card.setBackData(cardMap.get("backData").toString());
            repository.save(card);
            return "Card added successfully";
        } catch (Exception ex) {
            System.out.println("Error in save:" + ex.getMessage());
            return "Uh oh! there has been an error while saving your card";
        }
    }
}
