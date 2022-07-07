package com.example.lnkshrtnr.app.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table (name = "links")
public class Link {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "links_generator")
    @SequenceGenerator(name = "links_generator", sequenceName = "links_seq", allocationSize = 1)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private String url;


}
