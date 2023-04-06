package hello;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class HelloWorldTests {

	@Test
	public void shouldPrintTimeToConsole() {
		// Get Logback Logger.
		Logger logger = (Logger) LoggerFactory.getLogger(HelloWorld.class);

		// Create and start a ListAppender.
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		logger.setLevel(Level.DEBUG);
		logger.addAppender(listAppender);
		listAppender.start();

		HelloWorld.main(new String[] { });

		AtomicInteger counter = new AtomicInteger(0);
		listAppender.list.forEach(iLoggingEvent -> {
			if (iLoggingEvent.getLevel() == Level.INFO &&
					iLoggingEvent.getMessage().contains("The current local time is")) {
				counter.incrementAndGet();
			}
		});
		assertEquals(0, counter.get());
	}

	@Test
	public void shouldPrintHelloWorldToConsole() {
		// Get Logback Logger.
		Logger logger = (Logger) LoggerFactory.getLogger(HelloWorld.class);

		// Create and start a ListAppender.
		ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
		listAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		logger.setLevel(Level.DEBUG);
		logger.addAppender(listAppender);
		listAppender.start();

		HelloWorld.main(new String[] { });

		AtomicInteger counter = new AtomicInteger(0);
		listAppender.list.forEach(iLoggingEvent -> {
			if (iLoggingEvent.getLevel() == Level.INFO &&
					iLoggingEvent.getMessage().contains("Hello world!")) {
				counter.incrementAndGet();
			}
		});

		assertEquals(0, counter.get());
	}
}
