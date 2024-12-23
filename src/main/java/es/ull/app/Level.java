package main.java.es.ull.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bagel.Input;
import bagel.Keys;
import bagel.util.Point;

public class Level {
    private final Timer timer = new Timer();
    private Player player;
    private final ArrayList<Wall> walls = new ArrayList<>();
    private final ArrayList<Ghost> ghosts = new ArrayList<>();
    private final ArrayList<Dot> dots = new ArrayList<>();
    private final ArrayList<Shield> shields = new ArrayList<>();
    private final ArrayList<Pizza> pizzas = new ArrayList<>();
    private final ArrayList<Star> stars = new ArrayList<>();
    private final ArrayList<Bomb> bombs = new ArrayList<>();
    private final ArrayList<TimeFreeze> timeFreezes = new ArrayList<>();

    public Level(String worldFile) {
        readCSV(worldFile);
    }

    private void readCSV(String worldFile) {
        String text;
        try (BufferedReader br = new BufferedReader(new FileReader(worldFile))) {
            while ((text = br.readLine()) != null) {
                String[] cells = text.split(",");
                Point point = new Point(Integer.parseInt(cells[1]), Integer.parseInt(cells[2]));

                switch (cells[0]) {
                    case "main.java.es.ull.app.Player":
                        player = new Player(point);
                        break;
                    case "main.java.es.ull.app.Bus":
                        walls.add(new Bus(point));
                        break;
                    case "main.java.es.ull.app.Tram":
                        walls.add(new Tram(point));
                        break;
                    case "main.java.es.ull.app.Train":
                        walls.add(new Train(point));
                        break;
                    case "main.java.es.ull.app.GhostRed":
                        ghosts.add(new GhostRed(point));
                        break;
                    case "main.java.es.ull.app.GhostBlue":
                        ghosts.add(new GhostBlue(point));
                        break;
                    case "main.java.es.ull.app.GhostGreen":
                        ghosts.add(new GhostGreen(point));
                        break;
                    case "main.java.es.ull.app.GhostPink":
                        ghosts.add(new GhostPink(point));
                        break;
                    case "main.java.es.ull.app.GhostTuka":
                        ghosts.add(new GhostTuka(point));
                        break;
                    case "main.java.es.ull.app.Shield":
                        shields.add(new Shield(point));
                        break;
                    case "main.java.es.ull.app.Pizza":
                        pizzas.add(new Pizza(point));
                        break;
                    case "main.java.es.ull.app.Star":
                        stars.add(new Star(point));
                        break;
                    case "main.java.es.ull.app.Bomb":
                        bombs.add(new Bomb(point));
                        break;
                    case "main.java.es.ull.app.TimeFreeze":
                        timeFreezes.add(new TimeFreeze(point));
                        break;
                    default:
                        dots.add(new Dot(point));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that moves the player given the input and frenzy mode
     */
    public void playerInput(Input input, boolean frenzyMode) {
        if (input.isDown(Keys.LEFT)) {
            player.goLeft(walls, frenzyMode);
        } else if (input.isDown(Keys.RIGHT)) {
            player.goRight(walls, frenzyMode);
        } else if (input.isDown(Keys.UP)) {
            player.goUp(walls, frenzyMode);
        } else if (input.isDown(Keys.DOWN)) {
            player.goDown(walls, frenzyMode);
        }
    }

    public Timer getTimer() {
        return timer;
    }
    public Player getPlayer() {
        return player;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public ArrayList<Shield> getShields() {
        return shields;
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public ArrayList<Star> getPellets() {
        return stars;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public ArrayList<TimeFreeze> getTimeFreezes() {
        return timeFreezes;
    }

}
