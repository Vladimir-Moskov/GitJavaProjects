package arrays;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] array1 = {1,5,4,23,65,32,78};
		Integer[] array2 = {3,5,24,54,1,2,34,45,32};
		//[1, 5, 4, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45, null, null]
		//[1,5,4,23,65,32,78, 3,24,54,2,34,45] 
		ArrayUtils arrayUtils = new ArrayUtils();
		
		Integer[] array3 = arrayUtils.merge(array1, array2);	
		System.out.println(Arrays.toString(array3));
		
		Integer[] array4 = arrayUtils.innerJoin(array1, array2);	
		System.out.println(Arrays.toString(array4));
		
		Integer[] array5 = arrayUtils.leftJoin(array1, array2);	
		System.out.println(Arrays.toString(array5));
		
		Integer[] array6 = arrayUtils.outerJoin(array1, array2);	
		System.out.println(Arrays.toString(array6));
	}

}
