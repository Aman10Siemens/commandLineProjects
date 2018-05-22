package pojos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="orderdetails")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail  {
	private static final long serialVersionUID = 1L;
	private int detailsId;
	private int quantity;
	private FoodItem fooditem;
	private Order order;

	public OrderDetail() {
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDetailsId() {
		return this.detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}


	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="foodId")
	public FoodItem getFooditem() {
		return this.fooditem;
	}

	public void setFooditem(FoodItem fooditem) {
		this.fooditem = fooditem;
	}


	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderId")
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}