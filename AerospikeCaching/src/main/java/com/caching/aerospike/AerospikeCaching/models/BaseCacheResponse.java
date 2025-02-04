package com.caching.aerospike.AerospikeCaching.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseCacheResponse {
    private boolean cachedResponse;
}
