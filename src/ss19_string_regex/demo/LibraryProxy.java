package ss19_string_regex.demo;

class LibraryProxy implements Library {
    private RealLibrary realLibrary;
    private String userRole;

    public LibraryProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void accessBook(String bookName) {
        if ("admin".equals(userRole) || "member".equals(userRole)) {
            System.out.println("Quyền hợp lệ. Cho phép truy cập.");
            if (realLibrary == null) {
                realLibrary = new RealLibrary();
                System.out.println("Khởi tạo thư viện thật (RealLibrary)...");
            }

            realLibrary.accessBook(bookName);
        } else {
            System.out.println("Truy cập bị từ chối. Chỉ admin/member mới được phép.");
        }
    }
}
