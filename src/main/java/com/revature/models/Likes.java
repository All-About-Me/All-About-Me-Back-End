package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


	@Data//
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Builder//
public class Likes {

	    @Id
	    @GeneratedValue(strategy = IDENTITY)//
	    private Long likesId;
	    private LikeSwitch likeSwitch;
	
	    @ManyToOne(fetch = LAZY)
	    private Post post;
	    @ManyToOne(fetch = LAZY)
	    private User user;
	}
