package com.korlimann.korlisfoodcraft.util;


import org.apache.logging.log4j.Level;
import static org.apache.logging.log4j.Level.*;
import static org.apache.logging.log4j.Level.WARN;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ConsoleLogger {

	private static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
	
	//this is a default private constructor to prevent object initialisation
	private ConsoleLogger() {}
	
	public static void log(Level level,Object msg)
	{
		logger.log(level, String.valueOf(msg));
	}
	
	public static void all(Object message){
        log(ALL, message);
    }

    public static void debug(Object message){
        log(DEBUG, message);
    }

    public static void error(Object message){
        log(ERROR, message);
    }

    public static void fatal(Object message){
        log(FATAL, message);
    }

    public static void info(Object message){
        log(INFO, message);
    }

    public static void off(Object message){
        log(OFF, message);
    }

    public static void trace(Object message){
        log(TRACE, message);
    }

    public static void warn(Object message){
        log(WARN, message);
    }
}
