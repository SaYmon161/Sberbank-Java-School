package HW1.src.part3;

public class TemperatureConverter {
    public static float convertToFarenheit(float celsium) {
        return (celsium * 9) / 5 + 32;
    }

    public static void main(String[] args) {
        System.out.println(convertToFarenheit(12));
    }
}
