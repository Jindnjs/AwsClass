package com.example.C206Extra.Board;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	

	@JoinColumn(name = "author_id")
	private Member author;
	
	@ElementCollection
	private List<String> imagelist;
	
	private LocalDateTime date;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Comment> commentList;
}
