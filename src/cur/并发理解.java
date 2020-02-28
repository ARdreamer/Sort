package cur;

public class 并发理解 {
    /**
     *       1. 方法论层面：「跳出来，看全景」 和 「钻进去，看本质」，这两条方法论，我想是适合很多领域的学习的。
     *
     *       2. 并发领域的「全景图」。
     *       对于「全景图」，我之前也有一直在构建，可是因为知识储备不够，确实很难构建出来。
     *       稍微了解过并发领域知识的人都知道，里面的知识点、概念多而散：
     *       线程安全、锁、同步、异步、阻塞、非阻塞、死锁、队列(为什么并发要跟队列扯上关系)、闭锁、信号量、活锁等等。
     *       如果单个去学这些知识点，单个去练习，如果没有「主线」，后期很容易忘。
     *       我思考再思考，也总结了一下学习并发的主线：
     *       首先，得理解并发的重要性，为什么需要并发？对于这个问题，只需要放在潜意识里面，只需要两个字：性能！其它的细节，再去慢慢拓展。
     *       然后，既然并发很重要，而并发处理的是任务，接下就是：
     *       对任务的抽象、拆解、分工执行。
     *       而线程模型，只是其中的一种模型，还有多进程、协程。
     *       Java使用的是多线程模型，对应到具体的代码就是：Thread, Runnable, Task，执行任务有：Exectors。
     *       引出了线程，有势必存在着线程安全性的问题，因为多线程访问，数据存在着不一致的问题。
     *       再然后，大的任务被拆解多个小的子任务，小的子任务被各自执行，
     *       不难想象，子任务之间肯定存在着依赖关系，所以需要协调，那如何协调呢？
     *       也不难想到，锁是非常直接的方式(Monitor原理)，
     *       但是只用锁，协调的费力度太高，在并发的世界里面，
     *       又有了一些其它的更抽象的工具：
     *       闭锁、屏障、队列以及其它的一些并发容器等；
     *       好了，协调的工作不难处理了。
     *       可是协调也会有出错的时候，这就有了死锁、活锁等问题，大师围绕着这个问题继续优化协调工具，尽量让使用者不容易出现这些活跃性问题；
     *       到此，「并发」的历史还在演化：
     *       如果一遇到并发问题，就直接上锁，倒也没有什么大问题，可是追求性能是人类的天性。
     *       计算机大师就在思考，能不不加锁也能实现并发，还不容易出错，于是就有了：CAS、copy-on-write等技术思想，这就是实现了「无锁」并发；
     *       可是，事情到此还没有完。
     *       如果以上这些个东西，都需要每个程序员自己去弄，然后自己保证正确性，那程序员真累死了，
     *       哪还有时间、精力创造这么多美好的应用！
     *       于是，计算机大师又开始思考，能不能抽象出统一「模型」，可能这就有了类似于「Java内存模型」这样的东西。
     *
     *       之前看薛兆丰的《经济学通识》，他总结到，人类面临着四大基本约束：
     *       东西不够，生命有限，互相依赖，需要协调。
     *       当我看到这句话的时候，我猛然间意识到：计算机也同样面临着这四大基本约束。
     *
     *       在计算中，CPU、内存、IO、硬盘、带宽等，这些资源也都有不够的时候，
     *       而每个线程的也有着自己的生命周期，并且它们之间又是相互依赖的，也同样需要协调。
     */
}
