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


	
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Data
	@Table(name ="likes")
public class Likes {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long likesId;

	
	    @ManyToOne(fetch = LAZY)
	    private Post post;
	    
	    @ManyToOne(fetch = LAZY)
	    private User user;
	    

	public Integer getPostId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Likes(Post post, User user) {
		super();
		this.post = post;
		this.user = user;
	}
	
	/*public Likes findAllbyPost(Post post) {
		return null;
	}
	*/
	}
