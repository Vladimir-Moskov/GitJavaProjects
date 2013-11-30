package pojoUtils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaJunior.ImagePojoBuilder;

import org.junit.Test;

public class PojoUtilsTest {

	PojoUtils pojoUtils = new PojoUtils();
	
	ImagePojoBuilder pojo1 = new ImagePojoBuilder("name1", "path", 500, 300, 25, 75);
	ImagePojoBuilder pojo2 = new ImagePojoBuilder("name2", "path", 500, 300, 25, 75);
	ImagePojoBuilder pojo3 = new ImagePojoBuilder("name3", "path", 500, 300, 25, 75);
	ImagePojoBuilder pojo4 = new ImagePojoBuilder("name4", "path", 500, 300, 25, 75);
	
	@Test
	public final void testMerge() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo1, pojo2);
		List<ImagePojoBuilder> pojoList2 = Arrays.asList(pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeUnsortable() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo4, pojo2);
		List<ImagePojoBuilder> pojoList2 = Arrays.asList(pojo1, pojo3);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList2, pojoList1);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeDublicate() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo1, pojo2);
		List<ImagePojoBuilder> pojoList2 = Arrays.asList(pojo1, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeDublicateUnsortable() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo4, pojo2);
		List<ImagePojoBuilder> pojoList2 = Arrays.asList(pojo4, pojo1, pojo3);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeFullDublicate() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo1, pojo2, pojo3);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2, pojo3);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList1);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeFullDublicateUnsotable() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo4, pojo1, pojo3);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList1);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	@Test
	public final void testMergeOneNull() {
		List<ImagePojoBuilder> pojoList1 = Arrays.asList(pojo1, pojo2);
		List<ImagePojoBuilder> pojoList2 = null;
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo1, pojo2);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeOneEmpty() {
		List<ImagePojoBuilder> pojoList1 = new ArrayList<ImagePojoBuilder>();
		List<ImagePojoBuilder> pojoList2 = Arrays.asList(pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListExpected = Arrays.asList(pojo3, pojo4);
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
	
	@Test
	public final void testMergeBothNull() {
		List<ImagePojoBuilder> pojoList1 = null;
		List<ImagePojoBuilder> pojoList2 = null;
		
		List<ImagePojoBuilder> pojoListExpected = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}

	@Test
	public final void testMergeBothEmpty() {
		List<ImagePojoBuilder> pojoList1 = new ArrayList<ImagePojoBuilder>();
		List<ImagePojoBuilder> pojoList2 = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListExpected = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListResult = pojoUtils.merge(pojoList1, pojoList2);
		
		assertTrue(pojoListExpected.equals(pojoListResult));
	}
}
