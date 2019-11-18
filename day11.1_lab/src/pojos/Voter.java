package pojos;
import javax.persistence.*;
@Entity
@Table(name="voters")
public class Voter {
	private Integer id;
	private String email,pass;
	private String status;
	private String role;
	public Voter() {
		System.out.println("in voter constr");
	}
	public Voter(Integer id, String email, String pass, String status) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 30,unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password",length = 20)
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name="status",length=10)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(length = 20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", email=" + email + ", status=" + status + "]";
	}
	
	public boolean statusIsVoted()
	{
		return status.equals("YES");
	}
	

}
