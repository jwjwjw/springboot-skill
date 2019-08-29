package com.jw.config;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;


@Configuration
@ConfigurationProperties(prefix = "datasource.jw")
//@EnableJpaRepositories(basePackages = {"com.jw.repository"})
@EnableTransactionManagement
public class RepositoryConfig {

    @NotNull
    private String connectionFactoryClassName;

    @NotNull
    private String url;

    @NotNull
    private String user;

    @NotNull
    private String password;

    @NotNull
    private String connectionPoolName;

    @NotNull
    private int initialPoolSize;

    @NotNull
    private int minPoolSize;

    @NotNull
    private int maxPoolSize;

    private boolean fastConnectionFailoverEnabled;

    @NotNull
    private int abandonedConnectionTimeout;

    @NotNull
    private int connectionWaitTimeout;

    private boolean validateConnectionOnBorrow;

    @NotNull
    private int maxConnectionReuseTime;

    @NotNull
    private String validationQuery;

    @NotNull
    private String showSql;

    @NotNull
    private String databasePlatform;

    public String getConnectionFactoryClassName() {
        return connectionFactoryClassName;
    }

    public void setConnectionFactoryClassName(String connectionFactoryClassName) {
        this.connectionFactoryClassName = connectionFactoryClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionPoolName() {
        return connectionPoolName;
    }

    public void setConnectionPoolName(String connectionPoolName) {
        this.connectionPoolName = connectionPoolName;
    }

    public int getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(int initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public boolean isFastConnectionFailoverEnabled() {
        return fastConnectionFailoverEnabled;
    }

    public void setFastConnectionFailoverEnabled(boolean fastConnectionFailoverEnabled) {
        this.fastConnectionFailoverEnabled = fastConnectionFailoverEnabled;
    }

    public int getAbandonedConnectionTimeout() {
        return abandonedConnectionTimeout;
    }

    public void setAbandonedConnectionTimeout(int abandonedConnectionTimeout) {
        this.abandonedConnectionTimeout = abandonedConnectionTimeout;
    }

    public int getConnectionWaitTimeout() {
        return connectionWaitTimeout;
    }

    public void setConnectionWaitTimeout(int connectionWaitTimeout) {
        this.connectionWaitTimeout = connectionWaitTimeout;
    }

    public boolean isValidateConnectionOnBorrow() {
        return validateConnectionOnBorrow;
    }

    public void setValidateConnectionOnBorrow(boolean validateConnectionOnBorrow) {
        this.validateConnectionOnBorrow = validateConnectionOnBorrow;
    }

    public int getMaxConnectionReuseTime() {
        return maxConnectionReuseTime;
    }

    public void setMaxConnectionReuseTime(int maxConnectionReuseTime) {
        this.maxConnectionReuseTime = maxConnectionReuseTime;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public String getShowSql() {
        return showSql;
    }

    public void setShowSql(String showSql) {
        this.showSql = showSql;
    }

    public String getDatabasePlatform() {
        return databasePlatform;
    }

    public void setDatabasePlatform(String databasePlatform) {
        this.databasePlatform = databasePlatform;
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        PoolDataSource source = PoolDataSourceFactory.getPoolDataSource();
        source.setConnectionFactoryClassName(connectionFactoryClassName);
        source.setURL(url);
        source.setUser(user);
        source.setPassword(password);
        source.setConnectionPoolName(connectionPoolName);
        source.setInitialPoolSize(initialPoolSize);
        source.setMinPoolSize(minPoolSize);
        source.setMaxPoolSize(maxPoolSize);
        source.setFastConnectionFailoverEnabled(fastConnectionFailoverEnabled);
        source.setAbandonedConnectionTimeout(abandonedConnectionTimeout);
        source.setConnectionWaitTimeout(connectionWaitTimeout);
        source.setValidateConnectionOnBorrow(validateConnectionOnBorrow);
        source.setMaxConnectionReuseTime(maxConnectionReuseTime);
        source.setSQLForValidateConnection(validationQuery);
        return source;
    }

}
