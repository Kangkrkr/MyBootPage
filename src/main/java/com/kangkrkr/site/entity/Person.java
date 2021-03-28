package com.kangkrkr.site.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Integer idx;
    
    @Column(length = 20, nullable = false)
	private String name;

    @Column(length = 40, nullable = false)
	private String email;

    @Column(length = 60, nullable = false)
	private String passwd;
}
