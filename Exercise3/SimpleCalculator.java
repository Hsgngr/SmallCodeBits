
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * @author ianw
 *
 * Simple command line parser
 */
public class SimpleCalculator {
    private StreamTokenizer st;

    public SimpleCalculator() {
        super();

    }

    private void createScanner(String s) {
        this.st = new StreamTokenizer(new StringReader(s)); //yeni streamTokenizer objesi oluşturuluyor.
        st.ordinaryChar('('); //OrdinaryChar methodu bu karakterlere gelince durmasını token'ı oluşturmasını söylüyor.
        st.ordinaryChar(')');
        st.ordinaryChar('+');
        st.ordinaryChar('-');
        st.ordinaryChars('0', '9');
    }

    public int parseSum(String s) throws SyntaxException, IOException {
        createScanner(s);
        st.nextToken();
        int t1= parseTerm();
        int value=0;
        st.nextToken(); //oluşturulan tokenlerden bir sonrakine geçmeye yarıyor.
        if(st.ttype == st.TT_EOF){ //TT_EOF line ın sonuna gelmişsin demek. 
            return t1; // Yani sadece 2 ya da ((4)) gibi şeyler işlemsiz sayılar yazdıysan direk cevabı return
        }
        if(st.ttype == '+'){
            st.nextToken();
            value=t1 + parseTerm();
        } else if(st.ttype == '-'){
            st.nextToken();
            value=t1 - parseTerm();

        }
        else{
            throw new SyntaxException("We were expecting + or - ");
        }
        st.nextToken(); // işlemi yaptık bundan sonra herhangi bir şey geliyorsa sorun var. 
        if(st.ttype != st.TT_EOF){
            throw new SyntaxException("Unexpected characters at the end of the line");
        }
        return value;
    }

    public int parseTerm() throws SyntaxException, IOException { //recursive bir mehtod
        if(st.ttype == '('){ //eğer paranteze eşitse token'ı bir arttıracak ve yine parantez mi değil mi diye check edicek.
            st.nextToken();
            int val = parseTerm(); // recursion
            st.nextToken();
            if(st.ttype == ')'){ //parantez buldukça recursive fonksiyonlar parantez döndürücek.
                return val;
            } else throw new SyntaxException("Expected ')'");
        } else if(st.ttype >= '0' && st.ttype <= '9'){ //ardından sayıyı bulunca bu sefer st.nextToken diyerek ')' parantezi sorguluyor 
            return st.ttype -'0';
        }else throw new SyntaxException("Expected a single digit number or a '('");
    }

    public static void main(String args[]) throws IOException, SyntaxException {
        SimpleCalculator sc = new SimpleCalculator();
        // Read the string from standard input
        String input = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("What expression do you want to calculate?");
            input = br.readLine();
            System.out.println("The answer is " + sc.parseSum(input));
        } while(!input.equals(""));
        System.out.println("Bye");
    }
}
