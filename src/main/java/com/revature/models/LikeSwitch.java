package com.revature.models;
import java.util.Arrays;

import com.revature.exceptions.LSystemTalkException;




public enum LikeSwitch {

	LikesOn(1),LikesOff(0),;

	private int action;

 LikeSwitch(int action) {}
	

public Integer switchLook() {
	return action;
}

public static LikeSwitch viewStatus(Integer action) {
    return Arrays.stream(LikeSwitch.values())
            .filter(value -> value.switchLook().equals(action))
            .findAny()
            .orElseThrow(() -> new LSystemTalkException("like not found"));
}



}


