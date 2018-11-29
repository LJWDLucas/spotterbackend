package com.spotter.backend;
import com.spotter.backend.services.Routes;
import org.apache.log4j.BasicConfigurator;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        BasicConfigurator.configure();
        Routes route = new Routes();
    }
}