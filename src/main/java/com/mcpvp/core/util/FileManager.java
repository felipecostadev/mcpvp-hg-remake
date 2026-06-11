package com.mcpvp.core.util;

import java.io.File;
import java.io.IOException;

public final class FileManager {

    public static void deleteKeeping(File folder, String target) throws IOException {
        
        final var files = folder.listFiles();

        if (files == null)
            return;

        for (final var file : files) {

            if (file.getName().equalsIgnoreCase(target))
                continue;

            delete(file);
        }
        
    }

    private static void delete(File file) throws IOException {

        if (file.isDirectory()) {

            final var children = file.listFiles();

            if (children != null) {

                for (final var child : children)
                    delete(child);

            }

        }

        if (!file.delete())
            throw new IOException("Failed to delete: " + file.getAbsolutePath());

    }
    
}