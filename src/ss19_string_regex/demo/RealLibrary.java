package ss19_string_regex.demo;

public class ServiceProxy implements Library {
    private LibraryProxy real;

    @Override
    public void request() {
        if (real == null) {
            real = new LibraryProxy();  // Lazy init
            System.out.println("Tạo RealService lần đầu");
        }
        System.out.println("Proxy: kiểm tra quyền truy cập...");
        real.request();
        System.out.println("Proxy: ghi log sau khi gọi real");
    }
}
