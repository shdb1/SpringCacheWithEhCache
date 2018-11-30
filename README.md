# SpringCacheWithEhCache

Notes:

1.Default disk store is temp otherwise we can specify any from machine.
2.eternal if set to true TTL/Idle configs become useless.
3. memoryStoreEvictionPolicy could be LRU,LFU,FIFO,CLOCK(FIFO)
4. persistence- localRestartable,localTempSwap,none
5. synchronousWrites can be used if localRestartable configured.

<persistence strategy="localRestartable" synchronousWrites="true\false"/>