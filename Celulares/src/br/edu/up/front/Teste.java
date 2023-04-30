package br.edu.up.front;

import br.edu.up.entidades.App;
import br.edu.up.entidades.Celular;
import br.edu.up.entidades.Fabricante;
import br.edu.up.entidades.Modelo;
import br.edu.up.persistencia.PersistenciaApp;
import br.edu.up.persistencia.PersistenciaCelular;
import br.edu.up.persistencia.PersistenciaFabricante;

public class Teste {
	
	public static void adicionarFabricantes () {
		// Primeiro exemplo
		Fabricante f1 = new Fabricante();
		f1.setNome("Apple");
		Modelo m1 = new Modelo();
		m1.setNomeModelo("iPhone 13 Pro");
		f1.getModelos().add(m1);
		Modelo m2 = new Modelo();
		m2.setNomeModelo("iPhone SE");
		f1.getModelos().add(m2);
		PersistenciaFabricante.adicionarFabricante(f1);

		// Segundo exemplo
		Fabricante f2 = new Fabricante();
		f2.setNome("Motorola");
		Modelo m3 = new Modelo();
		m3.setNomeModelo("Moto G100");
		f2.getModelos().add(m3);
		Modelo m4 = new Modelo();
		m4.setNomeModelo("Moto E7");
		f2.getModelos().add(m4);
		PersistenciaFabricante.adicionarFabricante(f2);
		
		// Terceiro exemplo
		Fabricante f3 = new Fabricante();
		f3.setNome("Samsung");
		Modelo m5 = new Modelo();
		m5.setNomeModelo("Galaxy S20");
		f3.getModelos().add(m1);
		Modelo m6 = new Modelo();
		m6.setNomeModelo("Galaxy A52");
		f3.getModelos().add(m2);
		PersistenciaFabricante.adicionarFabricante(f1);
	}

	public static void adicionarAppsALoja () {
		App app1 = new App();
		app1.setNome("Facebook");
		app1.setTamanho(0.3);
		app1.setIdAutomatico();
		PersistenciaApp.adicionarApp(app1);

		App app2 = new App();
		app2.setNome("Instagram");
		app2.setTamanho(0.25);
		app2.setIdAutomatico();
		PersistenciaApp.adicionarApp(app2);

		App app3 = new App();
		app3.setNome("WhatsApp");
		app3.setTamanho(0.05);
		app3.setIdAutomatico();
		PersistenciaApp.adicionarApp(app3);
	}
	
	public static void adicionarCelularesALoja () {
		//Primeiro exemplo
		Celular c1 = new Celular();
		c1.setMarca("Apple");
		c1.setModelo("iPhone 13 Pro");
		c1.setTamanhoTela(6.1);
		c1.setRam(6);
		c1.setArmazenamento(512);
		c1.setPreco(7999.99);
		PersistenciaCelular.adicionarCelular(c1);
		
		// Segundo exemplo
		Celular c2 = new Celular();
		c2.setMarca("Motorola");
		c2.setModelo("Moto G100");
		c2.setTamanhoTela(6.7);
		c2.setRam(8);
		c2.setArmazenamento(128);
		c2.setPreco(2699.00);
		PersistenciaCelular.adicionarCelular(c2);

		// Terceiro exemplo
		Celular c3 = new Celular();
		c3.setMarca("Motorola");
		c3.setModelo("Moto E7");
		c3.setTamanhoTela(6.5);
		c3.setRam(2);
		c3.setArmazenamento(32);
		c3.setPreco(849.00);
		PersistenciaCelular.adicionarCelular(c3);

		// Quarto exemplo
		Celular c4 = new Celular();
		c4.setMarca("Samsung");
		c4.setModelo("Galaxy S20");
		c4.setTamanhoTela(6.2);
		c4.setRam(8);
		c4.setArmazenamento(128);
		c4.setPreco(3499.00);
		PersistenciaCelular.adicionarCelular(c4);

		// Quinto exemplo
		Celular c5 = new Celular();
		c5.setMarca("Samsung");
		c5.setModelo("Galaxy A52");
		c5.setTamanhoTela(6.5);
		c5.setRam(6);
		c5.setArmazenamento(128);
		c5.setPreco(2499.00);
		PersistenciaCelular.adicionarCelular(c5);
	}
}