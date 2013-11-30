package main.java.hibirnate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

@Entity
@Table(name = "CLIENT", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Client  implements Serializable {
	private static final long serialVersionUID = 1L;
	 

    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "order_seq")
	  private long id;
	  
	  @Column(name = "NAME", unique = false, nullable = false, length = 100)
	  private String name;
	 
	  @Column(name = "EMAIL", unique = false, nullable = true, length = 100)
	  private String mail;
	  
	  @Column(name = "PHONE", unique = false, nullable = true, length = 100)
	  private String phone;
	 
	  @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	  private Set<Item> itemList = new HashSet<Item>();
	  
	public void setItemList(Set orders) {
		this.itemList = itemList;
	}
	
	public Set getItemList() {
		return itemList;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=");
		builder.append(id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (mail != null) {
			builder.append("mail=");
			builder.append(mail);
			builder.append(", ");
		}
		if (phone != null) {
			builder.append("phone=");
			builder.append(phone);
		}
		builder.append("]");
		return builder.toString();
	}

}
