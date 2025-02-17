import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CameraComponent{
    private final char diff = 'A';

    public boolean isYellow(String pixel){
        return pixel.charAt(2) > diff;
    }

    public boolean isBlue(String pixel){
        return pixel.charAt(4) >= diff;
    }

    public String getColor(String pixel){
        if (isYellow(pixel)){
            return "yellow";
        }

        return isBlue(pixel) ? "blue":"red";
    }

    public String intToString(int pixel){
        int red = (pixel >> 16) & 0xFF;
        int green = (pixel >> 8) & 0xFF;
        int blue = pixel & 0xFF;
        return "%02X%02X%02X".formatted(red, green, blue);
    }

    public int[][] toPixelArray(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();
        int[][] pixels = new int[height][width];
        for (int row = 0; row < height; row++){
            image.getRGB(0,row,width,1, pixels[row],0, width);
        }

        return pixels;
    }

    public String getAverageColor(int[][] pixels){
        int averageRed = 0, averageGreen = 0, averageBlue = 0;
        int pixelCount = pixels.length * pixels[0].length;
        for (int[] row: pixels){
            for (int pixel: row){
                averageRed += (pixel >> 16) & 0xFF;
                averageGreen += (pixel >> 8) & 0xFF;
                averageBlue += pixel & 0xFF;
            }
        }

        averageGreen = averageGreen / pixelCount;
        averageRed = averageRed / pixelCount;
        averageBlue = averageBlue / pixelCount;

        return "%02X%02X%02X".formatted(averageRed, averageGreen, averageBlue);
    }
}