package com.m41highway.drawing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

// -------------------------------------------------------------------------------------
// In each test case, multiple commands are input to illustrate the result of the
// operation. A dedicated character "#" is used to delimit the commands. E.g.
// C 6 10 # L 4 4 10 4 # Q
// This example contains three consecutive commands:
// 1. "C 6 10" means to create a canvas with with 6 and height 10
// 2. "L 4 4 10 4" means to draw a line from coordinate (4, 4) to (10, 4)
// 3 "Q" means quit the application. Note that it must be aded in every test case,
//   otherwise the test case is pending.
// -------------------------------------------------------------------------------------
public class DrawingAppTest {

    private final String NEWLINE = "\r\n";


    // -------------------------------------------------------------------------------------
    // 1. Test if it can create the canvas with the correct width and height
    // -------------------------------------------------------------------------------------
    @Test
	public void createCanvas() throws Exception {
		final String newLine = System.getProperty("line.separator");

		final Scanner scanner = new Scanner("C 15 15 # Q #");
        scanner.useDelimiter("#");

		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);

        final DrawingApp app = new DrawingApp(scanner, out);
		app.run();

		final String output = outputBuffer.toString();

        System.out.println("....................... CREATE CANVAS ...........................................");
        System.out.println(output);
        System.out.println("..................................................................................");

		assertTrue(output.startsWith("Welcome to DrawingApp!"));

        String expected =
        "-----------------" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "|               |" + NEWLINE +
        "-----------------" + NEWLINE;

        assertTrue(output.contains(expected));

        scanner.close();
	}

    // -------------------------------------------------------------------------------------
    // 2. Test if it can first create the canvas with the correct width and height, then
    //    draw a horizontal straight line
    // -------------------------------------------------------------------------------------
    @Test
	public void drawHorizontalLine() throws Exception {
        final String newLine = System.getProperty("line.separator");

		final Scanner scanner = new Scanner("C 10 10 # L 2 2 8 2 # Q #");
        scanner.useDelimiter("#");

		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);

        final DrawingApp app = new DrawingApp(scanner, out);
		app.run();

		final String output = outputBuffer.toString();

        System.out.println("....................... DRAW HORIZONTAL LINE .....................................");
        System.out.println(output);
        System.out.println("..................................................................................");

		assertTrue(output.startsWith("Welcome to DrawingApp!"));


        String expected =
        "------------" + NEWLINE +
        "|          |" + NEWLINE +
        "| XXXXXXX  |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "|          |" + NEWLINE +
        "------------" + NEWLINE;

        assertTrue(output.contains(expected));

        scanner.close();
    }


    // -------------------------------------------------------------------------------------
    // 3. Test if it can first create the canvas with the correct width and height, then
    //    draw a horizontal straight line
    // -------------------------------------------------------------------------------------
    @Test
	public void drawVecticalLine() throws Exception {
        final String newLine = System.getProperty("line.separator");

		final Scanner scanner = new Scanner("C 18 18 # L 5 10 5 18 # Q #");
        scanner.useDelimiter("#");

		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);

        final DrawingApp app = new DrawingApp(scanner, out);
		app.run();

		final String output = outputBuffer.toString();

        System.out.println("....................... DRAW VECTICAL LINE .......................................");
        System.out.println(output);
        System.out.println("..................................................................................");

		assertTrue(output.startsWith("Welcome to DrawingApp!"));

        String expected =
        "--------------------" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|                  |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "|    X             |" + NEWLINE +
        "--------------------" + NEWLINE;

        assertTrue(output.contains(expected));

        scanner.close();
    }

    // -------------------------------------------------------------------------------------
    // 4. Test if it can first create the canvas with the correct width and height, then
    //    draw a rectangle
    // -------------------------------------------------------------------------------------
    @Test
	public void drawRectangle() throws Exception {
        final String newLine = System.getProperty("line.separator");

		final Scanner scanner = new Scanner("C 12 12 # R 2 2 8 6 # Q #");
        scanner.useDelimiter("#");

		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);

        final DrawingApp app = new DrawingApp(scanner, out);
		app.run();

		final String output = outputBuffer.toString();

        System.out.println("....................... DRAW RECTANGLE  .........................................");
        System.out.println(output);
        System.out.println("..................................................................................");

		assertTrue(output.startsWith("Welcome to DrawingApp!"));

        String expected =
        "--------------" + NEWLINE +
        "|            |" + NEWLINE +
        "| XXXXXXX    |" + NEWLINE +
        "| X     X    |" + NEWLINE +
        "| X     X    |" + NEWLINE +
        "| X     X    |" + NEWLINE +
        "| XXXXXXX    |" + NEWLINE +
        "|            |" + NEWLINE +
        "|            |" + NEWLINE +
        "|            |" + NEWLINE +
        "|            |" + NEWLINE +
        "|            |" + NEWLINE +
        "|            |" + NEWLINE +
        "--------------" + NEWLINE;
        assertTrue(output.contains(expected));

        scanner.close();
    }

    // -------------------------------------------------------------------------------------
    // 5. Test if it can first create the canvas with the correct width and height, then
    //    draw a rectangle, and the fill color in the rectangle
    // -------------------------------------------------------------------------------------
    @Test
	public void fillRectangle() throws Exception {
        final String newLine = System.getProperty("line.separator");

		final Scanner scanner = new Scanner("C 25 25 # R 12 12 18 18 # B 15 15 o # Q #");
        scanner.useDelimiter("#");

		ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outputBuffer);

        final DrawingApp app = new DrawingApp(scanner, out);
		app.run();

		final String output = outputBuffer.toString();

        System.out.println("....................... FILL RECTANGLE ...........................................");
        System.out.println(output);
        System.out.println("..................................................................................");

		assertTrue(output.startsWith("Welcome to DrawingApp!"));

        String expected =
        "---------------------------" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|           XXXXXXX       |" + NEWLINE +
        "|           XoooooX       |" + NEWLINE +
        "|           XoooooX       |" + NEWLINE +
        "|           XoooooX       |" + NEWLINE +
        "|           XoooooX       |" + NEWLINE +
        "|           XoooooX       |" + NEWLINE +
        "|           XXXXXXX       |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "|                         |" + NEWLINE +
        "---------------------------" + NEWLINE;

        assertTrue(output.contains(expected));

        scanner.close();
    }


}