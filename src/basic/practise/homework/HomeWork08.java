package basic.practise.homework;

public class HomeWork08 {
    public static void main(String[] args) {

    }
}

interface func {
    void show();
}

enum Color implements func {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(redValue + " " + greenValue + " " + blueValue);
    }
}
