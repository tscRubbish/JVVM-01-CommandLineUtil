package edu.nju;

import org.apache.commons.cli.*;

public class CommandLineUtil {
    private static CommandLine commandLine;
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();
    private boolean sideEffect;
    public static final String WRONG_MESSAGE = "Invalid input.";

    /**
     * you can define options here
     * or you can create a func such as [static void defineOptions()] and call it before parse input
     */
    static {
    }

    public void main(String[] args){

    }

    /**
     * Print the usage of all options
     */
    private static void printHelpMessage() {
    }

    /**
     * Parse the input and handle exception
     * @param args origin args form input
     */
    public void parseInput(String[] args) {
    }

    /**
     * You can handle options here or create your own func
     */
    public void handleOptions() {
    }

    public boolean getSideEffectFlag(){
    }

}
