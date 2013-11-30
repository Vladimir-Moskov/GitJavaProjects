package serealization;

import java.util.Arrays;
import java.util.List;


public class SerealizationDemo {

	public static void main(String[] args) {
	
		
		ImagePojo pojo1 = new ImagePojo("image1", "path/", 500, 300, 45, 55);
		ImagePojo pojo2 = new ImagePojo("image2", "path/", 500, 300, 45, 55);
		ImagePojo pojo3 = new ImagePojo("image3", "path/", 500, 300, 45, 55);
		ImagePojo pojo4 = new ImagePojo("image4", "path/", 500, 300, 45, 55);
		
		SerealizationService pojoService = new SerealizationService();
		
		List<ImagePojo> pojoList = Arrays.asList(pojo4, pojo2, pojo1, pojo3);

		pojoService.saveData(pojoList);
		List<ImagePojo> resultPojoList = pojoService.loadData() ;
		
		System.out.println("*input*");
		System.out.println(pojoList); 
		
		System.out.println("*result*");
		System.out.println(resultPojoList);

	}

}
