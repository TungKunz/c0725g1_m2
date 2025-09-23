package ss11_DSA_stack_queue.bai_tap.word_count_map;

import java.util.HashMap;
import java.util.Map;

public class WordCountMap {
    public static void countWordInString(String str){
        str = str.toLowerCase().replaceAll("[^a-z0-9\\s]","");
        String[] words = str.split("\\s+");
        Map<String,Integer> map = new HashMap<>();
        for (String word : words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else {
                map.put(word,1);
            }
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
