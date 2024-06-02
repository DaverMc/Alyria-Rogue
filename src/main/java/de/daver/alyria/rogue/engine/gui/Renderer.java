package de.daver.alyria.rogue.engine.gui;

import de.daver.alyria.rogue.engine.game.Game;
import de.daver.alyria.rogue.engine.image.ImageWrapper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Renderer {

    private static final int COLOR_BLACK = 0xFF000000;

    private final Map<UUID, RenderObject> objectMap;

    private final BufferedImage image;
    private final int[] pixels;

    public Renderer() {
        this.objectMap = new HashMap<>();
        image = new BufferedImage(Game.GUI_WIDTH, Game.GUI_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = image.createGraphics();
        g.setColor(Color.BLACK); // Setzen Sie die Hintergrundfarbe auf Schwarz
        g.fillRect(0, 0, Game.GUI_WIDTH, Game.GUI_HEIGHT); // Füllen Sie das Bild mit Schwarz
        g.dispose();

        Raster raster = image.getRaster();
        pixels = ((DataBufferInt) raster.getDataBuffer()).getData();
    }

    public void addObject(UUID id, RenderObject object) {
        objectMap.put(id, object);
    }

    public void removeObject(UUID objectId) {
        objectMap.remove(objectId);
    }

    public BufferedImage renderView() {
        Arrays.fill(pixels, COLOR_BLACK); // Reset pixels to black
        objectMap.values().forEach(this::draw);
        Window window = Game.get().window();
        return ImageWrapper.wrap(image)
                .resize(window.width(), window.height())
                .unwrap();
    }

    private void draw(RenderObject object) {
        int[] pixels = object.render();
        int offsetX = object.x();
        int offsetY = object.y();
        int width = object.width();
        int height = object.height();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int index = y * width + x;
                if(isAlphaColor(pixels[index])) continue;
                int pixelIndex = (y + offsetY) * Game.GUI_WIDTH  + (x + offsetX);
                this.pixels[pixelIndex] = pixels[index];
            }
        }
    }

    public static boolean isAlphaColor(int argb) {
        int alpha = (argb >> 24) & 0xFF;
        return alpha < 255;
    }


}
