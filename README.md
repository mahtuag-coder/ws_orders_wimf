# WS Orders Kafka Setup

This guide helps you start Kafka locally on Windows, create topics, and test producing/consuming messages for the WS Orders project.

---

## Prerequisites

- Java installed and `JAVA_HOME` configured
- Kafka downloaded to `C:\kafka`

---

## 1️⃣ Start Zookeeper

Open a terminal and run:

```powershell
cd C:\kafka
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
---
## 2️⃣ Start Kafka Broker

Open a new terminal and run:

```powershell
cd C:\kafka
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
---

## 3️⃣ Create Topic

```powershell
cd C:\kafka
.\bin\windows\kafka-topics.bat --create --topic wsmy-order-created --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```
---

## 4️⃣ List Topics

```powershell
cd C:\kafka
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```

Expected output:

wsmy-order-created

---

## 5️⃣ Produce Messages (Test)

```powershell
cd C:\kafka
.\bin\windows\kafka-console-producer.bat --topic wsmy-order-created --bootstrap-server localhost:9092
```

Type a sample JSON message:

{"orderId":"1","orderStatus":"CREATED","customerName":"John Doe","customerPhone":"1234567890","deliveryAddress":"123 Main St"}


Press Enter to send.

---

## 6️⃣ Consume Messages (Test)

```powershell
cd C:\kafka
.\bin\windows\kafka-console-consumer.bat --topic wsmy-order-created --bootstrap-server localhost:9092 --from-beginning
```

You should see the messages you sent above.