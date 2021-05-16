//Java Code Conventions  - https://www.oracle.com/technetwork/java/codeconventions-150003.pdf

package ro.ucv.inf.comp;

/**
 * Implementeaza conceptul de productie a unei gramatici formale: parteaStanga
 * -> parteaDrepta
 * 
 * @author Radu Madalina
 *
 */
public class Productie {

	/**
	 * Partea stanga a productiei
	 */
	private String parteaStanga;
	/**
	 * Partea dreapta a productiei
	 */
	private String parteaDreapta;

	/**
	 * Construieste o productie.
	 * 
	 * @param parteaStanga  Partea stanga a productiei
	 * @param parteaDreapta Partea dreapta a productiei
	 */
	public Productie(String parteaStanga, String parteaDreapta) {
		this.parteaStanga = parteaStanga;
		this.parteaDreapta = parteaDreapta;
	}

	/**
	 * Returneaza partea stanga a productiei
	 * 
	 * @return Partea stanga a productiei
	 */
	public String getParteaStanga() {
		return parteaStanga;
	}

	/**
	 * Seteaza partea stanga a productiei
	 * 
	 * @param parteaStanga Noua valoare pentru partea stanga
	 */
	public void setParteaStanga(String parteaStanga) {
		this.parteaStanga = parteaStanga;
	}

	/**
	 * Returneaza partea dreapta a productiei
	 * 
	 * @return Partea dreapta a productiei
	 */
	public String getParteaDreapta() {
		return parteaDreapta;
	}

	/**
	 * Seteaza partea dreapta a productiei
	 * 
	 * @param parteaDreapta Noua valoare a partii drepte
	 */
	public void setParteaDreapta(String parteaDreapta) {
		this.parteaDreapta = parteaDreapta;
	}

	/**
	 * Returneaza reprezentarea sub forma de String a obiectului
	 * 
	 * @return reprezentarea sub forma de String a obiectului
	 */
	@Override
	public String toString() {
		return "[" + parteaStanga + " -> " + (parteaDreapta.isEmpty() ? "epsilon" : parteaDreapta) + "]";
	}

	/**
	 * Testeaza egalitatea a doua obiecte
	 * 
	 * @return true daca obiectele sunt egale, false altfel
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productie p = (Productie) obj;
		if (parteaDreapta == null) {
			if (p.parteaDreapta != null)
				return false;
		} else if (!parteaDreapta.equals(p.parteaDreapta))
			return false;
		if (parteaStanga == null) {
			if (p.parteaStanga != null)
				return false;
		} else if (!parteaStanga.equals(p.parteaStanga))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Productie p1 = new Productie("A", "C");
		Productie p2 = new Productie("A", "C");

		System.out.println(p1.equals(p2));
	}

}
