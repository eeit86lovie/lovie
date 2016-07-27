package com.kidscodetw.eeit.util;

import java.util.Comparator;

import com.kidscodetw.eeit.entity.message.MessageBean;

public class MessageTimestampComparator implements Comparator<MessageBean>{

	@Override
	public int compare(MessageBean o1, MessageBean o2) {
		long long1 = o1.getTimestamp().getTime();
		long long2 = o2.getTimestamp().getTime();
		if (long1>long2){
			return 1;
		}else{
			return -1;
		}
	}

}
