package md.brainet.games.minecraft2d;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Minecraft2DApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Minecraft2DApplication.class);
        builder.headless(false);
        builder.run(args);
    }

}
