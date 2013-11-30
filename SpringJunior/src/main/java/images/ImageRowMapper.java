package main.java.images;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ImageRowMapper implements RowMapper {
	 

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImagePojo image = new ImagePojo();
		image.setName(rs.getString("NAME"));
		image.setPath(rs.getString("PATH"));
		image.setHeight(rs.getInt("HEIGHT"));
		image.setWidth(rs.getInt("WIDTH"));

		return image;
	}

}
