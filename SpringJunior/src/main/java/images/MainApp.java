package main.java.images;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
   public static void main(String[] args) {
	   try{
		   ApplicationContext context = 
		      		new ClassPathXmlApplicationContext("**/Spring-Module*.xml");
							
		      Hello obj = (Hello) context.getBean("helloWorld");

		      obj.getMessage();
		      
		      ImagePojoDao dao = (ImagePojoDao) context.getBean("imagePojoDAO");
		      dao.clearTable();
		      dao.setUpTable();
		      dao.putData();
		      
		      List<ImagePojo> list = dao.getAll();
		      System.out.println(list);
		      
		      ImagePojo image1 = new ImagePojo(99L, "ImagePojo", "ImagePojo", 77, 77);
		      dao.addImage(image1);
		      list = dao.getAll();
		      System.out.println(list);
		      
		      image1.setName("new Name");
		      dao.updateImage(image1);
		      list = dao.getAll();
		      System.out.println(list);
		            
		      dao.deleteImage(image1);
		      list = dao.getAll();
		      System.out.println(list);
	   }
	   catch(Exception e){
		   System.out.println(e);
	   }
      
   }

}
