package ru.alekseykonstantinov.Introduction_windows_graphics_and_text.exfonts;

import java.awt.*;
import java.util.Arrays;

public class ExFonts {
    public static void main(String[] args) {

        System.out.println(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames().length);
        System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
    }
}
