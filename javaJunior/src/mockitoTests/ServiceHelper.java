package mockitoTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javaJunior.ImagePojoBuilder;

public class ServiceHelper {
	
	//with dublicates
	public List<ImagePojoBuilder> innerJoin(List<ImagePojoBuilder> list1, 
		     								List<ImagePojoBuilder> list2){

		List<ImagePojoBuilder> resultList = new ArrayList<ImagePojoBuilder>();
		if(list1 != null && list2 != null){
			for(ImagePojoBuilder element: list1){
				if(list2.contains(element))
					resultList.add(element);
			}
		}
		return resultList;
		
	}
	
	public List<ImagePojoBuilder> removeDuplicates(List<ImagePojoBuilder> list){
		Set<ImagePojoBuilder> hash;
		hash = list != null ? new HashSet<ImagePojoBuilder>(list) : new HashSet<ImagePojoBuilder>();

		List<ImagePojoBuilder> resultList = new ArrayList<ImagePojoBuilder>(hash);
		return resultList;
	}
	
	public List<ImagePojoBuilder> sort(List<ImagePojoBuilder> list){
		List<ImagePojoBuilder> resultList;
		resultList = list != null ? new ArrayList<ImagePojoBuilder>(list) : new ArrayList<ImagePojoBuilder>();

		Collections.sort(resultList, new PojoComparator());
		
		return resultList;
	}
	
}
