package com.abhi.spring4.util;

import java.util.UUID;

public class BasicUtil {

	public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
