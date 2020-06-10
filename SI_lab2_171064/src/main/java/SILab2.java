import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) { //1
        if (list.size() <= 0) { //2
            throw new IllegalArgumentException("List length should be greater than 0"); //3
        } //4
        List<String> numMines = new ArrayList<>(); //5
        for (int i = 0; i < list.size(); i++) { //6
            if (!list.get(i).equals("#")) { //7
                int num = 0; //8
                if (i - 1 >= 0 && list.get(i - 1).equals("#")) { //9
                    num++; //10
                } //11
                if (i + 1 < list.size() && list.get(i + 1).equals("#")) { //12
                    num++; //13
                } //14
                numMines.add(String.valueOf(num)); //15
            } else { //16
                numMines.add(list.get(i)); //17
            } //18
        } //19
        return numMines; //20
    } //21
}
