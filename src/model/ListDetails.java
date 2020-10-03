package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="TRIP_DATE")
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="SHOPPER_ID")
	private Shopper shopper;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="beans_on_list",
	      joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
	      inverseJoinColumns={ @JoinColumn(name="BEAN_ID", referencedColumnName="ID", unique=true) }
	  )
    private List<beansList> listOfBeans;

	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, Shopper shopper, List<beansList> listOfBeans) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfBeans = listOfBeans;
	}

	public ListDetails(String listName, LocalDate tripDate, Shopper shopper, List<beansList> listOfBeans) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
		this.listOfBeans = listOfBeans;
	}

	public ListDetails(String listName, LocalDate tripDate, Shopper shopper) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.shopper = shopper;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getTripDate() {
		return tripDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	public Shopper getShopper() {
		return shopper;
	}
	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}


	public List<beansList> getListOfBeans() {
		return listOfBeans;
	}


	public void setListOfBeans(List<beansList> listOfBeans) {
		this.listOfBeans = listOfBeans;
	}

	@Override
	public String toString() {
		return "BeansListDetails [id=" + id + ", ListName=" + listName + ", tripDate=" + tripDate + ", shopper="
				+ shopper + ", listOfBeans=" + listOfBeans + "]";
	}
	
}