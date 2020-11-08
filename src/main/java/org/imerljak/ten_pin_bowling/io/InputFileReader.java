package org.imerljak.ten_pin_bowling.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class InputFileReader {

    public Map<String, List<String>> readForMap(Path path) {
        try (Stream<String> stream = Files.lines(path)) {
            return stream
                    .map(line -> line.split("\\s"))
                    .collect(groupingBy(parts -> parts[0], mapping(parts -> parts[1], toList())));
        } catch (NoSuchFileException e) {
            throw new IllegalStateException("File not found: " + path.toString());
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
