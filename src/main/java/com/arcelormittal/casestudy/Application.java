/**
 * Case study application
 */

package com.arcelormittal.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application runnable class. This allows Spring Boot to run the application.
 * 
 * @author Pareek 
 *
 */
@SpringBootApplication
public class Application {

    /**
     * Runnable main method.
     * 
     * @param args execution parameters
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Default constructor.
     */
    public Application() {
        super();
    }

}
