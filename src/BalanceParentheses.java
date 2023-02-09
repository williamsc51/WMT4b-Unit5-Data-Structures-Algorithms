import java.util.regex.Pattern;

public class BalanceParentheses {
    public static void main(String[] args) {
        System.out.println(matchParen("()Hel(l)o World()"));
        System.out.println(matchBrackets("{Brackets}(Parentheses)[Square Brackets]<Angle Brackets>"));
    }

    static boolean matchParen(String str){

        int openParen = 0;
        int closeParen = 0;

        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '('){
                openParen = openParen + 1;
            }
            if (str.charAt(i) == ')'){
                closeParen = closeParen + 1;
            }
        }

        return openParen == closeParen ? true : false;
    }

    static boolean matchBrackets(String str){

        int openBracket = 0;
        int closeBracket = 0;

        for(int i = 0; i < str.length(); i++){
            if (Pattern.matches("\\{|\\(|\\[|\\<",Character.toString(str.charAt(i)))){
                openBracket = openBracket + 1;
            }
            if (Pattern.matches("\\}|\\)|\\]|\\>", Character.toString(str.charAt(i)))){
                closeBracket = closeBracket + 1;
            }
        }

        return openBracket == closeBracket ? true : false;
    }
}
