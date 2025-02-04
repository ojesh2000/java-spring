package com.caching.aerospike.AerospikeCaching.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Host;
import com.aerospike.client.policy.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    @Bean
    public AerospikeClient getAeroClientBean(){
        Host[] hosts = new Host[]{new Host("localhost", 3000)};
        return new AerospikeClient(clientPolicy(), hosts);
    }

    private ClientPolicy clientPolicy(){
        ClientPolicy cp = new ClientPolicy();
        cp.readPolicyDefault = readPolicy();
        cp.writePolicyDefault = writePolicy();
        return cp;
    }


    private Policy readPolicy() {
        Policy policy = new Policy();
        policy.priority = Priority.DEFAULT;
        policy.setTimeout(300);
        policy.maxRetries = 0;
        return policy;
    }


    private WritePolicy writePolicy(){
        WritePolicy policy = new WritePolicy();
        policy.recordExistsAction = RecordExistsAction.REPLACE;
        policy.maxRetries = 0;
        policy.expiration = 86400;
        policy.setTimeout(500);
        return policy;
    }
}
