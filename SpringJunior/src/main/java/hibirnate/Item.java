package main.java.hibirnate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.*;

@Entity
@Table(name = "Item", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Item implements Serializable {
	

	private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name="ID")
	    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
	    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "oreder_seq")
	    private long id;
	    
	    @Column(name="NAME", unique = true, nullable = false, length = 100)
	    private String name;
	   
	    @Column(name="DESCRIPTION",unique = false, nullable = false, length = 100)
	    private String description;
	  
	    @Column(name="PRICE",unique = false, nullable = false, length = 100)
	    private double price;
	    
	    @ManyToOne(fetch = FetchType.LAZY,optional=true)
	    @JoinTable(name = "ORDER", joinColumns = @JoinColumn(name = "ID_ITEM"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENT"))
	    private Client client;

	    public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    @Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result
  				+ ((description == null) ? 0 : description.hashCode());
  		result = prime * result + (int) (id ^ (id >>> 32));
  		result = prime * result + ((name == null) ? 0 : name.hashCode());
  		long temp;
  		temp = Double.doubleToLongBits(price);
  		result = prime * result + (int) (temp ^ (temp >>> 32));
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
  		Item other = (Item) obj;
  		if (description == null) {
  			if (other.description != null)
  				return false;
  		} else if (!description.equals(other.description))
  			return false;
  		if (id != other.id)
  			return false;
  		if (name == null) {
  			if (other.name != null)
  				return false;
  		} else if (!name.equals(other.name))
  			return false;
  		if (Double.doubleToLongBits(price) != Double
  				.doubleToLongBits(other.price))
  			return false;
  		return true;
  	}
}
