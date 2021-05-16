//Java Code Conventions  - https://www.oracle.com/technetwork/java/codeconventions-150003.pdf

package ro.ucv.inf.comp;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementeaza conceptul de Gramatica G = (N,Σ,S,P)
 * <ul>
 * <li>N - este un alfabet ale cărui elemente se numesc neterminale şi se notează cu litere mari</li> 
 * <li>Σ - este un alfabet ale cărui elemente se numesc terminale şi se notează cu litere mici </li>
 * <li>S - Simbolul initial</li>
 * <li>P- Multimea regulilor de productie</li>
 * </ul>
 * @author Radu Madalina
 *
 */
public class Gramatica {

	/**
	 * Multimea neterminalelor
	 */
	private Set<String> neterminale;
	/**
	 * Multimea terminalelor
	 */
	private Set<String> terminale;
	/**
	 * Simbolul initial
	 */
	private String simbolulInitial;
	/**
	 * Multimea regulilor de productie
	 */
	private Set<Productie> productii;

	/**
	 * Construieste o gramatica
	 * 
	 * @param neterminale Multimea neterminalelor
	 * @param terminale   Multimea terminalelor
	 * @param simbolul    Initial Simbolul initial al Gramaticii
	 * @param productii   Multimea regulilor de productie
	 */
	public Gramatica(Set<String> neterminale, Set<String> terminale, String simbolulInitial, Set<Productie> productii) {
		super();
		this.neterminale = neterminale;
		this.terminale = terminale;
		this.simbolulInitial = simbolulInitial;
		this.productii = productii;
	}

	/**
	 * Construieste o gramatica
	 * 
	 * @param neterminale Multimea neterminalelor
	 * @param terminale   Multimea terminalelor
	 * @param simbolul    Initial Simbolul initial al Gramaticii
	 */
	public Gramatica(String neterminale[], String terminale[], String simbolulInitial) {
		this.neterminale = new LinkedHashSet<String>();
		this.terminale = new LinkedHashSet<String>();
		this.simbolulInitial = simbolulInitial;
		this.productii = new LinkedHashSet<Productie>();
		for (String simbol : terminale) {
			this.terminale.add(simbol);
		}
		for (String simbol : neterminale) {
			this.neterminale.add(simbol);
		}
	}

	/**
	 * Returneaza multimea neterminalelor gramaticii
	 * 
	 * @return multimea neterminalelor gramaticii
	 */
	public Set<String> getNeterminale() {
		return neterminale;
	}

	/**
	 * Seteaza multimea neterminalelor
	 * 
	 * @param neterminale Noua valoare pentru multimea neterminalelor
	 */
	public void setNeterminale(Set<String> neterminale) {
		this.neterminale = neterminale;
	}

	/**
	 * Returneaza multimea terminalelor gramaticii
	 * 
	 * @return multimea terminalelor gramaticii
	 */
	public Set<String> getTerminale() {
		return terminale;
	}

	/**
	 * Seteaza multimea terminalelor
	 * 
	 * @param terminale Noua valoare pentru multimea terminalelor
	 */
	public void setTerminale(Set<String> terminale) {
		this.terminale = terminale;
	}

	/**
	 * Returneaza Simbolul initial
	 * 
	 * @return simbolul initial
	 */
	public String getSimbolulInitial() {
		return simbolulInitial;
	}

	/**
	 * Seteaza valoarea Simbolului initial
	 * 
	 * @param simbolulInitial Noua valoare a simbolului initial
	 */
	public void setSimbolulInitial(String simbolulInitial) {
		this.simbolulInitial = simbolulInitial;
	}

	/**
	 * Returneaza regulile de productie
	 * 
	 * @return multimea regulilor de productie
	 */
	public Set<Productie> getProductii() {
		return productii;
	}

	/**
	 * Seteaza regulile de productie
	 * 
	 * @param productii multimea regulilor de productie
	 */
	public void setProductii(Set<Productie> productii) {
		this.productii = productii;
	}

	/**
	 * Adaugam o productie noua la gramatica
	 * 
	 * @param productie productia ce se adauga
	 */
	public void adaugaProductie(Productie productie) {
		productii.add(productie);
	}

	/**
	 * Adaugam o productie noua la gramatica
	 * 
	 * @param parteaStanga  partea stanga a productiei ce se adauga
	 * @param parteaDreapta partea drepta a productie ce se adauga
	 */
	public void adaugaProductie(String parteaStanga, String parteaDreapta) {
		productii.add(new Productie(parteaStanga, parteaDreapta));
	}

	/**
	 * Verifica daca un simbol este terminal
	 * 
	 * @param c simbolul care se verifica
	 * @return true daca este simbolul este terminal, false altfel
	 */
	public boolean isTerminal(String c) {
		return terminale.contains(c);

	}

	/**
	 * Verifica daca un simbol este neterminal
	 * 
	 * @param c simbolul care se verifica
	 * @return true daca este simbolul este neterminal, false altfel
	 */
	public boolean isNeterminal(String c) {
		return neterminale.contains(c);
	}

	/**
	 * Returneaza reprezentarea sub forma de String a obiectului
	 * 
	 * @return reprezentarea sub forma de String a obiectului
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Neterminale = " + neterminale + "\n");
		sb.append("Terminale = " + terminale + "\n");
		sb.append("Simbolul initial = " + simbolulInitial + "\n");
		int i = 1;
		for (Productie productie : productii) {
			sb.append(i + ")" + productie + "\n");
			i++;
		}
		return sb.toString();
	}

}
