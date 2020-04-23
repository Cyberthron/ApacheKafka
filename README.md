# ApacheKafka

<p>Apache Kafka is a community distributed event streaming platform capable of handling trillions of events a day. Initially conceived as a messaging queue, Kafka is based on an abstraction of a distributed commit log. Since being created and open sourced by LinkedIn in 2011, Kafka has quickly evolved from messaging queue to a full-fledged event streaming platform.

Founded by the original developers of Apache Kafka, Confluent delivers the most complete distribution of Kafka with Confluent Platform. Confluent Platform improves Kafka with additional community and commercial features designed to enhance the streaming experience of both operators and developers in production, at massive scale.</p>

**Install ApacheKafka On Ubantu**

    sudo apt update<br>
    sudo apt install default-jdk<br>
  
**Download Apache Kafka**<br>

    wget http://www-us.apache.org/dist/kafka/2.4.0/kafka_2.13-2.4.0.tgz <br>
  
 **Then extract the archive file**<br>
 
    tar xzf kafka_2.13-2.4.0.tgz<br>
    cd kafka_2.12-2.4.1<br>
  
  **Start Server**<br>
  
    bin/zookeeper-server-start.sh config/zookeeper.properties<br>
    bin/kafka-server-start.sh config/server.properties<br>
  
  **Create Topic**<br>
  
    bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic topic_name
  <br>
  
  **Send Message from Producer Server**<br>
  
    bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic_name<br>
    >hi<br>
    >Hello
  <br>
  
  **Open another terminal for Consumer Server and get the message sended by Producer**<br>
  
    bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic_name --from-beginning<br>
    >hi<br>
    >Hello<br>
  
  **Multiple Broker**<br>
  
    cp config/server.properties config/server-1.properties<br>
    cp config/server.properties config/server-2.properties<br>
  
  **Now edit these new files and set the following properties:**
  
        config/server-1.properties:
        broker.id=1<br>
        listeners=PLAINTEXT://:9093<br>
        log.dirs=/tmp/kafka-logs-1<br>
        
    
        config/server-2.properties:<br>
        broker.id=2<br>
        listeners=PLAINTEXT://:9094<br>
        log.dirs=/tmp/kafka-logs-2<br>
        
 **Start the two new nodes :**<br>

    > bin/kafka-server-start.sh config/server-1.properties &
    > bin/kafka-server-start.sh config/server-2.properties &


**Sources**<br>

    https://kafka.apache.org/quickstart

    
  
  

  
  
  
  
