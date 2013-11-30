package serealization;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SerealizationServiceTest {

	private ImagePojo pojo1 = new ImagePojo("image1", "path/", 500, 300, 45, 55);
	private ImagePojo pojo2 = new ImagePojo("image2", "path/", 500, 300, 45, 55);
	private ImagePojo pojo3 = new ImagePojo("image3", "path/", 500, 300, 45, 55);
	private ImagePojo pojo4 = new ImagePojo("image4", "path/", 500, 300, 45, 55);
	
	private List<ImagePojo> pojoList;
	
	private SerealizationService serviceHelper = new SerealizationService();
	
	@Before
	public void setUp() throws Exception {
		serviceHelper = new SerealizationService();
		
		File file  = new File(ImagePojo.fileName);
		System.out.println(file.exists());
		if(file.exists())
			file.delete();
	}
	
	@After
	public void tearDown() throws Exception {
		File file  = new File(ImagePojo.fileName);
		System.out.println(file.exists());
		if(file.exists())
			file.delete();
	}

	@Test
	public void testSaveDataEmpty() {
		pojoList = new ArrayList<ImagePojo>();
		serviceHelper.saveData(pojoList);
		File file  = new File(ImagePojo.fileName);
		System.out.println(file.exists());
		assertFalse(file.exists());
	}
	
	@Test
	public void testSaveDataNull() {
		pojoList = null ;
		serviceHelper.saveData(pojoList);
		File file  = new File(ImagePojo.fileName);
		assertFalse(file.exists());
	}
	
	@Test
	public void testLoadData() {
		pojoList = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		serviceHelper.saveData(pojoList);
		
		
		List<ImagePojo> resultList = Arrays.asList(pojo1, pojo2, pojo3, pojo4);
		File file  = new File(ImagePojo.fileName);
		if(file.exists()){
			resultList = serviceHelper.loadData();
		}
		
		assertTrue(pojoList.equals(resultList));
	}
	
	@Test
	public void testLoadDataUnsorted() {
		pojoList = Arrays.asList(pojo3, pojo4, pojo1, pojo2);
		serviceHelper.saveData(pojoList);
		
		
		List<ImagePojo> resultList = Arrays.asList(pojo3, pojo4, pojo1, pojo2);
		File file  = new File(ImagePojo.fileName);
		if(file.exists()){
			resultList = serviceHelper.loadData();
		}
		
		assertTrue(pojoList.equals(resultList));
	}
	
	@Test
	public void testLoadDataDublicate() {
		pojoList = Arrays.asList(pojo2, pojo1, pojo1, pojo2);
		serviceHelper.saveData(pojoList);
		
		
		List<ImagePojo> resultList = Arrays.asList(pojo2, pojo1, pojo1, pojo2);
		File file  = new File(ImagePojo.fileName);
		if(file.exists()){
			resultList = serviceHelper.loadData();
		}
		
		assertTrue(pojoList.equals(resultList));
	}
	
	@Test
	public void testLoadDataEmpty() {
		pojoList = new ArrayList<ImagePojo>();
		
		List<ImagePojo> resultList = new ArrayList<ImagePojo>();

		assertTrue(pojoList.equals(resultList));
	}
}
