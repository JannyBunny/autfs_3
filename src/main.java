import java.text.ParseException;
import java.util.Stack;

/**
 * 
 */

/**
 * @author jan,janosch,larissa
 *
 */
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
			System.out.println("test");
//			parser.startLLParser("c");
			parser.startLLParser("acb");
		} catch (ParseException e) {
			System.out.println("catch");

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
	

}
