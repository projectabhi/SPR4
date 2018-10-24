package com.dashboard.ws.datagen;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dashboard.spring.service.ClientRequestService;

@Component
public class RandomDataGenerator implements
    ApplicationListener<BrokerAvailabilityEvent> {
	
	final Logger logger=Logger.getLogger(RandomDataGenerator.class);

    private final MessageSendingOperations<String> messagingTemplate;
    
    @Autowired
    private SimpMessagingTemplate template;
    
    @Autowired
    private ClientRequestService clientRequestService;

    @Autowired
    public RandomDataGenerator(
        final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onApplicationEvent(final BrokerAvailabilityEvent event) {
    }

    @Scheduled(fixedDelay = 1000)
    public void sendDataUpdates() {
    	Integer count=this.clientRequestService.getViews();
    	logger.info("Count:"+count);
        this.messagingTemplate.convertAndSend(
            "/data", count);
        this.template.convertAndSend("/data", count);
    }
}