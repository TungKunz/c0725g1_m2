package ss16.bai_tap.read_file;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countryList = ReadFile.copyFile();
        System.out.println(countryList);
    }
}
