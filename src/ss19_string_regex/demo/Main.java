package ss19_string_regex.demo;

import ss19_string_regex.Demo;

public class Main {
        public static void main(String[] args) {
            Library user1 = new LibraryProxy("guest");
            user1.accessBook("Design Patterns");
            System.out.println("----------------------------------------");
            Library user2 = new LibraryProxy("member");
            user2.accessBook("Clean Code");
            System.out.println("----------------------------------------");
            Library user3 = new LibraryProxy("admin");
            user2.accessBook("Code Gym book");
        }
}
