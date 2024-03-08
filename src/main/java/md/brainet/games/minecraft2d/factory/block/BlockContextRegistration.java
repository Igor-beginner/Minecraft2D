package md.brainet.games.minecraft2d.factory.block;

import md.brainet.games.minecraft2d.render.Texture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.nio.file.Path;

@Configuration
public class BlockContextRegistration {
    private static final Dimension BLOCK_SIZE = new Dimension(32, 32);

    @Bean
    public Block grass(){
        return new Block("Grass", new Texture(Path.of("D:\\projects\\Minecraft2D\\src\\main\\resources\\textures\\blocks\\grass.png")), BLOCK_SIZE);
    }

    @Bean
    public Block dirt(){
        return new Block("Dirt", new Texture(Path.of("D:\\projects\\Minecraft2D\\src\\main\\resources\\textures\\blocks\\dirt.png")), BLOCK_SIZE);
    }

    @Bean
    public Block cobblestone(){
        return new Block("Сobblestone", new Texture(Path.of("D:\\projects\\Minecraft2D\\src\\main\\resources\\textures\\blocks\\cobblestone.png")), BLOCK_SIZE);
    }
}
