package javaJunior;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImagePojoBuilderTest {
	
	private String nameValid = "image";
	private String pathValid = "images/";
	private int widthValid = 500;
	private int heightValid = 300;
	private int xValid = 25;
	private int yValid = 75;
	
	private String nameInvalid = "not_image";
	private String pathInvalid = "not_images/";
	private int widthInvalid= 900;
	private int heightInvalid = 900;
	
	@Test
	public final void testHashCode() {
		int result = getHashCode(nameValid, pathValid, widthValid, heightValid);
		
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid, widthValid, heightValid);
		int pojoHashCode = pojo.hashCode();
		
		assertEquals(result, pojoHashCode);
	}
	
	@Test
	public final void testHashCodeInvalid() {
		int result = getHashCode(nameValid, pathValid, widthValid, heightValid);
		
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameInvalid, pathInvalid, widthInvalid, heightInvalid);
		int pojoHashCode = pojo.hashCode();
		
		assertNotEquals(result, pojoHashCode);
	}
	
	@Test
	public final void testHashCodeInvalidName() {
		int result = getHashCode(nameValid, pathValid, widthValid, heightValid);
		
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameInvalid, pathValid, widthValid, heightValid);
		int pojoHashCode = pojo.hashCode();
		
		assertNotEquals(result, pojoHashCode);
	}
	
	@Test
	public final void testHashCodeInvalidPath() {
		int result = getHashCode(nameValid, pathValid, widthValid, heightValid);
		
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathInvalid, widthValid, heightValid);
		int pojoHashCode = pojo.hashCode();
		
		assertNotEquals(result, pojoHashCode);
	}
	
	@Test
	public final void testHashCodeInvalidWidth() {
		int result = getHashCode(nameValid, pathValid, widthValid, heightValid);
		
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid, widthInvalid, heightValid);
		int pojoHashCode = pojo.hashCode();
		
		assertNotEquals(result, pojoHashCode);
	}
	
	@Test
	public final void testHashCodeInvalidHeight() {
		int result = getHashCode(nameValid, pathValid, widthValid, heightValid);
		
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid, widthValid, heightInvalid);
		int pojoHashCode = pojo.hashCode();
		
		assertNotEquals(result, pojoHashCode);
	}
	
	@Test
	public final void testSetName() {
		ImagePojoBuilder pojo = new ImagePojoBuilder("", "");
		
		pojo.setName(nameValid);
		
		assertEquals(nameValid, pojo.getName());
	}

	@Test
	public final void testGetPath() {
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, "");
		
		pojo.setPath(pathValid);
		
		assertEquals(pathValid, pojo.getPath());
	}

	@Test
	public final void testSetWidth() {
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid);
		
		pojo.setWidth(widthValid);;
		
		assertEquals(widthValid, pojo.getWidth());
	}

	@Test
	public final void testSetHeight() {
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid);
		
		pojo.setHeight(heightValid);;
		
		assertEquals(heightValid, pojo.getHeight());
	}

	@Test
	public final void testSetX() {
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid);
		
		pojo.setX(xValid);
		
		assertEquals(xValid, pojo.getX());
	}

	@Test
	public final void testSetY() {
		ImagePojoBuilder pojo = new ImagePojoBuilder(nameValid, pathValid);
		
		pojo.setY(yValid);
		
		assertEquals(yValid, pojo.getY());
	}

	@Test
	public final void testEqualsObjectShortConstrctor() {
		ImagePojoBuilder pojo1 = new ImagePojoBuilder(nameValid, pathValid);
		ImagePojoBuilder pojo2 = new ImagePojoBuilder(nameValid, pathValid);
		
		assertTrue(pojo1.equals(pojo2));
	}
	
	@Test
	public final void testEqualsObjectShortConstrctorInvalid() {
		ImagePojoBuilder pojo1 = new ImagePojoBuilder(nameValid, pathValid);
		ImagePojoBuilder pojo2 = new ImagePojoBuilder(nameInvalid, pathInvalid);
		
		assertFalse(pojo1.equals(pojo2));
	}
	
	@Test
	public final void testEqualsObjectMidleConstrctor() {
		ImagePojoBuilder pojo1 = new ImagePojoBuilder(nameValid, pathValid,
													widthValid, heightValid);
		ImagePojoBuilder pojo2 = new ImagePojoBuilder(nameValid, pathValid,
													widthValid, heightValid);
		
		assertTrue(pojo1.equals(pojo2));
	}
	
	@Test
	public final void testEqualsObjectMidleConstrctorInvalid() {
		ImagePojoBuilder pojo1 = new ImagePojoBuilder(nameValid, pathValid,
													widthValid, heightValid);
		ImagePojoBuilder pojo2 = new ImagePojoBuilder(nameInvalid, pathInvalid,
													widthInvalid, heightInvalid);
		
		assertFalse(pojo1.equals(pojo2));
	}
	
	@Test
	public final void testEqualsObjectFullConstrctor() {
		ImagePojoBuilder pojo1 = new ImagePojoBuilder(nameValid, pathValid, 
				 									  widthValid, heightValid,
				 									  xValid, yValid);
		ImagePojoBuilder pojo2 = new ImagePojoBuilder(nameValid, pathValid, 
													  widthValid, heightValid,
													  xValid, yValid);
		
		assertTrue(pojo1.equals(pojo2));
	}
	
	private int getHashCode(String name, String path, int width, int height) {
	    int prime = 31;
		int result = 1;
		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + width;
		result = prime * result + height;
		
		return result;
	}
}
