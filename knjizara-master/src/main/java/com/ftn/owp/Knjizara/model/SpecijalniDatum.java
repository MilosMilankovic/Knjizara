package com.ftn.owp.Knjizara.model;

import java.util.Date;

public class SpecijalniDatum {
	private int id;
	public Date datum;
	public int popust;
	public SpecijalniDatum(int id, Date datum, int popust) {
		super();
		this.id = id;
		this.datum = datum;
		this.popust = popust;
	}
	
	public SpecijalniDatum(Date datum, int popust) {
		super();
		this.datum = datum;
		this.popust = popust;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getPopust() {
		return popust;
	}
	public void setPopust(int popust) {
		this.popust = popust;
	}
	
	

}
