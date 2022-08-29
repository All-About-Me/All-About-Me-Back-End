package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.LAZY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name ="likes")
public class Like {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @ManyToOne
	    private Post post;
	    
	    @ManyToOne
	    private User user;

		public Like(Post post, User user) {
			super();
			this.post = post;
			this.user = user;
		}
	    
	    
	}
