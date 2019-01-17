package test;

import org.junit.Test;

import com.chinasoft.empsys.utils.MyDButils;

/**
 *测试类
 */
public class TestClass {
	@Test
	public void testConnection() {
		
		System.out.println(MyDButils.getConnection());
	}
	
	@Test
	public void testNull() {
		System.out.println(null==null);
		System.out.println();
	}
}
