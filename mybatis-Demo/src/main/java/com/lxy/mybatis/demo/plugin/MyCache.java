package com.lxy.mybatis.demo.plugin;

import lombok.Data;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;

@Data
public class MyCache implements Cache {

    private final Logger logger = LoggerFactory.getLogger(MyCache.class);

    private final String id;

    private Integer maxSize = 1024;

    private final ConcurrentMap<Object,Object> concurrentMap = new ConcurrentHashMap<Object, Object>(1024);


    public MyCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("MyCache Cache instances require an ID.");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void putObject(Object key, Object value) {
        if(this.concurrentMap.size() > this.maxSize)
        {
            this.clear();
        }
        logger.debug("Put: key {},value {}",key,value);
        this.concurrentMap.put(key,value);

    }

    public Object getObject(Object key) {
        Object value = this.concurrentMap.get(key);
        logger.debug("Get: key {},value {}",key,value);
        return value;
    }

    public Object removeObject(Object key) {
        Object value = this.concurrentMap.remove(key);
        logger.debug("Remove: key {},value {}",key,value);
        return value;
    }

    public void clear() {
        logger.debug("Clear");
        this.concurrentMap.clear();
    }

    public int getSize() {
        return concurrentMap.size();
    }

    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
