package com.m41highway.drawing;

import java.util.Scanner;
import java.io.PrintStream;

public class DrawingApp {

    private Scanner myScanner;
    private PrintStream myOut;

    private int column =0;
    private int row =0;
    private final String EMPTY = " ";
    private final String LINE = "X";
    private final String HFRAME = "-";
    private final String VFRAME = "|";
    private String [][] canvas;

    // ----------------------------------------
    // Initialize the canvas
    // ----------------------------------------
    private void clean() {
        for (int r=0; r< row ; r++) {
            for (int c=0 ; c < column ; c++) {
                canvas[c][r] = EMPTY;
            }
        }
    }

    // ----------------------------------------
    // horizontal frame line
    // ----------------------------------------
    private void hFrame(int c1, int r1, int c2, int r2, String [][] canvas, String symbol) {
        for (int c = c1 ; c < c2; c++) {
            canvas[c][r1] = symbol;
        }
    }

    // ----------------------------------------
    // vertical frmae line
    // ----------------------------------------
    private void vFrame(int c1, int r1, int c2, int r2, String [][] canvas, String symbol) {
        for (int r = r1; r < r2 ; r++) {
            canvas[c1][r] = symbol;
        }
    }

    // ----------------------------------------
    // horizontal line
    // The input is not zero based
    // Inclusive
    // ----------------------------------------
    private static void hLine(int c1, int r1, int c2, int r2, String [][] canvas, String symbol) {
        for (int c = c1 ; c <= c2; c++) {
            canvas[c][r1] = symbol;
        }
    }

    // ----------------------------------------
    // vertical line
    // The input is not zero based
    // Inclusive
    // ----------------------------------------
    private static void vLine(int c1, int r1, int c2, int r2, String [][] canvas, String symbol) {
        for (int r = r1; r <= r2 ; r++) {
            canvas[c1][r] = symbol;
        }
    }
    // ----------------------------------------
    // Render by row from top to bottom
    // ----------------------------------------
    private void render() {
        String temp = "";
        for (int r=0; r < row ; r++) {
            // String temp = "";
            for (int c=0; c < column ; c++) {
                temp = temp + canvas[c][r];
            }
            // System.out.println(temp);
            temp = temp + "\r\n";
        }
        this.myOut.println(temp);
    }

    // ----------------------------------------
    // Fill
    // ----------------------------------------
    private void fill(int x, int y, String [][] canvas, String symbol) {

        if (EMPTY.equals(canvas[x][y])) {
            canvas[x][y] = symbol;

            int left = x - 1;
            int right = x + 1;
            int up = y - 1 ;
            int down = y + 1;

            fill(left, y, canvas, symbol);

            fill(right, y, canvas, symbol);

            fill(x, up, canvas, symbol);

            fill(x, down, canvas, symbol);
        }
    }


	public DrawingApp(Scanner scanner, PrintStream out) {
        this.myScanner = scanner;
        this.myOut = out;
	}

	public void run() {
        this.myOut.println("Welcome to DrawingApp!");

        boolean go = true;

        LOOP1:
        while(go) {

            this.myOut.println("enter command:");

            while(this.myScanner.hasNext()) {


                String input = myScanner.next();
                input = input.replaceAll("\\s{2,}", " ").trim();
                String [] commands = input.split(" ");



                switch(commands[0]){
                    case "C":
                        try {
                            column = Integer.parseInt(commands[1]) + 2;
                            row = Integer.parseInt(commands[2]) + 2;

                            if (column <= 3 && row <= 3) throw new Exception("The canvas is too small! Please create again");
                            if (column >= 120 || row >= 180) throw new Exception("The canvas is too big! Please create again");

                            canvas = new String[column][row];

                            clean();

                            // ---------------------------------
                            // Setup the frame
                            // ---------------------------------
                            hFrame(0, 0, column, 0, canvas, HFRAME);
                            hFrame(0, row-1, column, row-1, canvas, HFRAME);
                            vFrame(0, 1, 0, row-1, canvas, VFRAME);
                            vFrame(column-1, 1, column-1, row-1, canvas, VFRAME);

                            render();

                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        } finally {
                            break;
                        }

                    case "L":

                        try {
                            if (column ==0 && row == 0) throw new Exception("Please create canvas before you draw!");

                            if (commands.length != 5) throw new Exception("Wrong parameters! Example: L 3 5 9 5");

                            int c1 = Integer.parseInt(commands[1]);
                            int r1 = Integer.parseInt(commands[2]);
                            int c2 = Integer.parseInt(commands[3]);
                            int r2 = Integer.parseInt(commands[4]);

                            if (c1 > column - 2 || c2 > column -2) throw new Exception("You cannot draw beyond the canvas!");
                            if (r1 > row -2 || r2 > row -2) throw new Exception("You cannot draw beyond the canvas!");
                            if (c1 == 0 || c2 == 0) throw new Exception("You cannot draw beyond the canvas!");
                            if (r1 == 0 || r2 == 0) throw new Exception("You cannot draw beyond the canvas!");

                            if (c1 == c2) { // vLine
                                vLine(c1, r1, c2, r2, canvas, LINE);
                                render();
                            } else if (r1 == r2) {
                                hLine(c1, r1, c2, r2, canvas, LINE);
                                render();
                            } else {
                                throw new Exception("You can only draw horizontal and vertical line");
                            }

                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        } finally {
                            break;
                        }

                    case "R":
                        try {
                            if (commands.length != 5) throw new Exception("Wrong parameters! Example: R 3 5 12 16");

                            int c1 = Integer.parseInt(commands[1]);
                            int r1 = Integer.parseInt(commands[2]);
                            int c2 = Integer.parseInt(commands[3]);
                            int r2 = Integer.parseInt(commands[4]);

                            if (c1 > column - 2 || c2 > column -2) throw new Exception("You cannot draw beyond the canvas!");
                            if (r1 > row -2 || r2 > row -2) throw new Exception("You cannot draw beyond the canvas!");
                            if (c1 == 0 || c2 == 0) throw new Exception("You cannot draw beyond the canvas!");
                            if (r1 == 0 || r2 == 0) throw new Exception("You cannot draw beyond the canvas!");

                            vLine(c1, r1, c1, r2, canvas, LINE);
                            vLine(c2, r1, c2, r2, canvas, LINE);

                            hLine(c1, r1, c2, r1, canvas, LINE);
                            hLine(c1, r2, c2, r2, canvas, LINE);

                            render();

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } finally {
                            break;
                        }

                    case "B":
                        try {
                            if (commands.length != 4) throw new Exception("Wrong parameters! Example: B 3 5 o");

                            int x = Integer.parseInt(commands[1]);
                            int y = Integer.parseInt(commands[2]);
                            String symbol = commands[3];

                            if (symbol.length() > 1) throw new Exception("The color parameter accepts only one character!");

                            if (x > column - 2) throw new Exception("You can only fill in the canvas!");

                            if (y > row - 2) throw new Exception("You can only fill in the canvas!");

                            fill(x, y, canvas, symbol);

                            render();

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        } finally {
                            break;
                        }
                    case "Q":
                    case "q":
                        go = false;
                        break LOOP1;
                    default:
                        System.out.println("Invalid command!");
                }
                this.myOut.println("enter command:");
            }
		}
        this.myOut.println("Exit!");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));

		DrawingApp app = new DrawingApp(scanner, System.out);
		app.run();
	}
}