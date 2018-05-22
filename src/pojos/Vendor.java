package pojos;

//import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Entity
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor  {
	//private static final long serialVersionUID = 1L;
	private int vendorid;
	@NotEmpty
	@NotNull
	private String city;
	@NotEmpty
	@NotNull
	private String restaurantName;
	@NotEmpty
	@NotNull
	private String vaddress;

	@NotNull
	private long vcontactNo;
	private String vendorEmail;
	//@NotNull
	//@NotEmpty
	private String vimage;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="wrong password it must be alphanumeric and contain one special character from #,@,*,$")
	@NotNull
	@NotEmpty
	private String vpassword;
	private List<FoodItem> fooditems;

	public Vendor() {
		System.out.println("This is Vendor default constructor");
	}

	
	

	public Vendor(int vendorid) {
		super();
		this.vendorid = vendorid;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getVendorid() {
		return this.vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(name="restaurant_name")
	public String getRestaurantName() {
		return this.restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	@Lob
	public String getVaddress() {
		return this.vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}


	@Column(name="vcontact_no")
	public long getVcontactNo() {
		return this.vcontactNo;
	}

	public void setVcontactNo(long vcontactNo) {
		this.vcontactNo = vcontactNo;
	}


	@Column(name="vendor_email")
	public String getVendorEmail() {
		return this.vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}


	public String getVimage() {
		return this.vimage;
	}

	public void setVimage(String vimage) {
		this.vimage = vimage;
	}

	public String getVpassword() {
		return vpassword;
	}
	
	
	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}

	

	//bi-directional many-to-one association to FoodItem
	@OneToMany(mappedBy="vendor",cascade=CascadeType.REMOVE)
	public List<FoodItem> getFooditems() {
		return this.fooditems;
	}

	public void setFooditems(List<FoodItem> fooditems) {
		this.fooditems = fooditems;
	}

	public FoodItem addFooditem(FoodItem fooditem) {
		getFooditems().add(fooditem);
		fooditem.setVendor(this);

		return fooditem;
	}

	public FoodItem removeFooditem(FoodItem fooditem) {
		getFooditems().remove(fooditem);
		fooditem.setVendor(null);

		return fooditem;
	}





	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", city=" + city + ", restaurantName=" + restaurantName + ", vaddress="
				+ vaddress + ", vcontactNo=" + vcontactNo + ", vendorEmail=" + vendorEmail + "]";
	}
	
	

}