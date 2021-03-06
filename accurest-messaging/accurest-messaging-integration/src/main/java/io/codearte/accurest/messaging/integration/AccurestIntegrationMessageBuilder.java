package io.codearte.accurest.messaging.integration;

import java.util.Map;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import io.codearte.accurest.messaging.AccurestMessage;
import io.codearte.accurest.messaging.AccurestMessageBuilder;

/**
 * @author Marcin Grzejszczak
 */
public class AccurestIntegrationMessageBuilder<T> implements AccurestMessageBuilder<T, Message<T>> {

	@Override
	public AccurestMessage<T, Message<T>> create(T payload, Map<String, Object> headers) {
		return new IntegrationMessage<>(MessageBuilder.createMessage(payload, new MessageHeaders(headers)));
	}

	@Override
	public AccurestMessage<T, Message<T>> create(Message<T> message) {
		if (message == null) {
			return null;
		}
		return new IntegrationMessage<>(message);
	}
}
