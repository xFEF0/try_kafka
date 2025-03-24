package com.xfef0.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}
