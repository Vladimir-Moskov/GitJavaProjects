package pojoUtils;

import java.util.Comparator;
import javaJunior.ImagePojoBuilder;

public class PojoComparator implements Comparator<ImagePojoBuilder > {

    @Override
    public int compare(ImagePojoBuilder o1, ImagePojoBuilder o2) {
        String string1 = o1.getName().toLowerCase();
        String string2 = o2.getName().toLowerCase();
    	
    	return string1.compareTo(string2);
    }
}
