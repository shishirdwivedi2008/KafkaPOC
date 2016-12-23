package producer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Consumer {

	public static void consumer() {
		Properties property = new Properties();
		property.put("bootstrap.servers", "http://127.0.0.1:9092");
		property.put("group.id", "test");
		property.put("enable.auto.commit", "true");
		property.put("auto.commit.interval.ms", "1000");
		property.put("session.timeout.ms", "30000");
		property.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		property.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(property);
		consumer.subscribe(Arrays.asList("test"));
		while(true){
			ConsumerRecords<String, String> records=consumer.poll(1);
			for(ConsumerRecord<String, String>record:records){
				System.out.println("Offest:"+record.offset()+" "+"Key: "+record.key()+" "+"Value "+record.value());
			}
		}
	}

}
