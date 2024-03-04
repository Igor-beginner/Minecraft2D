package md.brainet.games.minecraft2d.view;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class GameFrame extends JFrame {
    private static final String NAME = "Minecraft2D";
    private final Point location;

    public GameFrame(List<KeyListener> keyListeners){
        location = new Point(5, -3);
        setTitle(NAME);
        setSize(new Dimension(900, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setFocusable(true);
        keyListeners.forEach(this::addKeyListener);
    }

    @Override
    @Nonnull
    public Point getLocation() {
        return location;
    }

    @Lazy
    @Override
    @Autowired
    public synchronized void addMouseListener(MouseListener proxyMouseController) {
        super.addMouseListener(proxyMouseController);
    }

    @Lazy
    @Override
    @Autowired
    public synchronized void addMouseMotionListener(MouseMotionListener proxyMouseMover) {
        super.addMouseMotionListener(proxyMouseMover);
    }
}
