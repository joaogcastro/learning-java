package br.edu.up.persistencia;

import java.util.ArrayList;
import br.edu.up.entidades.App;
import br.edu.up.entidades.Celular;

public class PersistenciaApp {
	
	private static ArrayList<App> appStore = new ArrayList<>();
	
	public static ArrayList<App> getAppStore() {
		return appStore;
	}

	public static void adicionarApp (App app) {
		appStore.add(app);
	}
	
	public static boolean verificarAppCadastrado (App app) {
		for(App item: appStore) {
			if(item.getNome().equals(app.getNome())) {
				return true;
			}
		}
		return false;
	}
	
	public static App retornarApp (App app) {
		for(App item: appStore) {
			if(item.getId()==app.getId()) {
				return item;
			}
		}
		return null;
	}
	
	public static void exibirApps () {
		for(App item: appStore) {
			System.out.println("Id: "+item.getId()+"   App: "+item.getNome()+"   Tamanho: "+item.getTamanho()+"Gb");
		}
	}
	
	public static String baixarApp (App app,Celular celular) {
		if(retornarApp(app)!=null) {
			celular.getAplicativos().add(app);
			celular.setOcupado(celular.getOcupado()+app.getTamanho());
			return "App "+app.getNome()+" baixado com sucesso!";
		}else {
			return "Este id não corresponde a nenhum app.";
		}
	}
	
	public static void exibirAppsInstalados (Celular celular) {
		for(App item: celular.getAplicativos()) {
			System.out.println("Id: "+item.getId()+"   App: "+item.getNome()+"   Tamanho: "+item.getTamanho()+"Gb");
		}
	}
	
	public static String excluirApp(App app, Celular celular) {
	    boolean encontrado = false;
	    for (App item : celular.getAplicativos()) {
	        if (item.getId() == app.getId()) {
	            celular.setOcupado(celular.getOcupado() - item.getTamanho());
	            encontrado = true;
	            celular.getAplicativos().remove(item);
	            break;
	        }
	    }
	    if (encontrado) {
	        return "App "+app.getNome()+" removido com sucesso!";
	    } else {
	        return "Este id não corresponde a nenhum app no celular.";
	    }
	}

	public static App retornarAppInstalado (Celular celular, App app) {
		for(App item: celular.getAplicativos()) {
			if(item.getId()==app.getId()) {
				return item;
			}
		}
		return null;
	}
	
}