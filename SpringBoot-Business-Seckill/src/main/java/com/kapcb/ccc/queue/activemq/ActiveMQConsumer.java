package com.kapcb.ccc.queue.activemq;

import com.kapcb.ccc.common.entity.Result;
import com.kapcb.ccc.common.enums.SeckillStatEnum;
import com.kapcb.ccc.common.redis.RedisUtil;
import com.kapcb.ccc.common.webSocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQConsumer<ISeckillService> {
	
	@Autowired
	private ISeckillService seckillService;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	 * @param message
	 */
	@JmsListener(destination = "seckill.queue")
	public void receiveQueue(String message) {
		/**
		 * 收到通道的消息之后执行秒杀操作(超卖)
		 */
		String[] array = message.split(";");
		Result result = seckillService.startSeckilDBPCC_TWO(Long.parseLong(array[0]), Long.parseLong(array[1]));
		if(result.equals(Result.ok(SeckillStatEnum.SUCCESS))){
			WebSocketServer.sendInfo(array[0], "秒杀成功");
		}else{
			WebSocketServer.sendInfo(array[0], "秒杀失败");
			redisUtil.cacheValue(array[0], "ok");
		}
	}
}
