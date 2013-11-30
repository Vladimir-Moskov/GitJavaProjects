package javaJunior;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		
		ImagePojoBuilder pojo = new ImagePojoBuilder("foto", "C:\\");
		ImagePojoBuilder pojoNew = new ImagePojoBuilder("new foto", "C:\\", 100, 100, 0, 0);
		
		System.out.println(pojo);
		System.out.println(pojoNew);
		
		ImagePojoBuilder pojoBuilder = new ImagePojoBuilder.Builder("foto", "C:\\")
										.height(500)
										.width(700)
										.x(50)
										.y(50)
										.build();
		
		ImagePojoBuilder pojoBuilderNew =  new ImagePojoBuilder.Builder("new foto", "C:\\", 100, 100, 0, 0)
											.build();
		
		System.out.println(pojoBuilder);
		System.out.println(pojoBuilderNew);
	}

}
