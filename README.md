# KafkaPOC
Installation steps:
1.bin/zookeeper-server-start.sh config/zookeeper.properties.
2.bin/kafka-server-start.sh config/server.properties.
3.bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
4.bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic javaworld --from-beginning.
5. bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
