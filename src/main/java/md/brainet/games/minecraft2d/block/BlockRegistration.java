package md.brainet.games.minecraft2d.block;

import md.brainet.games.minecraft2d.view.Texture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class BlockRegistration {

    @Bean
    public Block grass(){
        return new Block("Grass", new Texture(Path.of("D:\\projects\\Minecraft2D\\src\\main\\resources\\textures\\blocks\\grass.png")));
    }

    @Bean
    public Block dirt(){
        return new Block("Dirt", new Texture(Path.of("D:\\projects\\Minecraft2D\\src\\main\\resources\\textures\\blocks\\dirt.png")));
    }

    @Bean
    public Block cobblestone(){
        return new Block("Сobblestone", new Texture(Path.of("D:\\projects\\Minecraft2D\\src\\main\\resources\\textures\\blocks\\cobblestone.png")));
    }
}
