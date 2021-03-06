import java.text.ParseException;
import java.util.Stack;

import javax.swing.text.html.HTMLEditorKit.Parser;


/**
  * Grammatik
 * S->aST|c
 * T->aT|b
 * 
 * =>
 * M=({S,T},{a,b,c},S,d)
 * 
 *d(S,a)=ST
 *d(S,c)=�
 *d(T,a)=T
 *d(T,b)=�
 *
 *W�rter: c,acb,aa...cb...,aa...c...aaaa...b
 */

/**
 * @author jan,janosch,larissa
 *
 */

class LLParser implements I_SpecificParser{

	char restwort[]; // brauchen das Restwort, hier als Chararray f�r bessere durchlaufbarkeit
	char left; //ist der zu �bergebene buchstabe an S oder T
	Stack<String> zuErsetzen = new Stack<String>(); // haben uns eine Stackimplementierung aus Java geholt, da der Typ von "zuErsetzen" Stack ist. (ich h�tte das mit ArrayList gemacht...)

	
	public LLParser() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void startLLParser(String wort) throws ParseException {
		// TODO Auto-generated method stub
		restwort=wort.toCharArray();
		
		zuErsetzen.push("S");
		
		for (int i=0 ; i<restwort.length ; i++) { // schleife, durchl�uft das Array "wort"
			left=restwort[i]; // gibt an left den n�chsten buchstaben weiter.
			if ( !zuErsetzen.isEmpty() ) {
				String pop = zuErsetzen.pop();
				if (pop=="S") {
					System.out.println(pop + " => " +left ); //h�bsche Konsolenausgabe
					S(left,zuErsetzen);
					}
				else if (pop=="T") {
					System.out.println(pop + " => " +left ); 
					T(left,zuErsetzen);
				}
			
			}
			else {
				throw new ParseException("Stack: leer, Wort aber nicht",0);
			}
			
		}
		
		if (!zuErsetzen.isEmpty()){
			throw new ParseException("Stack: voll, Wort leer",0);
		}
		else  {
			System.out.println("true"); //return true; // w�re hier die korrekt, wenn das interface boolean w�re.
		}
		}

	@Override
	public void S(Character left, Stack zuErsetzen) throws ParseException {
		if (left=='c') {
			
		}
		else if (left=='a') {
			zuErsetzen.push("T");
			zuErsetzen.push("S");
			
		}
		else {
			throw new ParseException("Stack S, falsche Eingabe: "+left.toString(), 0);
		}
	}

	@Override
	public void T(Character left, Stack zuErsetzen) throws ParseException {
		if (left=='b') {
		}
		else if (left=='a') {
			zuErsetzen.push("T");
		}
		else {
			throw new ParseException("Stack T, falsche Eingabe: "+left.toString(), 0);
		}
	}

	@Override
	public void X(Character left, Stack zuErsetzen) throws ParseException {
		// unused
		
	}

	@Override
	public void Y(Character left, Stack zuErsetzen) throws ParseException {
		// unused
		
	}

}



public class main {

	public main() {
		// no 1
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLParser parser = new LLParser();

		try {

//			parser.startLLParser("a"); // stack voll, wort leer
//			parser.startLLParser("bc"); //falsch


//			parser.startLLParser("z"); // falsches eingabesymbol
			
			parser.startLLParser("c"); //ok S=>c
			parser.startLLParser("acb"); //ok

			parser.startLLParser("acab"); //ok S=*>aT

			parser.startLLParser("aacbb"); //ok
			
			parser.startLLParser("cc"); //Wort voll, Stack leer
		} catch (ParseException e) {
			// kann auch weg, wenns jemand anders catchen soll, muss aber bei main dann "throws ParseException" hinzugef�gt werden
			e.printStackTrace();
		}
	}

}

