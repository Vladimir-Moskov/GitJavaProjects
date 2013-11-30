package main.java.images;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ImagePojoDao extends JdbcDaoSupport{

	public ImagePojoDao(){
		
	}

	public Boolean setUpTable(){
		String sql =  "CREATE TABLE IF NOT EXISTS javaDB.imagesTable ("+
				  "ID int(10) unsigned NOT NULL AUTO_INCREMENT,"+
				  "NAME varchar(100) NOT NULL,"+
				  "PATH varchar(100) NOT NULL,"+
				  "WIDTH smallint(5) unsigned NOT NULL,"+
				  "HEIGHT smallint(5) unsigned NOT NULL,"+
				  "PRIMARY KEY (ID)"+
				") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;";
		
		getJdbcTemplate().execute(sql);
		return true;
	}
	
	public Boolean clearTable(){
		String sql =  "DROP TABLE IF EXISTS javaDB.imagesTable;";
		
		getJdbcTemplate().execute(sql);
		return true;
	}
	
	public Boolean putData(){
		String sql = "INSERT INTO `javaDB`.`imagesTable` (`ID`,`NAME`,`PATH`, `WIDTH`, `HEIGHT`) VALUES"+
				 "(1,'image1', 'image1', 101, 101),"+
				 "(2,'image2', 'image2', 102, 102),"+
				 "(3,'image3', 'image3', 103, 103);";
		
		getJdbcTemplate().execute(sql);
		return true;
	}
	public List<ImagePojo> getAll(){
		String sql = "SELECT * FROM javaDB.imagesTable;";
		
		List<ImagePojo> imagesList = new ArrayList<ImagePojo>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		for (Map row : rows) {
			ImagePojo image = new ImagePojo();
			image.setId((Long)row.get("ID"));
			image.setName((String)row.get("NAME"));
			image.setPath((String)row.get("PATH"));
			image.setHeight((Integer)row.get("HEIGHT"));
			image.setWidth((Integer)row.get("WIDTH"));
			imagesList.add(image);
		}
		return imagesList;
	}
	
	public Boolean addImage(ImagePojo image){
		String sql = "INSERT INTO  javaDB.imagesTable" +
				"(ID, NAME, PATH, HEIGHT, WIDTH) VALUES (?, ?, ?, ?, ?);";

			
		getJdbcTemplate().update(sql, new Object[] { image.getId(),
				image.getName(), image.getPath(), image.getWidth(), image.getHeight()});
		
		return true;
	}
	
	public Boolean deleteImage(ImagePojo image){
		String sql = "DELETE FROM javaDB.imagesTable " +
		              "WHERE ID=? ;";
		
		getJdbcTemplate().update(sql, new Object[] { image.getId()});
		
		return true;
	}
	
	public Boolean updateImage(ImagePojo image){
		String sql = "UPDATE javaDB.imagesTable " +
				"SET NAME=?, PATH=?, WIDTH=?, HEIGHT=? "+
				"WHERE ID=? ;";

		Object[] params = new Object[] {image.getName(), image.getPath(), image.getWidth(), image.getHeight(),image.getId()};
		getJdbcTemplate().update(sql, params);
		
		return true;
	}
}
