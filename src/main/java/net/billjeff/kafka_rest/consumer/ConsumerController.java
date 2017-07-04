package net.billjeff.kafka_rest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.SettableListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Controller to retrieve Kafka messages.
 */
@RestController
public class ConsumerController {

	@Autowired
    private LinkedBlockingQueue<SettableListenableFuture<String>> queue;

	@RequestMapping(value = "/receive_message", method = RequestMethod.GET)
	public String processReceiveMessage() {
		try {
			return queue.take().get(60, TimeUnit.SECONDS);
		}
		catch (Exception e) {
			return e.toString();
		}
	}
}
