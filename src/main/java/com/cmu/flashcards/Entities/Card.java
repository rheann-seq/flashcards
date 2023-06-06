package com.cmu.flashcards.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table
public class Card {
    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;
    @Column
    private String frontData;
    @Column
    private String backData;
}
