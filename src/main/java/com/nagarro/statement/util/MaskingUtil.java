package com.nagarro.statement.util;

import java.lang.reflect.Field;

import com.nagarro.statement.custom.annotations.Mask;


public final  class MaskingUtil {
	 public static String maskStringField(Class<?> clss, final String fieldName, final String currValue) {
	        for (Field field : clss.getDeclaredFields()) {
	            String fName = field.getName();

	            if (fieldName.equals(fName)) {
	                if (field.isAnnotationPresent(Mask.class)) {
	                    Mask mask = field.getAnnotation(Mask.class);
	                    if (mask.value() != null && !mask.value().isEmpty()) {
	                        return mask.value();
	                    }
	                } 
	            }
	        }
	        return currValue;
	    }


}
