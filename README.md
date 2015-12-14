##Scala DI workshop

###workshop的目标

实现用户注册系统，如果是新用户提示用户“success”，如果老用户提示“conflict”



###如何利用代码库

代码库中一共有4个分支，分别是：original-v1，original-v2，original-v3，Guice。它们是逐级递增的，最好能够按照给出的分支顺序去作练习，这样能够了解为什么我们需要依赖注入，以及如何一步一步实现一个简单的依赖注入。



###Roadmap

这个项目才刚刚是一个开始，因为Guice有好多特性本项目没有作展示，日后会逐一增添。同时，Scala本身还能够实现多种方式的依赖注入，这个也会考虑加进代码库。



###Prace Step by Step

克隆项目代码，并且换到original-v1分支，运行项目测试代码。

**original-v1版本不爽**

现在有一个顾虑：在测试的代码中，我仍然调用的是远程的Mongodb，这导致我在跑单元测试的时候变得很慢。解决这个问题有两个办法：

1. 在自己本地搭建一个mongodb，这样可以减少网络的耗时。但是这个方案有一定的缺陷，我要在本地安装Mongodb，并且以后部署到集成

环境时也要部署一套Mongodb。太费劲了。

2. 另起炉灶。用一个内存的数据库，或者一个In-Memory的数据结构来替代mongodb。（prefer这个方案）



**实施方案2之前有哪些障碍呢**

问题来了：如果要替换一种存储介质，我现在的代码实现其实是不兼容的？在找实现方案之前，先来看一下都有那些地方不支持我们替换一种存储介质。

1. UserDao的实现和MongoCollection紧紧绑在一起。

2. UserController是一个封闭的类，它不支持外部参数的传入。



**解决方案：**

1. 把UserDao的实现和MongoCollection的存储实现解耦合。

2. 抽象存储层的实现，提炼存储层的公共接口。

3. 给UserContr开刀，让其支持外部参数的传入。

4. 测试代码中切换数据库实现:InMemoryCollection。

5. 体验这时测试的速度！！嗖。。。

至此我们得到了original-v2的实现。



**original-v2版本不爽**

虽然V3版本实现了我快速跑测试的需求，但是这次UserController不爽了：我不想和Persist打交道，它比我低了两个级别，和它打交道有失我的身份。擦，廷又脾气。

为了照顾所有人的心情，只能再想辙了。

1. 把UserDao的提出来，屏蔽UserController和Persist。外部创建好UserDao之后再传给UserController。

至此我们的到了original-v3的实现。



**original-v3版本不爽**

>>>>#*邻居家小王都开始用Guice了*



好吧，神说用Guice，那就用Guice。