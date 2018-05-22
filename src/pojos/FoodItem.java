package pojos;

//import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import pojos.OrderDetail;

import pojos.Vendor;

@Entity
@Table(name="fooditems")
@NamedQuery(name="FoodItem.findAll", query="SELECT f FROM FoodItem f")
public class FoodItem  {
	//private static final long serialVersionUID = 1L;
	private int foodid;
	private String fimage;
	private String foodCategory;
	private String foodType;
	private String foodname;
	private double price;
	private Vendor vendor;
	
	
	////
	private List<OrderDetail> orderdetails;
	///
	
	public FoodItem() {
	}

	public FoodItem(int foodid) {
		super();
		this.foodid = foodid;
	}

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFoodid() {
		return this.foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}


	public String getFimage() {
		return this.fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}


	@Column(name="food_category")
	public String getFoodCategory() {
		return this.foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}


	@Column(name="food_type")
	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public String getFoodname() {
		return this.foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}


	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="vendorid")
	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	////////////
	//bi-directional many-to-one association to OrderDetail
		@OneToMany(mappedBy="fooditem",cascade=CascadeType.REMOVE)
		public List<OrderDetail> getOrderdetails() {
			return this.orderdetails;
		}

		public void setOrderdetails(List<OrderDetail> orderdetails) {
			this.orderdetails = orderdetails;
		}

		public OrderDetail addOrderdetail(OrderDetail orderdetail) {
			getOrderdetails().add(orderdetail);
			orderdetail.setFooditem(this);

			return orderdetail;
		}

		public OrderDetail removeOrderdetail(OrderDetail orderdetail) {
			getOrderdetails().remove(orderdetail);
			orderdetail.setFooditem(null);

			return orderdetail;
		}

	
	/////////////////
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + foodid;
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
		FoodItem other = (FoodItem) obj;
		if (foodid != other.foodid)
			return false;
		return true;
	}
	
	
	

	

}