#!/bin/bash

mkdir -p ./mysql/data
mkdir -p ./mysql/conf

mkdir -p ./rabbitmq/data

mkdir -p ./redis/data

mkdir -p ./mongodb-data

mkdir -p ./nacos/logs
mkdir -p ./nacos/data

mkdir -p ./logstash/config

# 导入logstash配置
curl -o ./logstash/config/logstash.conf https://raw.githubusercontent.com/echonanguo/lemall/refs/heads/master/doc/conf/logstash.conf

mkdir -p ./elasticsearch/data
mkdir -p ./elasticsearch/plugins
mkdir -p ./elasticsearch/logs

# 下载ik分词器
curl -o ./ik.zip https://release.infinilabs.com/analysis-ik/stable/elasticsearch-analysis-ik-8.10.4.zip
mkdir ./elasticsearch/plugins/ik
unzip ./ik.zip -d ./elasticsearch/plugins/ik
rm ./ik.zip

mkdir -p ./minio/data
echo "文件已创建"
