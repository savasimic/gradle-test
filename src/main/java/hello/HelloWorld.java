package hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.LocalTime;

public class HelloWorld {
  protected static final Logger logger = LogManager.getLogger(HelloWorld.class);

  public static void main(String[] args) {
	LocalTime currentTime = new LocalTime();
	logger.info("The current local time is: " + currentTime);

	Greeter greeter = new Greeter();
	logger.info(greeter.sayHello());
  }
}