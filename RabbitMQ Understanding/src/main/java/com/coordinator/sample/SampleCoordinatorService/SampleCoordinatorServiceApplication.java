package com.coordinator.sample.SampleCoordinatorService;

import com.rabbitmq.client.*;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SampleCoordinatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCoordinatorServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner producerConfig(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				ConnectionFactory connectionFactory = new ConnectionFactory();
//				Connection connection = connectionFactory.newConnection();
//				Channel channel = connection.createChannel();
//
//				String message = "First message from rabbit";
//
//				channel.basicPublish("", "queue1", null, message.getBytes());
//				channel.close();
//				connection.close();
//			}
//		};
//	}
//
//	@Bean
//	public CommandLineRunner consumerConfig(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				ConnectionFactory connectionFactory = new ConnectionFactory();
//				Connection connection = connectionFactory.newConnection();
//				Channel channel = connection.createChannel();
//
//				DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//					byte[] messageInBytes = delivery.getBody();//byte array
//					String messageInString = new String(messageInBytes);
//					System.out.println("Message Recieved from rabbitMq: " + messageInString);
//				};
//
//				CancelCallback cancelCallback = (consumerTag) -> {};
//
//				channel.basicConsume("queue1", Boolean.TRUE, deliverCallback, cancelCallback);
//			}
//		};
//	}


//	@Bean
//	public CommandLineRunner exampleWithJsonObject(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				JSONObject json = new JSONObject();
//				json.put("from_date", "01-Jan-2019");
//				json.put("to_date", "31-Dec-2019");
//				json.put("email", "xyz@gmail.com");
//				json.put("query", "select * from data");
//
//				ConnectionFactory factory = new ConnectionFactory();
//				Connection connection = factory.newConnection();
//				Channel channel = connection.createChannel();
//
//				channel.basicPublish("", "queue1", null, json.toString().getBytes());
//
//			};
//		};
//	}

//	@Bean
//	public CommandLineRunner consumerForJsonMessage(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				ConnectionFactory factory = new ConnectionFactory();
//				Connection connection = factory.newConnection();
//				Channel channel = connection.createChannel();
//
//				DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//					byte[] messageInBytes = delivery.getBody();
//					JSONObject jsonObject = new JSONObject(new String(messageInBytes));
//					System.out.println(jsonObject);
//				};
//
//				CancelCallback cancelCallback = (consumerTag) -> {};
//
//				channel.basicConsume("queue1", Boolean.TRUE, deliverCallback, cancelCallback);
//			}
//		};
//	}

//	@Bean
//	public CommandLineRunner directExchangeProducer(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				ConnectionFactory factory = new ConnectionFactory();
//				Connection connection = factory.newConnection();
//				Channel channel = connection.createChannel();
//
//				String messageMobile = "Published to Mobile queue";
//
//				channel.basicPublish("direct-exchange-example", "mobile", null, messageMobile.getBytes());
//
//				String messageAc = "Published to AC queue";
//
//				channel.basicPublish("direct-exchange-example", "ac", null, messageAc.getBytes());
//
//				String messageTV = "Published to TV queue";
//
//				channel.basicPublish("direct-exchange-example", "tv", null, messageTV.getBytes());
//			}
//		};
//	}

	@Bean
	public CommandLineRunner directExchangeConsumerMobile(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				ConnectionFactory factory = new ConnectionFactory();
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();

				DeliverCallback deliverCallback = (consumerTag, delivery)-> {
					byte[] messageInBytes = delivery.getBody();
					String message = new String(messageInBytes);
					System.out.println(message);
				};
				CancelCallback cancelCallback = (consumerTag) -> {};

				channel.basicConsume("Mobile", deliverCallback, cancelCallback);
			}
		};
	}


	@Bean
	public CommandLineRunner directExchangeConsumerAC(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				ConnectionFactory factory = new ConnectionFactory();
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();

				DeliverCallback deliverCallback = (consumerTag, delivery)-> {
					byte[] messageInBytes = delivery.getBody();
					String message = new String(messageInBytes);
					System.out.println(message);
				};
				CancelCallback cancelCallback = (consumerTag) -> {};

				channel.basicConsume("AC", deliverCallback, cancelCallback);
			}
		};
	}

	@Bean
	public CommandLineRunner directExchangeConsumerTV(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				ConnectionFactory factory = new ConnectionFactory();
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();

				DeliverCallback deliverCallback = (consumerTag, delivery)-> {
					byte[] messageInBytes = delivery.getBody();
					String message = new String(messageInBytes);
					System.out.println(message);
				};
				CancelCallback cancelCallback = (consumerTag) -> {};

				channel.basicConsume("TV", deliverCallback, cancelCallback);
			}
		};
	}

}
