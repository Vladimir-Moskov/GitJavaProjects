package main.java.hibirnate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private long orderId;
	 private long clientId;
	 private Set items = new HashSet();

	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public long getClientId() {
		return clientId;
	}


	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (clientId ^ (clientId >>> 32));
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=");
		builder.append(orderId);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append("]");
		return builder.toString();
	}
	

}
