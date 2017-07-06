# Misc
## How to post data
* curl -F key=123 -F value=123 -F topic=123 -F timestamp=123 -F partition=0 -H "Content-Type: multipart/form-data" http://127.0.0.1:8080/place_message

# TODO
* Support multiple partitions
* Support configuration for zk / kafka brokers / internal blocking queue size
* Configure topic / partition / offset through TopicPartition and PartitionOffset annotations.
* Configure the way to commit the ack to broker
* Save the records in blocking queue.
