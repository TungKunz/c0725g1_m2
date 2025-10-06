package ss19_string_regex.demo;

class RealLibrary implements Library {
    @Override
    public void accessBook(String bookName) {
        System.out.println("Đang mở sách: " + bookName);
    }
}
