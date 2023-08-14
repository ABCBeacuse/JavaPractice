package basic.practise.homework;

public class HomeWork01 {
    public static void main(String[] args) {
        String str = "abcdefghi";
        try {
            str = reverse_(str, 3, 6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str); // abcgfedhi
    }

    static String reverse(String str, int start, int end) {
        StringBuilder builder = new StringBuilder(str.substring(start, end + 1));
        builder.reverse();
        builder.insert(0, str.substring(0, start));
        builder.insert(end + 1, str.substring(end + 1));
        return builder.toString();
    }

    static String reverse_(String str, int start, int end) {
        if (!(str != null && start >= 0 && start < end && end < str.length())) {
            throw new RuntimeException("参数错误");
        }
        char[] chars = str.toCharArray();
        char temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
