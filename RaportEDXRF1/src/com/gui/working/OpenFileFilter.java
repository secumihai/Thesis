package com.gui.working;

import java.io.File;
import java.util.Optional;
import javax.swing.filechooser.*;

public class OpenFileFilter extends FileFilter {
    public String fileExt = "";
    String txtExt = "cantit";

    public OpenFileFilter() {
        this("cantit");  //default file type extension.
    }

    public OpenFileFilter(String extension) {
        fileExt = extension;
    }

    @Override public boolean accept(File f) {
        if (f.isDirectory()){
            return true;
        }
        if(getExtensionByStringHandling(f.getName().toLowerCase()).equals(Optional.empty())){
            if(f.getName().toLowerCase().contains(fileExt)) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return  "Fişier tip (File) care conţin în denumire \"cantitativ\" (fără extensie)";
    }

    private Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
