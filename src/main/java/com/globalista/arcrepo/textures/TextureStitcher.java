package com.globalista.arcrepo.textures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TextureStitcher {

    public static ArrayList<String> Types = new ArrayList<>();
    public static ArrayList<String> Kinds = new ArrayList<>();
    public static ArrayList<String> Gems = new ArrayList<>();
    public static ArrayList<String> Materials = new ArrayList<>();

    public static void populate(){
        Types.add("petty");
        Types.add("lesser");
        Types.add("greater");
        Types.add("grand");
        Types.add("cursed");

        Kinds.add("ring");
        Kinds.add("necklace");
        Kinds.add("mask");

        Gems.add("diamond");
        Gems.add("emerald");
        Gems.add("quartz");
        Gems.add("amethyst");
        Gems.add("lapis_lazuli");
        Gems.add("ruby");
        Gems.add("sapphire");
        Gems.add("topaz");
        Gems.add("jade");

        Materials.add("silver");
        Materials.add("gold");
    }

    public static void main(String[] args) {
        populate();

        Kinds.forEach(kind ->
                Types.forEach(type ->
                        Gems.forEach(gem ->
                                Materials.forEach(material ->
                                        make(type, material, gem, kind)))));
    }

    public static void make(String type, String material, String gem, String kind) {
        try {
            BufferedImage baseTypeTexture = load(kind + "/" + type + "_" + material);
            BufferedImage baseGemTexture = load( "gem/" + kind + "/" + type + "_" + gem);
            BufferedImage combinedTexture = stitch(baseTypeTexture, baseGemTexture);
            File outputFile = new File("src/main/resources/assets/arcrepo/textures/item/" + type + "_" + material + "_" + gem + "_" + kind + ".png");
            ImageIO.write(combinedTexture, "PNG", outputFile);
            System.out.println("Texture stitched: " + outputFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage stitch(BufferedImage baseTexture, BufferedImage overlayTexture) {
        BufferedImage combinedTexture = new BufferedImage(baseTexture.getWidth(), baseTexture.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < baseTexture.getWidth(); x++) {
            for (int y = 0; y < baseTexture.getHeight(); y++) {
                Color baseColor = new Color(baseTexture.getRGB(x, y), true);
                Color overlayColor = new Color(overlayTexture.getRGB(x, y), true);
                if (overlayColor.getAlpha() > 0) {
                    combinedTexture.setRGB(x, y, overlayColor.getRGB());
                } else {
                    combinedTexture.setRGB(x, y, baseColor.getRGB());
                }
            }
        }

        return combinedTexture;
    }

    private static BufferedImage load(String textureName) throws IOException {
        File baseTextureFile = new File("src/main/resources/assets/arcrepo/textures/base/" + textureName + ".png");
        return ImageIO.read(baseTextureFile);
    }
}

