package app;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Lexicon lex = new Lexicon();

    String newWord = lex.translate("food");
    System.out.println(newWord);

  }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
  public static String decode(String word)
  {
    int I1 = word.indexOf("ent");
    if(I1!=-1)
    {
      char W = word.charAt(I1-1);
      if(W=='a'||W=='e'||W=='i'||W=='o'||W=='u')
      {
        word = word.substring(0,I1)+word.substring(I1+3);
      }
    }
    I1 = word.indexOf("ingy");
    if(I1!=-1)
    {
      if((word.indexOf('.')==word.length()-1||word.indexOf(',')==word.length()-1)&&I1==word.length()-5)
      {
        word = word.substring(0,word.length()-5)+word.charAt(word.length()-1);
      }else if(I1 == word.length()-4)
      {
        word = word.substring(0,word.length()-4);
      }
    }
    return word;
  }


  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
  public static String decodeMessage(String sen)
  {
    String NS,W;
    W = sen;
    NS = "";
    boolean TF = true;
      if(W.indexOf(' ')!=-1)
      {
       NS = decode(W.substring(0,W.indexOf(' ')));
       W = W.substring(W.indexOf(' ')+1);
      }
    while(TF)
    {
      if(W.indexOf(' ')!=-1)
      {
      NS = NS+" "+decode(W.substring(0,W.indexOf(' ')));
      W = W.substring(W.indexOf(' ')+1);
      }else
      {
        NS = NS+" "+decode(W);
        TF = false;
      }
    }
    return NS;
  }

  /**
   * This method uses the decode(String) and a Scanner to decode a word specified
   * by the user.
   */
  public static String decodeInput()
  {
    Scanner S2 = new Scanner(System.in);
    System.out.println("Please Enter The Word or Sentence");
    String IW; IW = S2.nextLine();
    if(IW.indexOf(' ')==-1)
    {
    return decode(IW);
    }
    return decodeMessage(IW);
  }
  
  /**
   * This method uses the Lexicon translate(String) and a Scanner to encode a word specified
   * by the user.
   */
  public static String encode(String IW)
  {
    Scanner S3 = new Scanner(System.in);
    Lexicon lex = new Lexicon();
    System.out.println("Please Enter The WORD");

    return lex.translate(S3.nextLine());
  }
}