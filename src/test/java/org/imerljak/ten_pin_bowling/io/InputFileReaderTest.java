package org.imerljak.ten_pin_bowling.io;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class InputFileReaderTest {

    InputFileReader reader = new InputFileReader();

    @Test
    void shouldReadValidFile() throws URISyntaxException {
        final URL resource = getClass().getClassLoader().getResource("valid_testfile.txt");
        if (resource == null) throw new NullPointerException();

        final Map<String, List<String>> result = reader.readForMap(Paths.get(resource.toURI()));

        assertTrue(result.containsKey("Jeff"));
        assertIterableEquals(
                asList("10", "7", "3", "9", "0", "10", "0", "8", "8", "2", "F", "6", "10", "10", "10", "8", "1"),
                result.get("Jeff")
        );

        assertTrue(result.containsKey("John"));
        assertIterableEquals(
                asList("3", "7", "6", "3", "10", "8", "1", "10", "10", "9", "0", "7", "3", "4", "4", "10", "9", "0"),
                result.get("John")
        );
    }

    @Test
    void shouldThrowOnInvalidPath() {
        final Path magicPath = Paths.get("magic_file.txt");
        assertThrows(IllegalStateException.class, () -> reader.readForMap(magicPath));
    }

}
