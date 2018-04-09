package br.zxventures.restzx.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class PDVApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public PDVApplication() {
		singletons.add(new PDVService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
