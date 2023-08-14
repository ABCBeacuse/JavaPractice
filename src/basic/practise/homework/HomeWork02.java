package basic.practise.homework;

public class HomeWork02 {
    public static void main(String[] args) {

    }

    static Integer register(String name, String password, String email) {
        if (name == null) {
            return -1;
        }
        int length = name.length();
        if (length != 2 && length != 3 && length != 4) {
            return -1;
        }
        if (password == null || password.length() != 6) {
            return -1;
        }
        try {
            Integer.parseInt(password);
        } catch (NumberFormatException e) {
            return -1;
        }
        if (email == null) {
            return -1;
        }
        int index = email.indexOf("@");
        int index2 = email.indexOf(".");
        if(index <= index2) {
            return -1;
        }
        return 1;
    }
}
