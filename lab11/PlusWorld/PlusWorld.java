package PlusWorld;
import org.junit.Test;
import static org.junit.Assert.*;

import byowTools.TileEngine.TERenderer;
import byowTools.TileEngine.TETile;
import byowTools.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of plus shaped regions.
 */
public class PlusWorld {
    public static void addPlus(int i){
        int WIDTH = i*3;
        int HEIGHT = i*3;
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = i; x < i*2; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }
        for(int x = 0; x < WIDTH; x++){
            for(int y = i; y < i*2; y++) {
                world[x][y] = Tileset.WALL;
            }
        }
        // draws the world to the screen
        ter.renderFrame(world);
    }
    //Lower deadend room
    public static void addL(int i){
        int WIDTH = i*3;
        int HEIGHT = i*3;
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = i; x < i*2; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < i*2; y++) {
                world[x][y] = Tileset.WALL;
            }
        }
        // draws the world to the screen
        ter.renderFrame(world);
    }
    //Upper deadend room
    public static void addD(int i){
        int WIDTH = i*3;
        int HEIGHT = i*3;
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = i; x >= 0; x--) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x+i][y] = Tileset.WALL;
            }
        }
        for(int x = 0; x < HEIGHT; x++){
            for(int y = i; y < HEIGHT; y++) {
                world[x][y] = Tileset.WALL;
            }
        }
        // draws the world to the screen
        ter.renderFrame(world);
    }
    //Corner L
    public static void addX(int i){
        int WIDTH = i*3;
        int HEIGHT = i*3;
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = 0; x < i; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < i; y++) {
                world[x][y] = Tileset.WALL;
            }
        }
        // draws the world to the screen
        ter.renderFrame(world);
    }
    public static void addY(int i){
        int WIDTH = i*3;
        int HEIGHT = i*3;
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall
        for (int x = 0; x < HEIGHT; x += 1) {
            for (int y = 0; y < i; y += 1) {
                world[x][y] = Tileset.WALL;
            }
        }
        for(int x = 0; x < i; x++){
            for(int y = 0; y < WIDTH; y++) {
                world[x][y] = Tileset.WALL;
            }
        }
        // draws the world to the screen
        ter.renderFrame(world);
    }
    public static void main(String[] args){
            createRoom(2,2);
    }
    public static void createRoom(int width, int height){
        TERenderer ter = new TERenderer();
        ter.initialize(18, 18);
        TETile[][] world = new TETile[18][18];
        for (int x = 0; x < 6; x += 1) {
            for (int y = 0; y < 6; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                world[i][j] = Tileset.WALL;
                world[i + width][j] = Tileset.WALL;
                world[i][j] = Tileset.WALL;
                world[i][j+height] = Tileset.WALL;
            }
        }
        ter.renderFrame(world);

    }
    // can probably use a Room variable for this because I am not sure if the height and width
    //will stay constant so we would want to take the room we just created to access the data
//    public static void fillRoom(TETile[][] world, Position x, int width, int height){
//        for(int i = 1; i < width; i++){
//            for(int j = 1; j < height; j++){
//                world[x.getX() + i][x.getY() + j] = Tileset.FLOOR;
//            }
//        }
//    }
}
