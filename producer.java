import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class MessageProducer{
	String topicname="myprogram"; 
	KafkaProducer<String,String>kafkaProducer;
	public MessageProducer(Map<String,Object>producMap){
		kafkaProducer=new kafkaProducer<String,String>producMap);
	}
	public static Map<String,Object>producMap(){

		Map<String,String>producMap=new HashMap<>();
		producMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092","localhost:9093","localhost:9094");
		producMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		producMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		return producMap;
	}
	public void publishMessageSync(String key,String value){
		ProducerRecord<String,String>ProducerRecord=new ProducerRecord<>(topicName,key,value);
		try{
			RecordMetadata recordMetadata=kafkaProducer.send(producerRecord).get();
			System.out.println("Parition"+recordMetadata.partition()+",offset :"+recordMetadata.offset());
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		MessageProducer messageProducer=new MessageProducer(producMap());
		messageProducer.publishMessageSync(null,"Rohit");
	}

}

