import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        var list = new ArrayList<>(List.of(1,2,3,4,5,6,7,9,10));
        System.out.println(missingNum(list,10));
    }

    static int missingNum(List<Integer> numList, int maxNum){

        //I had this similarity with the solution from the unit
        if (numList.size() == maxNum){
            return 0;
        }

        int removedNumber = 0;
        Collections.sort(numList);
        System.out.println(numList);
        for(int i = 0; i<10; i++){
            if ((numList.get(i)+1) != (numList.get(i+1))){
                removedNumber = numList.get(i+1) - 1;
                break;
            }
        }

        return removedNumber;
    }
}
