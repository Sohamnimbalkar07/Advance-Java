package com.app.pojos;

import javax.persistence.*;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;


//@Getter
//@Setter
//@ToString
@Entity
@Table(name = "topics")
public class Topic extends BaseEntity {
//id | name
	@Column(name = "name")
	private String topicName;

		
}
