package fr.afpa.model;

import java.util.List;

import java.util.List;

public class Acteur{
    private String name;
private String lastName;
private String age;
private List<Film> listFilm;

	public Acteur(String name, String lastName, String age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    };

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<Film> getListFilm() {
		return this.listFilm;
	}

	public void setListFilm(List<Film> listFilm) {
		this.listFilm = listFilm;
	}



}
