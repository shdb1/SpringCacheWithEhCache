package com.shadab.spring.cache.ehcache.cacheconfig;

 import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
 
public class UpdateCacheConfig {
	
	public boolean updateCacheConfig() {
	    
		CacheManager cacheManager = CacheManager.create();
        Cache cache = cacheManager.getCache("students");
		CacheConfiguration config = cache.getCacheConfiguration();
		config.setTimeToIdleSeconds(60);
		config.setTimeToLiveSeconds(120);
		config.maxEntriesLocalHeap(10);
		config.maxEntriesLocalDisk(10);
		
		System.out.println("HEY TEST UPDATE IN CONFIG OF CACHE:="+config.getMaxEntriesLocalDisk());
		
 		return true;
	}
	
	
	public void disableFutureUpdates() {
		
		CacheManager cacheManager = CacheManager.create();
		 Cache cache = cacheManager.getCache("students");
		 cache.disableDynamicFeatures();
	}

}
