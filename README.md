# eurekaextend
springcloud-eureka的扩展学习，高可用集群
使用了springlcoud-config来存储和配置各个sever的参数，参考
https://github.com/zjypp/test1.git

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

==
增强
HTTP Basic认证。
1.在配置中开启http basic认证以后
启动的时候输入：http://eureka-peer1:8761
会直接导向一个登陆页面，要求输入账号密码。然后才能访问控制台

使用curl -i http://eureka-peer1:8761/eureka/apps ，也会提示401
使用curl -i --basic -u admin:Xk38CNHigBP5jK75 http://eureka-peer1:8761/eureka/apps
可以验证账号正确
.
eureka-server和eureka-client切换到对应的security配置文件