# eurekaextend
springcloud-eureka的扩展学习，高可用集群

几个坑：
eureka:
  instance:
    hostname: localhost
    preferIpAddress: true
在本机开发的时候，我们会用这样的配置
1.开发的过程中发现，hostname不能用localhost，必须用域名，所以这个地方要修改本机host来适应
2.preferIpAddress: true这句话一定要去掉，
以上两点会导致，出现所有的注册节点都在unavailable-replicas区域，不可用

还有eurkea-server的配置，都是需要注册到eureka中，都是true
这样会发现在启动的时候报错，不能连接到服务，这个错误是可以忽略跳过的，因为其他同节点的server还没有启动。等其他节点都启动的时候，就会发现其实eureka其实是成功的
