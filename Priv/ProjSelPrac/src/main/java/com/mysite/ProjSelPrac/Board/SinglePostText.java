package com.mysite.ProjSelPrac.Board;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class SinglePostText {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    private LocalDateTime createDate;
    
    private String autor;
    
    @Column(length= 100000000)
    private String content;
    
    private boolean important;
    
    private String menu;
    
    private String category;
    
    @OneToMany(mappedBy = "singleposttext", cascade = CascadeType.REMOVE) 
    private List<Comment> commentList; 
    
}
