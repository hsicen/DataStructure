package me.hsicen.javaguide

/******====== 程序本质 ======******/
/**
 * 语言类型：
 *  编译型: 先编译成可执行文件，没办法跨平台（由于操作系统的API不一样），典型的就是c++
 *  解释型: 边解释边执行，支持跨平台（根据操作系统的不同翻译成对应的cpu指令）。典型的包括python
 *  混合型: 既包含编译也包含解释，先编译成对应字节码、然后再解释执行该字节码（比如java：.java ==> .class ==> 机器码）。这样就支持跨平台，但解释执行的过程仍然耗时（JIT编译器做了优化）
 *
 *
 * 操作系统 ==> 指令 ==> 汇编 ==> 字节码
 * A、操作系统是用来管理软硬件资源、进行作业调度的一个软件。 （比如管理内存、cpu这类硬件，管理office这类的软件） 同时，操作系统还担当了类库功能，提供对应API；提供文件系统方便进行文件管理。
 * B、虚拟机就好比是一个媒介，作为中间者，将程序员写好的代码进行翻译，cpu执行的是翻译好的指令。 代码 ==> 虚拟机 ==>指令 ==>cpu执行 （cpu先执行虚拟机代码，再执行我们编写的代码）
 * C、cpu指令 cpu指令 = 操作码+数据+地址（类比生活中的例子：小明拿着桌子上的纸巾去到卫生间如厕） 不同的指令集里面，操作对应的指令是不一样的，比如ARM指令集和X86指令集
 * D、关于汇编 机器语言 ==> 汇编语言 ==> 高级语言 汇编语言使用字符串来表示，这样开发效率会提升很多。（比如mov、push、pop、add这类的指令）
 * E、字节码 就是class文件 字节码出现目的就是为了在保留跨平台优势的同时，加快程序的执行速度。 java跨平台的原因就是因为有了 JVM，通过 JVM将java文件给编译成对应平台的指令代码。
 *
 * 关于计算机的存储：
 * 1.计算机存储包括： 寄存器、L1/2/3缓存、内存、磁盘 速度由快到慢、价格由高到低
 * 2.寄存器 寄存器直接跟cpu集成在一起，一个cpu有多种寄存器，不同寄存器执行功能不一样
 * 3.指令执行的过程 机器码 ==> 内存 ==> 初始化寄存器的值 ==> cpu 根据cs和ip寄存器中的内存地址，获取cpu指令 ==> 放到IR寄存器中（存放正在执行的指令的寄存器） ==> IP寄存器移动到下一条指令的地址 循环往复上面过程直到结束
 *
 * 为什么c/c艹不直接编译成机器码呢？
 * 个人认为就跟java多了jvm进行分层、网络用7层4层划分一样，通过高级语言到汇编再到机器码的过程，可以降低编译器的编写难度、提升效率；而且汇编要进行调试、进行优化的话应该也要比机器码容易一点
 */