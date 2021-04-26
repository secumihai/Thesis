package com.gui.working;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenWord {
    public static void open(String path) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(path));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}