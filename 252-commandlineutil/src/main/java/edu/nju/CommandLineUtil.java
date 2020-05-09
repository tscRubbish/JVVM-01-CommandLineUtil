package edu.nju;

import jdk.nashorn.internal.runtime.ParserException;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import org.apache.commons.cli.*;

import java.util.regex.Pattern;

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
        Option help=new Option("h","help",false,"打印出所有预定义的选项与用法");
        Option print=new Option("p","print",true,"打印出arg");
        Option sideEffect=new Option("s",false,"将CommandlineUtil中sideEffect变量置为true");
        options.addOption(help);
        options.addOption(print);
        options.addOption(sideEffect);
        parseInput(args);
    }

    /**
     * Print the usage of all options
     */
    private static void printHelpMessage() {
        System.out.println("help");
    }

    /**
     * Parse the input and handle exception
     * @param args origin args form input
     */
    public void parseInput(String[] args) {
        try {
            commandLine=parser.parse(options, args);
            handleOptions();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * You can handle options here or create your own func
     */
    public void handleOptions() throws ParserException {
        if (commandLine.hasOption("p")){
            if (!commandLine.hasOption("h")&&commandLine.getArgs().length>0)
                System.out.println(commandLine.getOptionValue("p"));
            else if (commandLine.getArgs().length==0||commandLine.getOptionValue("p").length()==0) {
                System.out.println(WRONG_MESSAGE);
                return;
            }
        }
        if (commandLine.hasOption("s")){
            if (!commandLine.hasOption("h")&&commandLine.getArgs().length>0)
                sideEffect=true;
            else if (commandLine.getArgs().length==0||commandLine.getOptionValue("p").length()==0) {
                System.out.println(WRONG_MESSAGE);
                return;
            }
        }
        if (commandLine.hasOption("h")){
            printHelpMessage();
        }
    }

    public boolean getSideEffectFlag(){
        return sideEffect;
    }

}
