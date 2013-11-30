package arrays;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ArrayUtilsTest {

	
	@Test
	public void testMergePositive() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {1,5,4,23,65,32,78};
		Integer[] array2 = {3,5,24,54,1,2,34,45,32};
		Integer[] expecteds = {1,5,4,23,65,32,78, 3,24,54,2,34,45};
		Integer[] returned = arrayUtils.merge(array1, array2);
		
		assertArrayEquals(expecteds, returned);
	}
	
	@Test
	public void testMergeBothNull() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = null;
		Integer[] array2 = null;
		Integer[] expecteds = {};
		Integer[] returned = arrayUtils.merge(array1, array2);
		
		assertArrayEquals(expecteds, returned);
	}
	
	@Test
	public void testMergeOneNull() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {1,5,4,23,65,32,78, 1, 5};;
		Integer[] array2 = null;
		Integer[] expecteds = {1,5,4,23,65,32,78};;
		Integer[] returned = arrayUtils.merge(array1, array2);
		
		assertArrayEquals(expecteds, returned);
	}
	
	@Test
	public void testMergeEquals() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {1,5,4,23,65,32,78, 1, 5};
		Integer[] array2 = {1,5,4,23,65,32,78, 1, 5};
		Integer[] expecteds = {1,5,4,23,65,32,78};
		Integer[] returned = arrayUtils.merge(array1, array2);
		
		assertArrayEquals(expecteds, returned);
	}
	
	@Test
	public void testMergeBothEmpty() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {};
		Integer[] array2 = {};
		Integer[] expecteds = {};
		Integer[] returned = arrayUtils.merge(array1, array2);
		
		assertArrayEquals(expecteds, returned);
	}
	
	/*@Test
	public void testMergeBothMax() {
		ArrayUtils arrayUtils = new ArrayUtils();
		int maxSize = Integer.MAX_VALUE>>4;
		Integer[] array1 = new Integer[maxSize];
		Integer[] array2 = new Integer[maxSize];
		Arrays.fill(array1, 1);
		Arrays.fill(array2, 2);
		Integer[] expecteds = {1, 2};
		
		Integer[] returned = arrayUtils.merge(array1, array2);
		
		assertArrayEquals(expecteds, returned);
	}*/
	@Test
	public void testInnerJoin() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {1,5,4,23,65,32,78};
		Integer[] array2 = {3,5,24,4,1,2,34,45,32,5};
		Integer[] expecteds = {1, 5, 4, 32};
		Integer[] returned = arrayUtils.innerJoin(array1, array2);
				
		assertArrayEquals(expecteds, returned);
	}
 
	@Test
	public void testLeftJoin() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {1,5,4,23,65,32,78};
		Integer[] array2 = {3,5,24,4,1,2,34,45,32,5};
		Integer[] expecteds = {1,5,4,23,65,32,78,5,4,1,32,5};
		Integer[] returned = arrayUtils.leftJoin(array1, array2);
				
		assertArrayEquals(expecteds, returned);
	}

	@Test
	public void testOuterJoin() {
		ArrayUtils arrayUtils = new ArrayUtils();
		Integer[] array1 = {1,5,4,23,65,32,78};
		Integer[] array2 = {3,5,24,4,1,2,34,45,32,5};
		Integer[] expecteds = {23,65,78,3,24,2,34,45};
		Integer[] returned = arrayUtils.outerJoin(array1, array2);
				
		assertArrayEquals(expecteds, returned);
	}
}
