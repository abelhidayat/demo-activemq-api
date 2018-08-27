package com.abel.activemqapi.demoactivemqapi.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class ProducerService {
    private static final String topicName = "FooTopic";
    private static final String queueName = "FooQueue";

    public void produceQueue(String msg){
        try {
            // Create a connection factory.
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

            //Create connection.
            Connection connection = factory.createConnection();

            // Start the connection
            connection.start();

            // Create a session which is non transactional
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create Destination queue
            Destination queue = session.createQueue(queueName);

            // Create a producer
            MessageProducer producer = session.createProducer(queue);

            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            // insert message
            TextMessage message = session.createTextMessage(msg);
            System.out.println("Queue Producer ("+queueName+") Sent : " + msg);
            producer.send(message);

            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Something error");
        }
    }

    public void produceTopic(String msg){
        try {
            // Create a connection factory.
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

            //Create connection.
            Connection connection = factory.createConnection();

            // Start the connection
            connection.start();

            // Create a session which is non transactional
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create Destination queue
            Destination topic = session.createTopic(topicName);

            // Create a producer
            MessageProducer producer = session.createProducer(topic);


            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // insert message
            TextMessage message = session.createTextMessage(msg);
            System.out.println("Topic Producer ("+topicName+") Sent: " + msg);
            producer.send(message);

            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Something error");
        }
    }
}
