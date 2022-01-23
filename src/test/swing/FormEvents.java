package test.swing;

import java.awt.event.ActionListener;
import java.util.EventObject;

public class FormEvents extends EventObject {
	
	private String name;
	private String occupation;
	private int ageCat;
	private String empCat;
	private String taxId;
	private boolean isSeniorCitizen;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public FormEvents(Object source) {
		super(source);
		
	}
	
	public FormEvents(Object source,String name,String occupation,int ageCat,
			String emp, String taxString, boolean isSenior,String gender) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.ageCat = ageCat;
		this.empCat = emp;
		this.taxId = taxString;
		this.isSeniorCitizen = isSenior;
		this.gender = gender;
		
	}

	

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public boolean isSeniorCitizen() {
		return isSeniorCitizen;
	}

	public void setSeniorCitizen(boolean isSeniorCitizen) {
		this.isSeniorCitizen = isSeniorCitizen;
	}

	public String getEmpCat() {
		return empCat;
	}

	public void setEmpCat(String emp) {
		this.empCat = emp;
	}

	public int getAgeCat() {
		return ageCat;
	}

	public void setAgeCat(int ageCat) {
		this.ageCat = ageCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	
	
}
