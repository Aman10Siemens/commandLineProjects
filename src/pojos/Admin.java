package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Admin")
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin {
	
	private int adminId;
	@NotNull(message="The Admin name must not be empty")
	@NotEmpty
	private String adminName;
	@NotNull(message="The Admin email must not be empty")
	@Email
	private String adminEmail;
	//@NotEmpty
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="wrong password it must be alphanumeric and contain one special character from #,@,*,$")  // remove \ from d if not working
	private String apassword;
	
	
	
	public Admin() {
		System.out.println("In Admin class Constuctor");
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	@Column(unique=true,length=50)
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	@Column(unique=true,length=50)
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	@Column(unique=true)
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail + "]";
	}
	
	
	

}
