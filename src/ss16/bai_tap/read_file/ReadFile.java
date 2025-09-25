package ss16.bai_tap.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static final String FILE_PATH_READ = "D:\\CodeGym\\Module2\\src\\ss16\\bai_tap\\read_file\\read.txt";
    public static List<Country> copyFile(){
        List<Country> list = new ArrayList<>();
        File fileRead = new File(FILE_PATH_READ);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileRead));){
            String line;
            while ((line= reader.readLine())!= null){
                String[] parts = line.split(",");
                int id= Integer.parseInt(parts[0]);
                String code = parts[1];
                String name = parts[2];
                list.add(new Country(id,code,name));
            }
        }catch (FileNotFoundException e) {
            System.out.println("Chưa có file dữ liệu, bắt đầu với danh sách rỗng.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
