import java.text.ParseException;
import java.lang.Throwable;
import java.util.Stack;

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
public class LLParser implements I_SpecificParser{

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
			if (zuErsetzen.peek()=="S")
				S(left,zuErsetzen);
			else
				T(left,zuErsetzen);
//			System.out.println(i);
//			System.out.println(left);
//			System.out.println(restwort.length);
//			System.out.println(restwort);
//			
		}
	}

	@Override
	public void S(Character left, Stack zuErsetzen) throws ParseException {
		// TODO Auto-generated method stub
		if (left.toString().equals("c")) {
			zuErsetzen.pop();
		}
		if (left.toString().equals("a")) {
			zuErsetzen.pop();
			zuErsetzen.push("T");
			zuErsetzen.push("S");
			
		}
		else {
			throw new ParseException(left.toString(), 0);
		}
	}

	@Override
	public void T(Character left, Stack zuErsetzen) throws ParseException {
		// TODO Auto-generated method stub
		if (left.toString().equals("b")) {
			zuErsetzen.pop();
		}
		if (left.toString().equals("a")) {
			zuErsetzen.pop();
			zuErsetzen.push("T");
		}
		else {
			throw new ParseException(left.toString(), 0);
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
