package com.nicholas.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public final class RedisUtils {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /*
    * 指定缓存失效时间
    * key 键
    * time 时间（秒）
    * */
    public boolean expire(String key , Long time){
        try {
            if (time > 0){
                return redisTemplate.expire(key , time , TimeUnit.SECONDS);
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    * 根据key 获取过期时间
    * key 键 不能为null
    * return 时间（秒）返回0代表永久有效
    * */
    public long getExpire(String key){
        return redisTemplate.getExpire(key ,TimeUnit.SECONDS);
    }

    /*
    * 判断key是否错在
    * key 键
    * return true 存在 false不存在
    * */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    * 删除缓存
    * key 可以传一个 或 多个
    * */
    public void del(String... key){
        if (null != key && key.length > 0){
            if(key.length == 1){
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
            }
        }
    }

    //============================String=====================================
    /*
    * 普通缓存获取
    * key 键
    * return 值
    * */
    public Object get(String key){ return null == key ? null : redisTemplate.opsForValue().get(key);}

    /*
    * 普通缓存存入
    * key 键
    * value 值
    * return true成功 false失败
    * */
    public boolean set(String key , Object value){
        try {
            redisTemplate.opsForValue().set(key , value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    * 普通存入并设置失效时间
    * key 建
    * value 值
    * time 时间（秒） time要大于0 如果小于等于0 将设置无期限
    * return true 成功 false 失败
    */

    public boolean set(String key , Object value ,long time){
        try {
            if (time > 0){
                redisTemplate.opsForValue().set(key , value , time ,TimeUnit.SECONDS);
            }else {
                set(key, value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    * 递增
    * key 键
    * delta 递增值 大于0
    **/
    public long incr(String key , long delta){
        if (delta < 0){
            throw new RuntimeException("递增值必须大于0");
        }
        return redisTemplate.opsForValue().increment(key , delta);
    }

    /*
     * 递减
     * key 键
     * delta 递增值 大于0
     **/
    public long decr(String key , long delta){
        if (delta < 0){
            throw new RuntimeException("递增值必须大于0");
        }
        return redisTemplate.opsForValue().increment(key , delta);
    }

    //============================Map=====================================
    /*
    * 获取hashKey的值
    * key 键
    * item 项
    * return 返回对应值
    * */
    public Object hget(String key , String item){
        return redisTemplate.opsForHash().get(key , item);
    }

    /*
    * 获取hashKey所有的值
    * key键
    * return 返回多个*/
    public Map<Object , Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /*
    * hashSet
    * key 键
    * map 值*/
    public boolean hmset(String key , Map<String , Object> map){
        try {
            redisTemplate.opsForHash().putAll(key , map);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*hashSet 同时设置时间
    * key键
    * map 值
    * time 时间秒
    * return true成功 false失败*/
    public boolean hmset(String key , Map<String , Object> map , long time){
        try {
            redisTemplate.opsForHash().putAll(key ,map);
            if (time > 0){
                set(key , time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    * 向一张hash表中存入数据，没有将新建
    * key 键
    * item 项
    * value 值
    * return true成功 false失败*/
    public boolean hset(String key , String item , Object value){
        try {
            redisTemplate.opsForHash().put(key , item , value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
    * 向一张hash表中存入数据，加入失效时间，没有将新建
    * key 键
    * item 项
    * value 值
    * time 时间秒，如果已存在hash表有时间，将替换原来时间
    * return true成功 false失败*/
    public boolean hset(String key , String item , Object value , long time){
        try {
            redisTemplate.opsForHash().put(key , item ,value);
            if (time > 0){
                expire(key , time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*删除hash表中的值
    * key 键 不能为 null
    * item 项 可以多个 不能 null*/
    public void hdel(String key, Object item){
        redisTemplate.opsForHash().delete(key , item);
    }

    /*判断hash表中是否有对应值
    * key 键 不能 null
    * item 项 不能null
    * return true存在 false不存在*/
    public boolean hHasKey(String key , String item){
        return redisTemplate.opsForHash().hasKey(key , item);
    }

    /*hash递增，如果不存在 就会创建一个，并返回创建后的值
    * key 键
    * item 项
    * by 要增加几 大于0*/
    public double hincr(String key , String item , double by){
        return redisTemplate.opsForHash().increment(key , item , by);
    }

    /*hash递减
    * key 键
    * item 项
    * by 要减少几 大于0*/
    public double hdecr(String key , String item , double by){
        return redisTemplate.opsForHash().increment(key , item , -by);
    }

    //============================Set=====================================
    /*
    * 根据key获取set中的所有值
    * key 键*/
    public Set<Object> sGet(String key){
        try {
            return redisTemplate.opsForSet().members(key);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /*根据value从一个set中查询是否存在
    * key键
    * value值
    * return true存在 false不存在*/
    public boolean sHasKey(String key , Object value){
        try {
            return redisTemplate.opsForSet().isMember(key , value);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*将数据放入set
    * key 键
    * values 值可以是多个
    * return 成功个数*/
    public long sSet(String key , Object... values){
        try {
            return redisTemplate.opsForSet().add(key ,values);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /*将数据放入set
     * key 键
     * values 值可以是多个
     * time 时间秒
     * return 成功个数*/
    public long sSetAndTime(String key , long time , Object... values){
        try {
            Long count = redisTemplate.opsForSet().add(key , values);
            if(time > 0){
                expire(key , time);
            }
            return count;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /*获取set缓存长度
    * key键*/
    public long sGetSetSize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /*移除value对应的值
    * key 键
    * values 值 可以多个*/
    public long setRemove(String key , Object... values){
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    //============================list=====================================
    /*获取list缓存的内容
    * key 键
    * start 开始
    * end 结束 0 到 -1 代表所有*/
    public List<Object> lGet(String key , long start , long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /*通过索引获取list中的值
    * key 值
    * index 索引*/
    public Object lGetIndex(String key , long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /*将list放入缓存
    * key 键
    * value 值*/
    public boolean lSet(String key , Object value){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    /*将list放入缓存
     * key 键
     * value 值
     * time 时间秒*/
    public boolean lSet(String key ,Object value , long time){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*将list放入缓存
     * key 键
     * value 值
     */
    public boolean lSet(String key , List<Object> value){
        try {
            redisTemplate.opsForList().rightPushAll(key , value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*将list放入缓存
     * key 键
     * value 值
     * time 时间秒
     */
    public boolean lSet(String key , List<Object> value , long time){
        try {
            redisTemplate.opsForList().rightPushAll(key , value);
            if (time > 0){
                expire(key , time);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*根据索引修改list中的某条数据
    * key 键
    * index 索引
    * value 值*/
    public boolean lUpdateIndex(String key , long index ,Object value){
        try {
            redisTemplate.opsForList().set(key , index , value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*移除N个值为value
    * key键
    * count 移除多少个
    * value 值
    * return 移除的个数*/
    public long lRemove(String key , long count , Object value){
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}

