package com.tiv.dynamic.config.center.config.register;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dynamic.config.center.register.redis", ignoreInvalidFields = true)
public class DynamicConfigCenterRedisRegisterProperties {

    /**
     * redis password
     */
    private String password;

    /**
     * redis host
     */
    private String host;

    /**
     * redis port
     */
    private int port;

    /**
     * redis database
     */
    private int database;

    /**
     * 连接池的大小
     */
    private int poolSize = 64;

    /**
     * 连接池的最小空闲连接数
     */
    private int minIdleSize = 10;

    /**
     * 连接的最大空闲时间/ms
     */
    private int idleTimeout = 10000;

    /**
     * 连接超时时间/ms
     */
    private int connectTimeout = 10000;

    /**
     * 连接重试次数
     */
    private int retryAttempts = 3;

    /**
     * 连接重试间隔/ms
     */
    private int retryInterval = 1000;

    /**
     * 定期检查连接可用性间隔/ms
     */
    private int pingInterval = 0;

    /**
     * 是否保持长连接
     */
    private boolean keepAlive = true;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getMinIdleSize() {
        return minIdleSize;
    }

    public void setMinIdleSize(int minIdleSize) {
        this.minIdleSize = minIdleSize;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public int getPingInterval() {
        return pingInterval;
    }

    public void setPingInterval(int pingInterval) {
        this.pingInterval = pingInterval;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

}