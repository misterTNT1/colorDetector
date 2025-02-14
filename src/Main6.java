import java.io.File;
import java.io.IOException;

public class Main6 {
    public static void main(String[] args) throws IOException {
        String colorCode;
        CameraComponent cameraComponent = new CameraComponent();
        File file = new File("C:\\Users\\eyal3\\OneDrive\\Desktop\\red_sample.png");
        int[][] pixels = cameraComponent.toPixelArray(file);
        colorCode = cameraComponent.intToString(pixels[0][0]);
        cameraComponent.getColor(colorCode);
        colorCode = cameraComponent.intToString(pixels[0][0]);
        System.out.println(cameraComponent.getColor(colorCode));





    }
}
