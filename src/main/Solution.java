package main;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Solution(){};

    public void checkMagazine(String[] magazine, String[] note) {
        /*If the ransom note is longer than the magazine, there is
        * no way that this magazine could create the ransom note*/
        if(note.length > magazine.length){
            System.out.println("No");
            return;
        }

        Map<String, Integer> helperMap = new HashMap<>();
        for(String s : magazine){
            if(!helperMap.containsKey(s)){
                helperMap.put(s, 1);
            } else {
                helperMap.put(s, helperMap.get(s)+1);
            }
        }

        for(String ns : note){
            if(helperMap.containsKey(ns)){
                helperMap.put(ns, helperMap.get(ns)-1);
                if(helperMap.get(ns) < 0){
                    System.out.println("No");
                    return;
                }
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

}
