package producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

	public static void producer() {
		String topicName = "test";
         boolean flag=true;
         int x=0;
		// Configure the Producer
		Properties configProperties = new Properties();
		configProperties.put("bootstrap.servers", "http://127.0.0.1:9092");
		configProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		configProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String, String>(
				configProperties);
		while(flag){
		producer.send(new ProducerRecord<String, String>(topicName, generateRandomString(10),generateRandomInt()));
		x++;
		if(x==9999999){
			flag=false;
		}
		}
		producer.close();
	}
	
	
	public static String generateRandomString(int len){
		 String str="ajdskfwabcbshsgeyruy!@#$%%^&&&***()ASASexhtu3i4y zio4tu43oty 49cpi5y4o8623347323547";
		 char  charArr []=new char[len]; 
		 for(int i=0;i<len;i++){
			 int value=(int) (Math.random()*len);
			 char charvalue=str.charAt(value);
			 charArr[i]=charvalue;
		 }
		
		return String.copyValueOf(charArr);
	}
	
	
	public static String generateRandomInt(){
		return String.valueOf((int) (Math.random()*999999));
	}
}



