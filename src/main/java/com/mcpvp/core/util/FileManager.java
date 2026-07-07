package com.mcpvp.core.util;

import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public final class FileManager {

    public static void copy(Path source, Path target) throws IOException {

        Files.walkFileTree(source, new SimpleFileVisitor<>() {

            @NonNull
            @Override
            public FileVisitResult preVisitDirectory(@NonNull Path pth, @NonNull BasicFileAttributes attrs) throws IOException {

                final var targetDir = target.resolve(source.relativize(pth));

                Files.createDirectories(targetDir);

                return FileVisitResult.CONTINUE;
            }

            @NonNull
            @Override
            public FileVisitResult visitFile(@NonNull Path pth, @NonNull BasicFileAttributes attrs) throws IOException {

                final var targetFile = target.resolve(source.relativize(pth));

                Files.copy(pth, targetFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

                return FileVisitResult.CONTINUE;
            }

            @NonNull
            @Override
            public FileVisitResult visitFileFailed(@NonNull Path pth, @NonNull IOException e) throws IOException {
                throw e;
            }

        });

    }

    public static void delete(Path path) throws IOException {

        Files.walkFileTree(path, new SimpleFileVisitor<>() {

            @NonNull
            @Override
            public FileVisitResult visitFile(@NonNull Path pth, @NonNull BasicFileAttributes attrs) throws IOException {

                Files.delete(pth);

                return FileVisitResult.CONTINUE;
            }

            @NonNull
            @Override
            public FileVisitResult visitFileFailed(@NonNull Path pth, @NonNull IOException e) throws IOException {
                throw e;
            }

            @NonNull
            @Override
            public FileVisitResult postVisitDirectory(@NonNull Path pth, IOException e) throws IOException {

                if (e != null)
                    throw e;

                Files.delete(pth);

                return FileVisitResult.CONTINUE;
            }

        });

    }
    
}