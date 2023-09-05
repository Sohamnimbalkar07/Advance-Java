package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

@Entity
@Table(name="tutorials")
//@Getter
//@Setter
//@ToString(exclude = "topic")
public class Tutorial extends BaseEntity{
	/*
	 * name | author | publish_date | visits | contents | topic_id
	 * 
	 */
	@Column(name="name")
	private String tutName="some name";
	private String author;
	@Column(name="publish_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
	private int visits;
	private String contents;
	//Many to One : Topic 1<----* Tutorial  
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
	
			
}
