package lt.bit.data;

public class Address {
	
	private static int nextId = 0;
	private Integer id;
	private String address;
	private String city;
	private String postalCode;
	
	public void createId () {
		this.id = ++nextId;
	}
	
	public Address() {
		super();
	}
	
	public Address(String address, String city, String postalCode) {
		super();
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	public Integer getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + "]";
	}
	
	
	
}
