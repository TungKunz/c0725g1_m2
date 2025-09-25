package ss16.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileText {
    private static final String FILE_PATH_READ = "D:\\CodeGym\\Module2\\src\\ss16\\bai_tap\\copy_file_text\\source_file.txt";
    private static final String FILE_PATH_WRITE = "D:\\CodeGym\\Module2\\src\\ss16\\bai_tap\\copy_file_text\\target_file";
    public static void main(String[] args) {
        copyFile();
    }
    private static void copyFile() {
        File sourceFile = new File(CopyFileText.FILE_PATH_READ);
        File targetFile = new File(CopyFileText.FILE_PATH_WRITE);

        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại!");
            return;
        }

        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại, sao chép bị hủy!");
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))
        ) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                count += line.length();
            }
            writer.write("Số ký tự đã sao chép: " +count);
            System.out.println(" Sao chép thành công!");
            System.out.println(" Số ký tự đã sao chép: " + count);
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }
}
