package mockitoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javaJunior.ImagePojoBuilder;

import org.junit.Test;


public class ServiceTest {
	ImagePojoBuilder pojo1 = new ImagePojoBuilder("image1", "path/", 500, 300, 45, 55);
	ImagePojoBuilder pojo2 = new ImagePojoBuilder("image2", "path/", 500, 300, 45, 55);
	ImagePojoBuilder pojo3 = new ImagePojoBuilder("image3", "path/", 500, 300, 45, 55);
	ImagePojoBuilder pojo4 = new ImagePojoBuilder("image4", "path/", 500, 300, 45, 55);
	
	ServiceHelper serviceHelper;
	Service service;
	
	public ServiceTest(){
		
		serviceHelper = mock(ServiceHelper.class);
		service = new Service(serviceHelper);

	}

	@Test
	public void testInnerJoin() {
		List<ImagePojoBuilder> pojoList1 = new ArrayList<ImagePojoBuilder>
				(Arrays.asList(pojo1, pojo1, pojo4, pojo3, pojo2, pojo2));
		List<ImagePojoBuilder> pojoList2 = new ArrayList<ImagePojoBuilder>
				(Arrays.asList(pojo2, pojo4, pojo2, pojo4));
		
		List<ImagePojoBuilder> pojoListExpectedInner = new ArrayList<ImagePojoBuilder>(
				Arrays.asList(pojo4, pojo2, pojo2));
		
		List<ImagePojoBuilder> pojoListExpectedRemove = new ArrayList<ImagePojoBuilder>(
				Arrays.asList(pojo4, pojo2));
		
		List<ImagePojoBuilder> pojoListExpectedSort = new ArrayList<ImagePojoBuilder>(
				Arrays.asList(pojo2, pojo4));
		
		when(serviceHelper.innerJoin(pojoList1, pojoList2)).
			thenReturn(pojoListExpectedInner);
		when(serviceHelper.removeDuplicates(pojoListExpectedInner)).
			thenReturn(pojoListExpectedRemove);
		when(serviceHelper.sort(pojoListExpectedRemove)).
			thenReturn(pojoListExpectedSort);
		
		List<ImagePojoBuilder> pojoListResult = service.innerJoin(pojoList1, pojoList2);
		
		assertTrue(pojoListExpectedSort.equals(pojoListResult));
	}
	
	@Test
	public void testInnerJoinEmptyResult() {
		List<ImagePojoBuilder> pojoList1 = new ArrayList<ImagePojoBuilder>
				(Arrays.asList(pojo1, pojo2, pojo1, pojo2));
		List<ImagePojoBuilder> pojoList2 = new ArrayList<ImagePojoBuilder>
				(Arrays.asList(pojo4, pojo3, pojo4, pojo3));
		
		List<ImagePojoBuilder> pojoListExpectedInner = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListExpectedRemove = new ArrayList<ImagePojoBuilder>();
		
		List<ImagePojoBuilder> pojoListExpectedSort = new ArrayList<ImagePojoBuilder>();
		
		when(serviceHelper.innerJoin(pojoList1, pojoList2)).
			thenReturn(pojoListExpectedInner);
		when(serviceHelper.removeDuplicates(pojoListExpectedInner)).
			thenReturn(pojoListExpectedRemove);
		when(serviceHelper.sort(pojoListExpectedRemove)).
			thenReturn(pojoListExpectedSort);
		
		List<ImagePojoBuilder> pojoListResult = service.innerJoin(pojoList1, pojoList2);
		
		assertTrue(pojoListExpectedSort.equals(pojoListResult));
	}

}
