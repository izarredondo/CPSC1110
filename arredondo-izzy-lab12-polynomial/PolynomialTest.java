/**
 * A class to to test the Polynomial class.
 */
public class PolynomialTest {
	public static void main(String[] args) {
		//create the polynomial 5x^10 + 9x^7 - 1x - 10
		Polynomial p = new Polynomial(new Term(-10, 0));
		p.add(new Polynomial(new Term(-1, 1)));
		p.add(new Polynomial(new Term(9, 7)));
		p.add(new Polynomial(new Term(5, 10)));
		p.print();
		System.out.print("  X  ");
		p.print();
		System.out.println(" = ");
		//multiply the poly by itself
		Polynomial q = p.multiply(p);
		q.print();
		System.out.println();

		//first poly is x^3 + 2x^2 + 4x
		p = new Polynomial(new Term(1, 3));
		p.add(new Polynomial(new Term(2, 2)));
		p.add(new Polynomial(new Term(4, 0)));

		//second poly is 2x^3 + 1x + 1
		q = new Polynomial(new Term(2, 3));
		q.add(new Polynomial(new Term(1, 1)));
		q.add(new Polynomial(new Term(1, 0)));

		System.out.println();
		//print the original polys
		p.print();
		System.out.print("  X  ");
		q.print();
		System.out.println(" = ");
		//multiply them then print
		Polynomial res = p.multiply(q);
		res.print();
	}
}