# ApacheKafka

<p>Apache Kafka is a community distributed event streaming platform capable of handling trillions of events a day. Initially conceived as a messaging queue, Kafka is based on an abstraction of a distributed commit log. Since being created and open sourced by LinkedIn in 2011, Kafka has quickly evolved from messaging queue to a full-fledged event streaming platform.

Founded by the original developers of Apache Kafka, Confluent delivers the most complete distribution of Kafka with Confluent Platform. Confluent Platform improves Kafka with additional community and commercial features designed to enhance the streaming experience of both operators and developers in production, at massive scale.</p>

**Advantages of Apache Kafka**

  1.Low Latency: Apache Kafka offers low latency value, i.e., upto 10 milliseconds. It is because it decouples the message which lets the consumer to consume that message anytime.
    
   2.High Throughput: Due to low latency, Kafka is able to handle more number of messages of high volume and high velocity. Kafka can support thousands of messages in a second. Many companies such as Uber use Kafka to load a high volume of data.
    
   3.Fault tolerance: Kafka has an essential feature to provide resistant to node/machine failure within the cluster.
    Durability: Kafka offers the replication feature, which makes data or messages to persist more on the cluster over a disk. This makes it durable.
    
   4.Reduces the need for multiple integrations: All the data that a producer writes go through Kafka. Therefore, we just need to create one integration with Kafka, which automatically integrates us with each producing and consuming system.
    
   5. Easily accessible: As all our data gets stored in Kafka, it becomes easily accessible to anyone.
    
   6.Distributed System: Apache Kafka contains a distributed architecture which makes it scalable. Partitioning and replication are the two capabilities under the distributed system.
    
   7.Real-Time handling: Apache Kafka is able to handle real-time data pipeline. Building a real-time data pipeline includes processors, analytics, storage, etc.
    
   8.Batch approach: Kafka uses batch-like use cases. It can also work like an ETL tool because of its data persistence capability.
    
   9.Scalability: The quality of Kafka to handle large amount of messages simultaneously make it a scalable software product.

**Disadvantages Of Apache Kafka**

   1.Do not have complete set of monitoring tools: Apache Kafka does not contain a complete set of monitoring as well as managing tools. Thus, new startups or enterprises fear to work with Kafka.
    
   2.Message tweaking issues: The Kafka broker uses system calls to deliver messages to the consumer. In case, the message needs some tweaking, the performance of Kafka gets significantly reduced. So, it works well if the message does not need to change.
   
   3.Do not support wildcard topic selection: Apache Kafka does not support wildcard topic selection. Instead, it matches only the exact topic name. It is because selecting wildcard topics make it incapable to address certain use cases.
    
   4.Reduces Performance: Brokers and consumers reduce the performance of Kafka by compressing and decompressing the data flow. This not only affects its performance but also affects its throughput.
    
   5.Clumsy Behaviour: Apache Kafka most often behaves a bit clumsy when the number of queues increases in the Kafka Cluster.
    
   6.Lack some message paradigms: Certain message paradigms such as point-to-point queues, request/reply, etc. are missing in Kafka for some use cases.
    
**UseCases of Apache Kafka**

  a. Kafka Messaging
  
  <p> As we know, Kafka is a distributed publish-subscribe messaging system. So, for a more traditional message broker, Kafka works well as a replacement. For a variety of reasons, we use Message brokers. For example, to decouple processing from data producers, to buffer unprocessed messages and many more.
    However, Kafka has better throughput, built-in partitioning, replication, and fault-tolerance, in comparison to most other messaging systems. That makes it a good solution for large-scale message processing applications.</p>

b. Website Activity Tracking

<p>
    To be able to rebuild a user activity tracking pipeline as a set of real-time publish-subscribe feeds, it is the original Use Case for Kafka. That implies site activity is published to central topics with one topic per activity type. Here, site activity refers to page views, searches, or other actions users may take.</p>

c. Kafka Metrics

<p> For operational monitoring data, Kafka is often used. In addition, to produce centralized feeds of operational data, it includes aggregating statistics from distributed applications.</p>

d. Kafka Log Aggregation

<p>
    In order to collect logs from multiple services and make them available in a standard format to multiple consumers, we can use Kafka across an organization.</p.

e. Stream Processing

<p>
    However, there are some popular frameworks which read data from a topic, processes it, and write processed data to a new topic, where it becomes available for users and applications, such as Storm and Spark Streaming. In the context of stream processing, Kafka’s strong durability is also very useful.</p>

f. Kafka Event Sourcing

<p>
    Basically, when state changes are logged as a time-ordered sequence of records, then event sourcing is a style of application design. Also, we can say Kafka is an excellent backend for an application built in this style. Because it supports for a very large stored log.</p>

g. Commit Log

<p> While it comes to a distributed system, Kafka can serve as a kind of external commit-log for it. Generally, it replicates data between nodes. Also, acts as a re-syncing mechanism for failed nodes to restore their data. The feature of log compaction in Kafka helps to support this usage. However, Kafka is the same as Apache BookKeeper project, in this usage.
    </p>
    
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

    
  
  

  
  
  
  
