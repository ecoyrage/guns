/**
 * RedisUtil class
 *
 * @author ZhaoMing
 * @data 2019/1/9
 * @description redis连接测试
 */
package cn.stylefeng.guns.modular.zhao.redis;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        System.out.println("服务正在运行："+jedis.ping());

//        JedisPoolConfig config = new JedisPoolConfig();
    }

}
