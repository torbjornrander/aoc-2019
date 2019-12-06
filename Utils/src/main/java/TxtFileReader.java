import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Data
public class TxtFileReader {

    private List<String> lines;
    private URL resource;

    public TxtFileReader(String fileName) {
        resource = TxtFileReader.class.getResource(fileName);
        lines = new ArrayList<>();
        try {
            Path resourcePath = Paths.get(resource.toURI()).toAbsolutePath();
            try (Stream<String> stream = Files.lines(Paths.get(resourcePath.toString()))) {
                stream.forEach(line -> lines.add(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
