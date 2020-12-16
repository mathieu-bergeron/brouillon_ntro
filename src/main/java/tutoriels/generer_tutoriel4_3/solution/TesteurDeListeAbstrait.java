package tutoriels.generer_tutoriel4_3.solution;

import java.util.List;
import java.util.Random;

import tutoriels.tutoriel4_3.TesteurDeListe;

public abstract class TesteurDeListeAbstrait implements TesteurDeListe {
	
	private static Random alea = new Random();

	@Override
	public void fairePlusieursAjouts(List<Integer> liste, int nombreOperations) {
		for(int i = 0; i < nombreOperations; i++) {
			liste.add(1);
		}
	}

	@Override
	public void fairePlusieursInsertionsAuDebut(List<Integer> liste, int nombreOperations) {
		for(int i = 0; i < nombreOperations; i++) {
			liste.add(0, 1);
		}
	}

	@Override
	public void fairePlusieursInsertionsAleatoires(List<Integer> liste, int nombreOperations) {
		liste.add(0, 1);

		for(int i = 1; i < nombreOperations; i++) {
			liste.add(alea.nextInt(liste.size()), 1);
		}
	}

	
	@Override
	public void fairePlusieursModificationsAleatoires(List<Integer> liste, int nombreOperations) {
		for(int i = 0; i < nombreOperations; i++) {
			liste.set(alea.nextInt(liste.size()),0);
		}
	}

	@Override
	public void fairePlusieursRetraitsAleatoires(List<Integer> liste, int nombreOperations) {
		for(int i = 0; i < nombreOperations; i++) {
			liste.remove(alea.nextInt(liste.size()));
		}
	}

	@Override
	public void fairePlusieursRetraitsAuDebut(List<Integer> liste, int nombreOperations) {
		for(int i = 0; i < nombreOperations; i++) {
			liste.remove(0);
		}
	}

}
