###original版本不爽
我现在有一个顾虑：在测试的代码中，我仍然调用的是远程的Mongodb，这导致我在跑单元测试的时候变得很慢。解决这个问题有两个办法：
1. 在自己本地搭建一个mongodb，这样可以减少网络的耗时。但是这个方案有一定的缺陷，我要在本地安装Mongodb，并且以后部署到集成
环境时也要部署一套Mongodb。

2. 把mongodb mock掉。我用一个内存的数据库，或者一个Map来替代mongodb。（我会选择这个方案）

###可以顺利迁移吗？
那么，问题来了：要替换一个存储介质，我现在的代码实现不兼容怎么办呢？在找实现方案之前，先来看一下都有那些地方不支持我们替换一种
存储介质。
1. UserDao的实现和MongoDB紧紧绑定在一起。
2. UserController不能让我把其它的Persist实现传入。

####解决方案：
1. 把UserDao的实现和MongoDB的存储实现解耦合。
2. 抽象存储层的实现。
3. 给UserContr开刀，让其支持其它DB实现的传入。
