package com.cloud;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandomRule extends AbstractLoadBalancerRule {

    public Server choose(ILoadBalancer lb, Object key) {

        int totalIndex = 0; //用于记录每个机器上当前轮询次数
        int currentIndex = 0; //用于记录当前是第几台机器提供服务

        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            //当前提供服务者是否还需要轮寻
            if (totalIndex < 3) {
                //当前机器轮寻次数小于3,继续提供服务
                server = upList.get(currentIndex);
                //轮寻次数计数叠加
                totalIndex++;
            } else {
                //当前机器已经提供了3次服务，需要调用下一个机器进行提供服务
                currentIndex++;
                //轮寻次数清空重新计数
                totalIndex = 0;
                //判定是否到了最后一台机器,如果是,又从机器第一台开始
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
