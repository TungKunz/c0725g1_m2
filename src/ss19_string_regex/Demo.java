package ss19_string_regex;

public class Demo {
    // 1. Subject
    public interface Service {
        void request();
    }

    // 2. RealSubject
    public static class RealService implements Service {
        @Override
        public void request() {
            System.out.println("Xử lý công việc thật...");
        }
    }

    // 3. Proxy
    public static class ServiceProxy implements Service {
        private RealService real;

        @Override
        public void request() {
            if (real == null) {
                real = new RealService();  // Lazy init
                System.out.println("Tạo RealService lần đầu");
            }
            System.out.println("Proxy: kiểm tra quyền truy cập...");
            real.request();
            System.out.println("Proxy: ghi log sau khi gọi real");
        }
    }

    // 4. Client
    public class Main {
        public static void main(String[] args) {
            Service service = new ServiceProxy(); // client chỉ biết Subject
            service.request();
            service.request(); // lần 2, real đã có sẵn, không cần tạo mới
        }
    }

}

