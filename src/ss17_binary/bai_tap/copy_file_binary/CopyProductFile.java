package ss17_binary.bai_tap.copy_file_binary;

import java.io.*;

public class CopyProductFile {
    private static final String FILE_PATH = "D:\\CodeGym\\Module2\\src\\ss17_binary\\bai_tap\\copy_file\\products.dat";
    private static final String FILE_TARGET_PATH = "D:\\CodeGym\\Module2\\src\\ss17_binary\\bai_tap\\copy_file_binary\\target.dat";
    public static void main(String[] args) {
        File sourceFile = new File(FILE_PATH);

        if (!sourceFile.exists()) {
            System.out.println(" File nguồn không tồn tại: " + FILE_PATH);
            return;
        }

        File targetFile = new File(FILE_TARGET_PATH);

        if (targetFile.exists()) {
            System.out.println(" File đích đã tồn tại. Không thể ghi đè.");
            return;
        }

        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("Sao chép thành công từ:");
            System.out.println("   Nguồn: " + FILE_PATH);
            System.out.println("   Đích: " + FILE_TARGET_PATH);
            System.out.println("Tổng số byte sao chép: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }
}

