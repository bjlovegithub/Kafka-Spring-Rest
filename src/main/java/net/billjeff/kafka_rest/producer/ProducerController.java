package net.billjeff.kafka_rest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to deliver the message to Kafka.
 */
@RestController
public class ProducerController {
	@Autowired
	public KafkaTemplate<String, String> template;

	@RequestMapping(value = "/place_message", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String processPlaceMessage(@Validated PutPost post) {
		if ((post.getValue() == null) || (post.getValue().isEmpty())) {
			return "value should not be empty";
		}
		template.send(post.getTopic(), post.getPartition(), post.getTimestamp(), post.getKey(), post.getValue());

		return "success";
	}
}
