package project;

import java.util.List;
import java.util.Map;

public class ComputerMove {
    public String responseComputerResult;

    public String computerStep(Map<Character, List<String>> map, Character cr){
        if(map.containsKey(cr) && map.get(cr).size()!=0){
            responseComputerResult = map.get(cr).remove((int)(Math.random()*map.get(cr).size()-1));
            return responseComputerResult;
        }
        return responseComputerResult = " Ви перемогли ";
    }
}
