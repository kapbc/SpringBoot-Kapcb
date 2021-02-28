package com.kapcb.ccc;

import com.kapcb.ccc.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootKapcbAmqpApplicationTests {

    private static final int INITIAL_CAPACITY = 2;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void testAmqpAdmin(){
        //创建一个转换器，默认为 direct 也可进行指定修改
        //this.amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

        //创建一个队列
        //this.amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE,
                "amqpadmin.exchange",
                "amqpadmin.hello",
                null));


        System.out.println("创建完成");
    }



    /**
     * 单播（点对点）
     * 三个参数 交换器 路由键 自定义信息
     * message需要自己构造，可以定制消息内容和消息头
     * rabbitTemplate.send(exchange,routeKey,message);
     * <p>
     * 比较简单的：
     * 三个参数 交换器 路由键 需要发送的对象
     * 它会自动序列化发送给RabbitMQ，其中object默认当成消息体
     * rabbitTemplate.convertAndSend(exchange,routeKey,object);
     */
    @Test
    public void testRabbit() {
        Map<String, Object> map = new HashMap<>(INITIAL_CAPACITY);
        map.put("msg", "Hello World!");
        map.put("author", "kapcb");
        // 对象被默认序列化之后发送
        rabbitTemplate.convertAndSend("exchange:direct", "kapcb.news", map);
    }

    /**
     * 接受消息
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("kapcb.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 多播
     */
    @Test
    public void batch() {
        rabbitTemplate.convertAndSend("exchange:fanout", "kapcb.news", new Book("张三", "法外狂徒"));
    }

}
