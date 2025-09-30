package Furama.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeListStringToCSV(String filePatch, List<String> list,boolean append) throws IOException {
        File file = new File(filePatch);
        FileWriter fileWriter = new FileWriter(file,append);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line: list){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<String> readFileCSVToList(String filePatch) throws IOException {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePatch);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            stringList.add(line);
        }

        return stringList;
    }
}
