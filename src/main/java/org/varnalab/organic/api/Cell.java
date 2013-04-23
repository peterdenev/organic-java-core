package org.varnalab.organic.api;

import java.util.Collection;

/*
 * var cluster = require('cluster');
 * var util = require("util");
 * var xtend = require("xtend");                                                                                                                                                                             
 */

public class Cell implements Organic {
	public interface CoreFactory {
		public Membrane createMembrane(Nucleus nucleus, Plasma plasma);
		public Nucleus createNucleus(DNA dna, Plasma plasma);
		public Plasma createPlasma();
	}
	
	public static class DefaultFactory implements CoreFactory {

		@Override
		public Membrane createMembrane(Nucleus nucleus, Plasma plasma) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Nucleus createNucleus(DNA dna, Plasma plasma) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Plasma createPlasma() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private Plasma plasma;
	private Nucleus nucleus;
	private Membrane membrane;
	private Collection<Organel> organelles;
	
	public Cell(DNA dna, CoreFactory core) {
		if (core == null) {
			core = new DefaultFactory();
		}
		plasma = core.createPlasma();
		nucleus = core.createNucleus(dna, plasma);
		membrane = core.createMembrane(nucleus, plasma);
		organelles = nucleus.createNamespace("plasma", this);
	}

	public Plasma getPlasma() {
		return plasma;
	}

	public Nucleus getNucleus() {
		return nucleus;
	}

	public Membrane getMembrane() {
		return membrane;
	}

	public Collection<Organel> getOrganelles() {
		return organelles;
	}
	
	//TODO: cluster.fork();
}