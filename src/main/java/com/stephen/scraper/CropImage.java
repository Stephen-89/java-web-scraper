package com.stephen.scraper;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class CropImage {

	public static void cropImage(int count, String date) {
		
        try {
        	
            // Load the image
            BufferedImage originalImage = ImageIO.read(new File(String.format(Constants.NEW_SCREENSHOT, date, count)));

            // Find bounds of non-white area
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();

            int minX = width, minY = height, maxX = -1, maxY = -1;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (!isWhite(originalImage.getRGB(x, y))) {
                        if (x < minX) minX = x;
                        if (y < minY) minY = y;
                        if (x > maxX) maxX = x;
                        if (y > maxY) maxY = y;
                    }
                }
            }

            // Define the new width and height
            int newWidth = maxX - minX + 1;
            int newHeight = maxY - minY + 1;

            // Crop the image
            BufferedImage croppedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            Graphics2D g = croppedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, newWidth, newHeight, minX, minY, maxX + 1, maxY + 1, null);
            g.dispose();

            // Save the cropped image
            ImageIO.write(croppedImage, "png", new File(String.format(Constants.NEW_SCREENSHOT, date, count)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Helper method to determine if a pixel is white
    private static boolean isWhite(int rgb) {
        Color color = new Color(rgb);
        return color.getRed() > 240 && color.getGreen() > 240 && color.getBlue() > 240;
    }
    
}
