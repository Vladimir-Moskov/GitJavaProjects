package serealization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerealizationService {
	
	public void saveData(List<ImagePojo> pojoList) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		if(pojoList != null && pojoList.size() > 0){
			try {
				fos = new FileOutputStream(ImagePojo.fileName);
				oos = new ObjectOutputStream(fos);
				try{
					for(ImagePojo element: pojoList){
						oos.writeObject(element);
					}
				}
				catch (IOException e) {
					
				}
				finally{
					oos.flush();
					oos.close();
				}
			}
			catch(IOException ioE){
					return;
			}
		}
	}
	
	public List<ImagePojo> loadData( ) {
		
		List<ImagePojo> resultList = new ArrayList<ImagePojo>();
		FileInputStream fis;
		ObjectInputStream oin;
		try{
			fis = new FileInputStream(ImagePojo.fileName);
			oin = new ObjectInputStream(fis);
			try{
				while(true){
					resultList.add((ImagePojo) oin.readObject());
				}
			}	
			catch(IOException ioE){
			} 
			catch(ClassNotFoundException cnfE){
			}
			finally {
				oin.close();
			}
		}
		catch(IOException ioE){
			return resultList;
		}
		
		return resultList;
	}
}
