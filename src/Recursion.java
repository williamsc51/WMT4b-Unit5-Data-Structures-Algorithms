import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        var list = new ArrayList<>(List.of("Dog", "Rat", "Cat", "Bat", "Mat"));

        System.out.println(recursiveSearch("Cat", list));
    }


    static int recursiveSearch(String str, ArrayList<String> strarr){

        if (strarr.size() == 0){
            return -1;
        }

        if (str.equals(strarr.get(strarr.size()-1))){
            return strarr.size()-1;
        }
        
        strarr.remove(strarr.size()-1);

        return recursiveSearch(str, strarr);
    }
}
