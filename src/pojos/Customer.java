package pojos;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import pojos.Order;


@Entity
@Table(name="Customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer {
	
	private int customerId;
	@NotNull(message="The Customer name must not be empty")
	@NotEmpty
	private String customerName;
	@NotNull(message="The Customer email must not be empty")
	@Email
	private String customerEmail;
	@NotEmpty
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="wrong password it must be alphanumeric and contain one special character from #,@,*,$")  // remove \ from d if not working
	private String password;
	@NotNull
	//@Pattern(regexp="^(\\d{10})$")
	private long contactNumber;
	@NotNull(message="The Customer Address must not be empty")
	@NotEmpty
	private String customerAddress;
	
	///
	private List<Order> orders;
	///
	
	public Customer() {
		System.out.println("This is default ctor of customer");
	}

	/*public Customer(String customerName, String customerEmail, String password, long contactNumber,
			String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.password = password;
		this.contactNumber = contactNumber;
		this.customerAddress = customerAddress;
	}*/

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCustomerId() {
		return customerId;
	}
	
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
	@Column(unique=true,length=50)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(unique=true,length=50)
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Column(unique=true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	@Column(length=50)
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	//paramterised ctor
	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", contactNumber=" + contactNumber + ", customerAddress="
				+ customerAddress + "]";
	}
	

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer",cascade=CascadeType.REMOVE)
	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}


}
