package mockitoTests;

import java.util.ArrayList;
import java.util.List;

import javaJunior.ImagePojoBuilder;

public class MockitoServiceDemo {

	public static void main(String[] args) {

		List<ImagePojoBuilder> pojoList1 = new ArrayList<ImagePojoBuilder>();
		List<ImagePojoBuilder> pojoList2 = new ArrayList<ImagePojoBuilder>();
		
		ImagePojoBuilder pojo1 = new ImagePojoBuilder("image1", "path/", 500, 300, 45, 55);
		ImagePojoBuilder pojo2 = new ImagePojoBuilder("image2", "path/", 500, 300, 45, 55);
		ImagePojoBuilder pojo3 = new ImagePojoBuilder("image3", "path/", 500, 300, 45, 55);
		ImagePojoBuilder pojo4 = new ImagePojoBuilder("image4", "path/", 500, 300, 45, 55);
		
		Service pojoService = new Service(new ServiceHelper());
		
		pojoList1.add(pojo4);
		pojoList1.add(pojo2);
		pojoList1.add(pojo3);
		pojoList1.add(pojo4);
		
		pojoList2.add(pojo2);
		pojoList2.add(pojo4);
		pojoList2.add(pojo1);

		
		List<ImagePojoBuilder> resultPojoList = pojoService.innerJoin(pojoList1, pojoList2);
		
		System.out.println("*input*");
		System.out.println(pojoList1); 
		System.out.println(pojoList2);
		
		System.out.println("*result*");
		System.out.println(resultPojoList);
	}

}
