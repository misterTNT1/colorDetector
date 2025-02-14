import java.io.File;
import java.io.IOException;

public class Main6 {
    public static void main(String[] args) throws IOException {
        int iterations = 10;
        String colorCode;
        CameraComponent cameraComponent = new CameraComponent();
        File file = new File("C:\\Users\\eyal3\\OneDrive\\Desktop\\red_sample.png");
        int[][] pixels = new int[0][0];
//        BufferedImage buffer = ImageIO.read(file);
//        int width = buffer.getWidth();
//        int height = buffer.getHeight();
//        int[][] pixels = new int[height][width];
//        for (int row = 0; row < height; row++){
//            for (int col = 0; col < width; col++){
//                pixels[row][col] = buffer.getRGB(col, row);
//            }
//        }
        double start = System.nanoTime();
        for (int i = 0; i < iterations; i++){
            pixels = cameraComponent.toPixelArray(file);
            colorCode = cameraComponent.intToString(pixels[0][0]);
            cameraComponent.getColor(colorCode);
        }
        double end = System.nanoTime();
        System.out.println((end-start)/1000000/iterations);
        colorCode = cameraComponent.intToString(pixels[0][0]);
        System.out.println(cameraComponent.getColor(colorCode));

        //                alpha = (pixel >> 24) & 0xFF;





    }
}
