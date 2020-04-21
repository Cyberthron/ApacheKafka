package com.learnkafka.consumers;
import org.apache.kafka.clients.consumer.kafkaconsumer;
public class MessageConsumer{
	
	//this consumer accept the key and value
	kafkaConsumer<String,String>kafkaConsumer;
	String topicName="myprogram-replicated";

	//create a constructor
	public MessageConsumer(Map<String,Object>producMap){

		//Hash map hold the consumer propertices
		kafkaConsumer=new KafkaConsumer<String,String>(producMap);
	
	}
	public static Map<String,Object>buildconsumerPropertices(){

		Map<String,Object>producMap=new HASHMap<>();
		producMap.put(consumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092","localhost:9093","localhost:9094");
		producMap.put(consumerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		producMap.put(consumerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		return producMap;
	}
	//poll the kafka from continuesly from new records 
	public pollkafka(){
			kafkaConsumer.subcribe(List.of(topicname));
		kafkaConsumer.poll();
	}
	public static void main(String[]args){
		//create instances 
		MessageConsumer messageConsumer=new MessageConsumer(buildconsumerPropertices());	
		kafkaConsumer.pollkafka();	
		
	
	}
}
