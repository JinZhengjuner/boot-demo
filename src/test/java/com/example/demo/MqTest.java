//package com.example.demo;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.compress.utils.Lists;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
//import org.apache.rocketmq.client.exception.MQBrokerException;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.MQProducer;
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.apache.rocketmq.remoting.exception.RemotingException;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//public class MqTest {
//    private static void sendMessage(MQProducer producer, Integer orderId) {
//        for (int i = 0; i < 5; i++) {
//            try {
//                Message msg =
//                        new Message("OrderTest", "TagA", i + "",
//                                (orderId + "").getBytes(RemotingHelper.DEFAULT_CHARSET));
//                SendResult sendResult = producer.send(msg, (mqs, msg1, arg) -> {
//                    Integer id = (Integer) arg;
//                    int index = id % mqs.size();
//                    return mqs.get(index);
//                }, orderId);
//                System.out.println("message send,orderId:" + orderId);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//
//    @Test
//    @SneakyThrows
//    public void send1() throws MQClientException {
//        DefaultMQProducer producer = new DefaultMQProducer("OrderTest_Group");
//        producer.setNamesrvAddr("123.60.19.184:9876");
//        //Launch the instance.
//        producer.start();
//
//        //顺序发送100条编号为0到99的，orderId为1 的消息
//        new Thread(() -> {
//            Integer orderId = 1;
//            sendMessage(producer, orderId);
//        }).start();
//        //顺序发送100条编号为0到99的，orderId为2 的消息
//        new Thread(() -> {
//            Integer orderId = 2;
//            sendMessage(producer, orderId);
//        }).start();
//
//        TimeUnit.SECONDS.sleep(5);
//
//        producer.shutdown();
//
//    }
//
//    private static void normal() throws MQClientException, InterruptedException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("example_group_name3");
//        consumer.setNamesrvAddr("123.60.19.184:9876");
//
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//
//        consumer.subscribe("OrderTest", "*");
//        consumer.setConsumeThreadMin(3);
//        consumer.setConsumeThreadMax(6);
//
//        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
//            log.info("daxiao:{}",msgs.size());
//            for (MessageExt msg : msgs) {
////                    System.out.println("收到消息," + new String(msg.getBody()));
//                System.out.println("queueId:"+msg.getQueueId()+",orderId:"+new String(msg.getBody())+",i:"+msg.getKeys());
//            }
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        });
//
//        consumer.start();
//        Thread.sleep(20000);
//
//        System.out.printf("Consumer Started.%n");
//    }
//
//
//    private static void order() throws MQClientException, InterruptedException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("example");
//        consumer.setNamesrvAddr("123.60.19.184:9876");
//
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//
//        consumer.subscribe("OrderTest", "*");
//        //消费者并行消费
//        consumer.setConsumeThreadMin(3);
//        consumer.setConsumeThreadMax(6);
//
//        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
////                context.setAutoCommit(false);
//            log.info("daxiao:{}", msgs.size());
//            for (MessageExt msg : msgs) {
//                System.out.println("queueId:"+msg.getQueueId()+",orderId:"+new String(msg.getBody())+",i:"+msg.getKeys());
//            }
//            return ConsumeOrderlyStatus.SUCCESS;
//        });
//
//        consumer.start();
//        Thread.sleep(10000);
//
//        System.out.printf("Consumer Started.%n");
//    }
//
//
//    @Test
//    public void cosumer1() throws MQClientException, InterruptedException {
////        normal();
//        order();
//    }
//
//    @Test
//    public void test(){
//        List<Integer> list1 = Arrays.asList(1);
//        List<Integer> list2 = Arrays.asList(2);
//        List<Integer> list3 = Arrays.asList(3);
//        List<List<Integer>> list = new ArrayList<>();
//        list.add(list1);
//        list.add(list2);
//        list.add(list3);
//        list.stream().reduce(Lists.newArrayList(), (a, b) ->  {
//            a.addAll(b);
//            return a;
//        });
//
//
//
//    }
//
//    @Test
//    public void consumer() throws MQClientException, InterruptedException {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("cg");
//        consumer.setNamesrvAddr("123.60.19.184:9876");
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
//        consumer.subscribe("someTopic", "*");
//        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
//            for (MessageExt msg : msgs) {
//                System.out.println(msg);
//            }
//            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//        });
//        consumer.start();
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void send() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
//        //创建一个producer，参数为Producer Group名称
//        DefaultMQProducer producer = new DefaultMQProducer("pg");
//        producer.setDefaultTopicQueueNums(2);
//        producer.setNamesrvAddr("123.60.19.184:9876");
//        producer.start();
//        for (int i = 0; i < 10; i++) {
//            byte[] body = ("Hi," + i).getBytes();
//            Message msg = new Message("someTopic", "someTag", body);
//            msg.setTags("tag" + i);
//            msg.setDelayTimeLevel(3);
//            producer.send(msg, new SendCallback() {
//                @Override
//                public void onSuccess(SendResult sendResult) {
////                    log.info(JSON.toJSONString(sendResult));
//                    System.out.println(sendResult);
//                }
//
//                @Override
//                public void onException(Throwable e) {
//                    e.printStackTrace();
//                }
//            });
//
//        }
//        Thread.sleep(1000);
//        producer.shutdown();
//    }
//
//
//}