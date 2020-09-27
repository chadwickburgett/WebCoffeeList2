package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beans")
public class beansList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ORIGIN")
	private String origin;
	@Column(name="ROAST")
	private String roast;
	
	public beansList() {
		super();
	}
	
	public beansList(String origin, String roast) {
		this.origin = origin;
		this.roast = roast;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getRoast() {
		return roast;
	}
	public void setRoast(String roast) {
		this.roast = roast;
	}
	
	public String returnBeansDetails() {
		return origin + ": " + roast;
	}
}
