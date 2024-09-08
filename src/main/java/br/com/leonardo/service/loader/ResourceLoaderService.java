package br.com.leonardo.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.function.Function;

public class ResourceLoaderService {

    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public BufferedImage loadImage(String resourcePath) {
        try {
            return ImageIO.read(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(resourcePath))
            );
        } catch (IOException | IllegalArgumentException | NullPointerException e) {
            throw new ResourceNotFoundException(resourcePath, e);
        }
    }

    private File loadFile(String resourcePath) {

        try {
            File file = new File(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResource(resourcePath)).toURI()
            );
            if (file.exists()) {
                return file;
            }
            throw new ResourceNotFoundException(resourcePath);
        } catch (URISyntaxException | NullPointerException | IllegalArgumentException e) {
            throw new ResourceNotFoundException(resourcePath, e);
        }
    }

    private BufferedReader readFile(String resourcePath) {
        try {
            return new BufferedReader(new InputStreamReader(Objects.requireNonNull(
                    this.getClass().getClassLoader().getResourceAsStream(resourcePath)
            )));
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new ResourceNotFoundException(resourcePath, e);
        }
    }

    public <T> T consumeFile(String resourcePath, Function<BufferedReader, T> function) {
        try (BufferedReader bufferedReader = readFile(resourcePath)) {
            return function.apply(bufferedReader);
        } catch (IOException e) {
            throw new ResourceNotFoundException(resourcePath, e);
        }
    }

    public <T> T readConfig(String resourcePath, Class<T> clazz) {
        try {
            return mapper.readValue(this.loadFile(resourcePath), clazz);
        } catch (IOException e) {
            throw new ResourceNotFoundException(resourcePath, e);
        }
    }

}
