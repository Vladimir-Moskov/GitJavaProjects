package mockitoTests;

import java.util.List;
import javaJunior.ImagePojoBuilder;

public class Service {

	private ServiceHelper serviceHelper;
	public Service(ServiceHelper serviceHelper){
		this.serviceHelper = serviceHelper;
	}
	
	public List<ImagePojoBuilder> innerJoin(List<ImagePojoBuilder> list1, 
										     List<ImagePojoBuilder> list2){
		
		List<ImagePojoBuilder> resultList = serviceHelper.innerJoin(list1, list2);
		resultList = serviceHelper.removeDuplicates(resultList);
		resultList = serviceHelper.sort(resultList);
		
		return resultList;
	}
}
