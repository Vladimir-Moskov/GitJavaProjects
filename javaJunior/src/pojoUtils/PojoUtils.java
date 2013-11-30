package pojoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javaJunior.ImagePojoBuilder;

public class PojoUtils {
	
	public List<ImagePojoBuilder> merge(List<ImagePojoBuilder> pojoList1, 
										List<ImagePojoBuilder> pojoList2){
		
		List<ImagePojoBuilder> combinedList = new ArrayList<ImagePojoBuilder>();
		
		if(pojoList1 != null){
			combinedList.addAll(pojoList1);
		}
		if(pojoList2 != null){
			combinedList.addAll(pojoList2);
		}
		
		Set<ImagePojoBuilder> combinedHash = new HashSet<ImagePojoBuilder>(combinedList);
		
		List<ImagePojoBuilder> resultList = new ArrayList<ImagePojoBuilder>(combinedHash);
		Collections.sort(resultList, new PojoComparator());
		
		return resultList;
	}

}
