package mockitoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaJunior.ImagePojoBuilder;

import org.junit.Test;

public class ServiceHelperTest {
	
	private ImagePojoBuilder pojo1 = new ImagePojoBuilder("image1", "path/", 500, 300, 45, 55);
	private ImagePojoBuilder pojo2 = new ImagePojoBuilder("image2", "path/", 500, 300, 45, 55);
	private ImagePojoBuilder pojo3 = new ImagePojoBuilder("image3", "path/", 500, 300, 45, 55);
	private ImagePojoBuilder pojo4 = new ImagePojoBuilder("image4", "path/", 500, 300, 45, 55);
	
	private ServiceHelper serviceHelper = new ServiceHelper();
	
	@Test
	public void testInnerJoin() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo2, pojo1, pojo4, pojo3, pojo2, pojo1);
		List<ImagePojoBuilder> pojoList2 = Arrays.asList(pojo2, pojo4, pojo2, pojo4);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo2, pojo4, pojo2);
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.innerJoin(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public void testInnerJoinNull() {
		List<ImagePojoBuilder> pojoList1 = null;
		List<ImagePojoBuilder> pojoList2 = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListExpected = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.innerJoin(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public void testRemoveDuplicates() {
		List<ImagePojoBuilder> pojoList = Arrays.asList(pojo4, pojo3, pojo3, pojo4);

		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.removeDuplicates(pojoList);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public void testRemoveDuplicatesNull() {
		List<ImagePojoBuilder> pojoList = null;

		List<ImagePojoBuilder> pojoListExpected = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.removeDuplicates(pojoList);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public void testRemoveDuplicatesWithout() {
		List<ImagePojoBuilder> pojoList = Arrays.asList(pojo4, pojo3, pojo1, pojo2);

		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo3, pojo4, pojo1, pojo2);;
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.removeDuplicates(pojoList);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	@Test
	public void testSort() {
		List<ImagePojoBuilder> pojoList = new ArrayList<ImagePojoBuilder>
			(Arrays.asList(pojo4, pojo3, pojo1, pojo2));
	
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.sort(pojoList);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public void testSortForSorted() {
		List<ImagePojoBuilder> pojoList = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
	
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.sort(pojoList);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public void testSortForNull() {
		List<ImagePojoBuilder> pojoList = null;
		
		List<ImagePojoBuilder> pojoListExpected = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListResult = serviceHelper.sort(pojoList);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
}
