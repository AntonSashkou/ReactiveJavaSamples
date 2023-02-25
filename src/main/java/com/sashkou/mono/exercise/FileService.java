package com.sashkou.mono.exercise;

import com.sashkou.Utils;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileService {

    public static void main(String[] args) {

        FileService.write("sample_1.txt", "This is file3")
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        FileService.read("sample_2.txt")
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

        FileService.delete("sample_3.txt")
                .subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());

    }

    private static final Path PATH = Paths.get("src/main/resources");

    public static Mono<String> read(String fileName){
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content){
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName){
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static String readFile(String fileName){
        try{
            return Files.readString(PATH.resolve(fileName));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String fileName, String content){
        try{
            Files.writeString(PATH.resolve(fileName), content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String fileName){
        try{
            Files.delete(PATH.resolve(fileName));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
