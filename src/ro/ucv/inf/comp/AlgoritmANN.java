
//Java Code Conventions  - https://www.oracle.com/technetwork/java/codeconventions-150003.pdf

package ro.ucv.inf.comp;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementeaza algoritmul pentru determinarea simbolurilor anulabile ale unei gramatici
 * 
 * @author Radu Madalina
 *
 */
/**
 * 
 * Algoritmul ANN
 *Intrare: gramatica G = (N,Σ,P,S ) independentă de context
 *Ieşire: mulţimea N ann a simbolurilor anulabile
 *Metoda:
 *P1. { ( ) } 0 0 M = A∈ N / ∃ A→ε ∈ P , i :=
 *P2. Ni = Ni ∪{A∈N / ∃ ∈Ni∗ (A→ )∈P}
 *+1 α astfel încât α
 *P3. Dacă Ni+1 ≠ Ni atunci i := i +1 şi mergi la P2.
 *P4. , STOP.
 *
 */
public class AlgoritmANN {

	/**
	 * Gramatica careia i se aplica algoritmul
	 */
	private Gramatica gramatica;

	/**
	 * Constructor cu parametri
	 * @param gramatica gramatica pe care se aplica algoritmul
	 */
	public AlgoritmANN(Gramatica gramatica) {
		this.gramatica = gramatica;
	}

	/**
	 * Determina multimea N0 din algoritmul ANN 
	 * @return multimea simbolurilor care produc Epsilon
	 */
	public Set<String> determinaN0() {
		Set<String> N0 = new LinkedHashSet<String>();
		for (Productie productie : gramatica.getProductii()) {
			String alfa = productie.getParteaDreapta();
			if (alfa.isEmpty()) {				
				System.out.println("Productia implicata:" + productie);
				N0.add(productie.getParteaStanga());
			}
		}
		return N0;
	}

	/**
	 * Determina multimea NiPlus1 din algoritmul ANN 
	 * @return multimea simbolurilor care produc Epsilon la pasul i+1
	 * @param Ni multimea simbolurilor care produc Epsilon la pasul i
	 * @return multimea simbolurilor din algoritmul ANN care produc Epsilon la pasul i+1
	 */
	public Set<String> determinaNiPlus1(Set<String> Ni) {
		Set<String> NiPlus1 = new LinkedHashSet<String>();

		NiPlus1.addAll(Ni);
		for (Productie productie : gramatica.getProductii()) {
			String alfa = productie.getParteaDreapta();
			boolean verifica = true;
			for (int i = 0; i < alfa.length(); i++) {
				String simbol = alfa.charAt(i) + "";
				if ( !Ni.contains(simbol)) {
					verifica = false;
					break;
				}
			}
			if (verifica && !NiPlus1.contains(productie.getParteaStanga())) {
				System.out.println("Elimin "+ productie.getParteaStanga() +". Productia implicata:" + productie);
				NiPlus1.add(productie.getParteaStanga());
			}
		}
		return NiPlus1;
	}

	

	/**
	 * Calculeaza multimea simbolurilor anulabile conform algoritmului ANN
	 * @param debug flag care afiseaza informatii de debug daca este true
	 * @return multimea simbolurilor anulabile
	 */
	public Set<String> calculeazaSimboluriAnulabile(boolean debug) {

		Set<String> Ni = determinaN0();

		int i = 0;
		while (true) {
			if (debug) {
				System.out.println("N" + i + "=" + Ni);
			}
			Set<String> NiPlus1 = determinaNiPlus1(Ni);

			if (NiPlus1.size() == Ni.size()) {
				break;
			}
			Ni = NiPlus1;

			i++;
		}

		return Ni;
	}

	
	public static void main(String[] args) {

		String simbolulInitial = "S";

		String neterminale[] = { "S", "A", "B", "C" };
		String terminale[] = { "a", "b"};

		Gramatica g = new Gramatica(neterminale, terminale, simbolulInitial);

		g.adaugaProductie("S", "ABC"); 
		g.adaugaProductie("S", "AA"); // S ->AA
		g.adaugaProductie("S", "BC"); // S ->BC
		g.adaugaProductie("S", "AC"); // S ->AC

		g.adaugaProductie("A", "aA");
		g.adaugaProductie("A", "BC");
		
		g.adaugaProductie("B", "aCA");
		g.adaugaProductie("B", "CC");
		
		g.adaugaProductie("C", "");
		g.adaugaProductie("C", "ab");
		System.out.println(g);
		AlgoritmANN alg = new AlgoritmANN(g);

		Set<String> simboluriAnulabile = alg.calculeazaSimboluriAnulabile(true);

		System.out.println("Simboluri anulabile: " + simboluriAnulabile);

	}

}
