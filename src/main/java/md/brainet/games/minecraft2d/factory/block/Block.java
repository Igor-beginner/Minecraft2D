package md.brainet.games.minecraft2d.factory.block;

import md.brainet.games.minecraft2d.adapter.api.graphics.Displayed;
import md.brainet.games.minecraft2d.render.Texture;

import java.awt.*;

public record Block(String name, Texture texture, Dimension dimension) implements Displayed {

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public Dimension getDimension() {
        return dimension;
    }
}
