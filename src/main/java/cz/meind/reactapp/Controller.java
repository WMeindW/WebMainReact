package cz.meind.reactapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    private final String resources = "/home/ubuntu/react/resources/static/";

    @ResponseBody
    @GetMapping("/")
    public String index() {
        return read("index.html");
    }

    @ResponseBody
    @GetMapping(value = "/javascript", produces = "application/javascript")
    public String javascript() {
        return read("index.js");
    }

    @ResponseBody
    @GetMapping(value = "/css")
    public String css() {
        return read("index.css");
    }

    @ResponseBody
    @GetMapping(value = "/bootstrap", produces = "font/woff")
    public byte[] bootstrap() throws IOException {
        return Files.readAllBytes(Path.of(resources + "bootstrap-icons.woff"));
    }

    @ResponseBody
    @GetMapping(value = "/bootstrap2", produces = "font/woff2")
    public byte[] bootstrap2() throws IOException {
        return Files.readAllBytes(Path.of(resources + "bootstrap-icons.woff2"));
    }

    @ResponseBody
    @GetMapping(value = "/banner", produces = "image/png")
    public byte[] banner() throws IOException {
        return Files.readAllBytes(Path.of(resources + "banner.png"));
    }

    @ResponseBody
    @GetMapping(value = "/group", produces = "image/png")
    public byte[] group() throws IOException {
        return Files.readAllBytes(Path.of(resources + "group.png"));
    }

    @ResponseBody
    @GetMapping(value = "/projects", produces = "image/png")
    public byte[] projects() throws IOException {
        return Files.readAllBytes(Path.of(resources + "projects.png"));
    }

    @ResponseBody
    @GetMapping(value = "/logo.svg", produces = "image/svg+xml")
    public byte[] logo() throws IOException {
        return Files.readAllBytes(Path.of(resources + "logo.svg"));
    }

    private String read(String path) {
        StringBuilder out = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(resources + path));
            while (scanner.hasNext()) out.append(scanner.nextLine());
            scanner.close();
        } catch (Exception e) {
            return null;
        }
        return out.toString();
    }
}
