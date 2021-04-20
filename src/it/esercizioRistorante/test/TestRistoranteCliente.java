package it.esercizioRistorante.test;

import java.util.Date;

import it.esercizioRistorante.dao.EntityManagerUtil;
import it.esercizioRistorante.model.Cliente;
import it.esercizioRistorante.model.Ristorante;
import it.esercizioRistorante.service.MyServiceFactory;
import it.esercizioRistorante.service.cliente.IClienteService;
import it.esercizioRistorante.service.ristorante.IRistoranteService;

public class TestRistoranteCliente {

	public static void main(String[] args) {
		
		IClienteService clienteService = MyServiceFactory.getClienteServiceInstance();
		IRistoranteService ristoranteService = MyServiceFactory.getRistoranteServiceInstance();
		
		Cliente cliente = new Cliente("giacomo","mangelli",112D);
		Cliente cliente1 = new Cliente("givanni","lacro",12D);
		Cliente cliente2 = new Cliente("andrea","banni",1132D);
		Cliente cliente3 = new Cliente("laura","lolla",11222D);
		Date date = new Date();
		Ristorante ristorante = new Ristorante("pinocchio","via dei cenci, Roma", 3, date, 2);
		Ristorante ristorante2 = new Ristorante("i due furiosi","via mosca, milano", 1, date, 1);
		cliente.setRistorante(ristorante2);

		try {
			
		
/////////////////---------TEST CLIENTE------------/////////////////////////
		
//			System.out.println(clienteService.listAll());
////			
//			clienteService.inserisci(cliente);
//			System.out.println(clienteService.findById(cliente.getId()));
//
//			cliente.setCognome("prova");
//			clienteService.aggiorna(cliente);
//			System.out.println(clienteService.findById(cliente.getId()));
//			
//			System.out.println(clienteService.listAll());
//			clienteService.rimuovi(cliente);
//			System.out.println(clienteService.listAll());
//
//			
			
////////////////-------TEST RISTORANTE----------------/////////////////////
			
			
			
//			System.out.println(ristoranteService.listAll());
//			
//			ristoranteService.inserisci(ristorante);
//			System.out.println(ristoranteService.findById(ristorante.getId()));
//
//			ristorante.setNumeroStelle(2);
//			ristoranteService.aggiorna(ristorante);
//			System.out.println(ristoranteService.findById(ristorante.getId()));
//			
//			System.out.println(ristoranteService.listAll());
//			ristoranteService.rimuovi(ristorante);
//			
//			System.out.println(ristoranteService.listAll());
//			ristoranteService.inserisci(ristorante2);
//			System.out.println(ristoranteService.findById(ristorante2.getId()));
			
//			cliente1.setRistorante(ristorante2);
//			cliente2.setRistorante(ristorante2);
//			cliente3.setRistorante(ristorante2);
			
//			clienteService.inserisci(cliente1);
//			System.out.println(clienteService.findById(cliente2.getId()));
//			clienteService.inserisci(cliente2);
//			System.out.println(clienteService.findById(cliente3.getId()));
//			clienteService.inserisci(cliente3);
//			System.out.println(clienteService.findById(cliente3.getId()));
//
//			
//			
///////////////////////////////////////////////////////////////////////////
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			EntityManagerUtil.shutdown();
		}

	}

}
