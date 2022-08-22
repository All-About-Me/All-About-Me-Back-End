package com.revature.dtos;

import com.revature.models.LikeSwitch;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikesRequest {

	private LikeSwitch LS;
	private Integer postId;
}
