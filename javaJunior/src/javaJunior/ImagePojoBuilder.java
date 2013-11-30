package javaJunior;

public class ImagePojoBuilder implements IMuttableImage{
	
	private String name;
	private String path;
	
	private int width;
	private int height;
	
	private int x;
	private int y;

	public ImagePojoBuilder(Builder builder){
		this.name = builder.name;
		this.path = builder.path;
		this.width = builder.width;
		this.height = builder.height;
		this.x = builder.x;
		this.y = builder.y;
	}
	
	public  ImagePojoBuilder(String name, String path){
		this.name = name;
		this.path = path;
	}
	
	public  ImagePojoBuilder(String name, String path, int width, int height){
		this.name = name;
		this.path = path;
		this.width = width;
		this.height = height;
	}
	
	public ImagePojoBuilder(String name, String path, int width, int height,
			int x, int y) {
		super();
		this.name = name;
		this.path = path;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImagePojoSimple [");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (path != null)
			builder.append("path=").append(path).append(", ");
		builder.append("width=").append(width)
			.append(", height=").append(height)
			.append(", x=").append(x)
			.append(", y=").append(y)
			.append(", getClass()=").append(getClass())
			.append(", hashCode()=").append(hashCode())
			.append(", toString()=").append(super.toString())
			.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + width;
		result = prime * result + height;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagePojoBuilder other = (ImagePojoBuilder) obj;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	public static class Builder {
		private String name;
		private String path;
		
		private int width;
		private int height;
		
		private int x;
		private int y;
		
		public Builder(String name, String path){
			this.name = name;
			this.path = path;
		}
		public Builder(String name, String path, int width, int height,
				int x, int y){
			this.name = name;
			this.path = path;
			this.width = width;
			this.height = height;
			this.x = x;
			this.y = y;
			
		}
		public ImagePojoBuilder build(){
			return new ImagePojoBuilder(this);
		}
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder path(String path) {
			this.name = path;
			return this;
		}
		
		public Builder x(int x) {
			this.x = x;
			return this;
		}
		
		public Builder y(int y) {
			this.y = y;
			return this;
		}
		
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		
		public Builder width(int width) {
			this.width = width;
			return this;
		}
	}
}
