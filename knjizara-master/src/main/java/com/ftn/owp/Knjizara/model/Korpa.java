package com.ftn.owp.Knjizara.model;

import java.util.ArrayList;
import java.util.List;

public class Korpa {
	private List<KnjigaIKolicina> knjigeIKolicine;

	public Korpa() {
		super();
		this.knjigeIKolicine = new ArrayList<KnjigaIKolicina>();
	}
	public void dodaj(KnjigaIKolicina knjigaIKolicina) {
		knjigeIKolicine.add(knjigaIKolicina);
	}
	public void ukloni(int id) {
		KnjigaIKolicina nadjenaKnjigaIKolicina = null;
		for(KnjigaIKolicina knjigaIKolicina : knjigeIKolicine) {
			if (knjigaIKolicina.getKnjiga().getId() == id) {
				nadjenaKnjigaIKolicina = knjigaIKolicina;
				break;
			}
		}
		knjigeIKolicine.remove(nadjenaKnjigaIKolicina);
	}
	public List<KnjigaIKolicina> getKnjigeIKolicine() {
		return knjigeIKolicine;
	}
	public void setKnjigeIKolicine(List<KnjigaIKolicina> knjigeIKolicine) {
		this.knjigeIKolicine = knjigeIKolicine;
	}
	public double ukupnaVrednost() {
		double vrednost = 0;
		for(KnjigaIKolicina knjigaIKolicina : knjigeIKolicine) {
			vrednost += knjigaIKolicina.getKnjiga().getCena() * knjigaIKolicina.getKolicina();
		}
		return vrednost;
	}
	public boolean punaKorpa() {
		return knjigeIKolicine.size() > 0;
	}
	
	
	

}
