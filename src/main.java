import java.text.ParseException;
import java.util.Stack;

import javax.swing.text.html.HTMLEditorKit.Parser;

/**
 * 
 */

/**
 * @author jan,janosch,larissa
 *
 */


class LLParser implements I_SpecificParser{

	/**
	 * 
	 */
	char restwort[]; // brauchen das Restwort, hier als Chararray für bessere durchlaufbarkeit
	char left; //ist der zu übergebene buchstabe an S oder T
	Stack<String> zuErsetzen = new Stack<String>(); // haben uns eine Stackimplementierung aus Java geholt, da der Typ von "zuErsetzen" Stack ist. (ich hätte das mit ArrayList gemacht...)

	
	public LLParser() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void startLLParser(String wort) throws ParseException {
		// TODO Auto-generated method stub
		restwort=wort.toCharArray();
		zuErsetzen.push("S");
		
		for (int i=0 ; i<restwort.length ; i++) { // schleife, durchläuft das Array "wort"
			left=restwort[i]; // gibt an left den nächsten buchstaben weiter.
			
			if (zuErsetzen.peek()=="S") {
				System.out.println(zuErsetzen.peek().toString() + " => " +left );
				S(left,zuErsetzen);
				}
			else if (zuErsetzen.peek()=="T") {
				System.out.println(zuErsetzen.peek().toString() + " => " +left );
				T(left,zuErsetzen);
			}
			
		}
		System.out.println("true"); //return true; // wäre hier die korrekt, wenn das interface boolean wäre.
		}

	@Override
	public void S(Character left, Stack zuErsetzen) throws ParseException {
		// TODO Auto-generated method stub
		if (left=='c') {
//			System.out.println(zuErsetzen.peek().toString() + " => " +left );
			zuErsetzen.pop();
		}
		else if (left=='a') {
//			System.out.println(zuErsetzen.peek().toString() + " => " +left );
			zuErsetzen.pop();
			zuErsetzen.push("T");
			zuErsetzen.push("S");
			
		}
		else {
			throw new ParseException(left.toString()+" Stack S", 0);
		}
	}

	@Override
	public void T(Character left, Stack zuErsetzen) throws ParseException {
		// TODO Auto-generated method stub
		if (left=='b') {
//			System.out.println(zuErsetzen.peek().toString() + " => " +left );
			zuErsetzen.pop();
		}
		else if (left=='a') {
//			System.out.println(zuErsetzen.peek().toString() + " => " +left );
			zuErsetzen.pop();
			zuErsetzen.push("T");
		}
		else {
			throw new ParseException(left.toString()+" Stack T", 0);
		}
	}

	@Override
	public void X(Character left, Stack zuErsetzen) throws ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Y(Character left, Stack zuErsetzen) throws ParseException {
		// TODO Auto-generated method stub
		
	}

}



public class main {

	/**
	 * 
	 */
	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLParser parser = new LLParser();

		try {
			parser.startLLParser("c");
			parser.startLLParser("acb");
			parser.startLLParser("aaaaaaaacaaaaaaaaaaaaaaab");
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}
/**
 * Grammatik
 * S->aST|c
 * T->aT|b
 * 
 * =>
 * M=({S,T},{a,b,c},S,d)
 * 
 *d(S,a)=ST
 *d(S,c)=€
 *d(T,a)=T
 *d(T,b)=€
 *
 *Wörter: c,acb,aa...cb...,aa...c...aaaa...b
 */
	


	/**
	 * Grammatik
	 * S->aST|c
	 * T->aT|b
	 * 
	 * =>
	 * M=({S,T},{a,b,c},S,d)
	 * 
	 *d(S,a)=ST
	 *d(S,c)=€
	 *d(T,a)=T
	 *d(T,b)=€
	 *
	 *Wörter: c,acb,aa...cb...,aa...c...aaaa...b
	 */
		


	/**
	 * @author larissa,janosch,jan
	 *
	 */

}

