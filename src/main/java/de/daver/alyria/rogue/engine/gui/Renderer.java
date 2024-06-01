package de.daver.alyria.rogue.engine.gui;

import de.daver.alyria.rogue.engine.game.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
        return scale(image);
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
                int pixelIndex = (y + offsetY) * Game.GUI_WIDTH  + (x + offsetX);
                this.pixels[pixelIndex] = pixels[index];
            }
        }
    }

    private BufferedImage scale(BufferedImage unscaled) {
        Window window = Game.get().window();
        double scaleX = (double) window.width() / unscaled.getWidth();
        double scaleY = (double) window.height() / unscaled.getHeight();
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp scaleOperation = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        return scaleOperation.filter(unscaled, null);
    }
}
