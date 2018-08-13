package util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyEquals {

	 /**
     * 1.null == null
     * 2.null != Object
     * 3.a.equals(b) is true,return true
     * 4.compare all Fields
     */
    public static Boolean equals(Object a,Object b) {

        if (a == null && b == null) {
            return true;
        }

        if (a != null && b == null || a == null && b != null) {
            return false;
        }

        if (a.equals(b)) {
            return true;
        }

        Class<?> type = a.getClass();

        if (type != b.getClass()) {
            return false;
        }

        //simple type
        if (ClassUtil.isPrimitiveOrWrapper(type)) {
            if (type.isPrimitive()) {
                return a == b;
            } else {
                return a.equals(b);
            }
        }

        //a,b are array
        if (type.isArray()) {
            int len = Array.getLength(a);
            if (len != Array.getLength(b)) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                if (!equals(Array.get(a, i), Array.get(b, i)))
                    return false;
            }
            return true;
        }

        //compare all Fields
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object tmp1 = field.get(a);
                Object tmp2 = field.get(b);
                if (!equals(tmp1,tmp2)) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    
    
    static class ClassUtil{
    
	    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<Class<?>, Class<?>>();
	    static {
	         primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
	         primitiveWrapperMap.put(Byte.TYPE, Byte.class);
	         primitiveWrapperMap.put(Character.TYPE, Character.class);
	         primitiveWrapperMap.put(Short.TYPE, Short.class);
	         primitiveWrapperMap.put(Integer.TYPE, Integer.class);
	         primitiveWrapperMap.put(Long.TYPE, Long.class);
	         primitiveWrapperMap.put(Double.TYPE, Double.class);
	         primitiveWrapperMap.put(Float.TYPE, Float.class);
	         primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
	    }
	    
	    
	    
	    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<Class<?>, Class<?>>();
	    static {
	        for (final Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
	            final Class<?> primitiveClass = entry.getKey();
	            final Class<?> wrapperClass = entry.getValue();
	            if (!primitiveClass.equals(wrapperClass)) {
	                wrapperPrimitiveMap.put(wrapperClass, primitiveClass);
	            }
	        }
	    }
	    
	    public static boolean isPrimitiveOrWrapper(final Class<?> type){
	    	if(type == null){
	    		return false;
	    	}
	    	return type.isPrimitive() || isPrimitiveWrapper(type);
	    	
	    	
	    }
	    
	    public static boolean isPrimitiveWrapper(final Class<?> type){
	    	return wrapperPrimitiveMap.containsKey(type);
	    }
    
    }
    
}
