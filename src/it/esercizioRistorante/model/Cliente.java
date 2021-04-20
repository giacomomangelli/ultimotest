package it.esercizioRistorante.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "disponibilita")
	private Double disponibilita;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_ristorante")
	private Ristorante ristorante;

	
	public Cliente() {	
	}
		
	public Cliente(String nome, String cognome, Double disponibilita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.disponibilita = disponibilita;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Double getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(Double disponibilita) {
		this.disponibilita = disponibilita;
	}
	public Ristorante getRistorante() {
		return ristorante;
	}
	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", disponibilita=" + disponibilita
				+ "]";
	}


	
	
}
