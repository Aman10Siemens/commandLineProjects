package pojos;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order  {
	private static final long serialVersionUID = 1L;
	private int orderId;
	private Date orderDate;
	private double totalBill;
	private String ShippingAddress;
	private List<OrderDetail> orderdetails;
	private Customer customer;

	public Order() {
	}
	
	

   /* public Order(int orderId) {
		super();
		this.orderId = orderId;
	}
*/


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public double getTotalBill() {
		return this.totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	

	@Lob
	public String getShippingAddress() {
		return ShippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		ShippingAddress = shippingAddress;
	}


	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order",cascade=CascadeType.REMOVE)
	public List<OrderDetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<OrderDetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public OrderDetail addOrderdetail(OrderDetail orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setOrder(this);

		return orderdetail;
	}

	public OrderDetail removeOrderdetail(OrderDetail orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setOrder(null);

		return orderdetail;
	}


	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerId")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalBill=" + totalBill
				+ ", ShippingAddress=" + ShippingAddress + ", customer=" + customer + "]";
	}

	
	
}