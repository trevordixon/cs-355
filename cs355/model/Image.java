package cs355.model;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Image {
    int width;
    int height;
    int[][] pixels;

    public Image(int width, int height, int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = new int[height][width];

        int i = 0;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                this.pixels[r][c] = pixels[i];
                i += 3;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getPixels() {
        return pixels;
    }

    public BufferedImage getBufferedImage() {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = bi.getRaster();
        int[] pixels = new int[width*height];

        int i = 0;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                pixels[i++] = this.pixels[r][c];
            }
        }
        wr.setPixels(0, 0, width, height, pixels);
        bi.setData(wr);
        return bi;
    }

    public void adjustBrightness(int amount) {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                pixels[r][c] += amount;
                if (pixels[r][c] > 255) {
                    pixels[r][c] = 255;
                }
            }
        }
    }

    public void adjustContrast(int amount) {
        double scalar = Math.pow((double) (amount+100) / 100.00, 4);
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                double p = (double) pixels[r][c];
                pixels[r][c] = (int) (scalar*(p-128)+128);
                if (pixels[r][c] > 255) {
                    pixels[r][c] = 255;
                } else if (pixels[r][c] < 0) {
                    pixels[r][c] = 0;
                }
            }
        }
    }
}
