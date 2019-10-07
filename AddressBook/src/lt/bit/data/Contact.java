package lt.bit.data;

public class Contact {
	
	private static int nextId = 0;
	private Integer id;
	private String type;
	private String contact;
	
	public void createId () {
		this.id = ++nextId;
	}
	
	public Contact() {
		super();
	}

	public Contact(String type, String contact) {
		super();
		this.type = type;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getContact() {
		return contact;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", type=" + type + ", contact=" + contact + "]";
	}
	
	
	
}
