package ss12_map_tree.thuc_hanh.hashmap_linkedhashmap_treemap_student;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashLinkedTreeMap {
    public static void saveStudentInfo(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(map + "\n");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));

        Map<String,Integer> tree = new TreeMap<>(map);
        System.out.println("Display entries in ascending order of key");
        System.out.println(tree);

    }
}
