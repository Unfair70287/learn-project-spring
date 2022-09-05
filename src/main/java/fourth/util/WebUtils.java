package fourth.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	
	public static int paseInt(String i) {
		int num;
		try {
			num = Integer.parseInt(i);
			return num;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
		return 0;
	}
	public static Object copyObject(Object newOb,Object oldOb) {
		try {
			BeanUtils.copyProperties(newOb, oldOb);
			return newOb;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
