# 软件工程 第二次作业
## 学号：41911231 
## 姓名：王聪
# 使用Java的Profile工具探究插入排序中什么操作最耗时
## 1. IDEA中Profile工具是如何工作的？

> IDE时不时地看一下这个程序运行在哪个函数内，并记录下来。程
序结束后，IDE就会自动得出一个关于程序运行时间的大致画像
（Profile），便于我们发现程序的性能瓶颈。
## 2. 代码如下
```java
import java.util.Random;

public class Sort {
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1]) return false;
        }
        return true;
    }

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = new Random().nextInt(10000);
        }
        assert !isSorted(a);
        sort(a);
        assert isSorted(a);
    }
}

```

## 3. 在idea下进行java flight recorder 和 windows async profile性能分析
> 结果如下
### 3.1 java flight recorder

![idea效能图](https://s3.bmp.ovh/imgs/2022/03/422c7b95311a6f71.png)
### 3.2 windows async profile如下
![idea效能图](https://s3.bmp.ovh/imgs/2022/03/83c7ad53807d0a5c.png)
## 4. 在pycharm进行插入排序的profile分析
![pycharm](https://s3.bmp.ovh/imgs/2022/03/6aabc7e9d5f9a874.png)
## 5. 结论
> 从pycharm profile 和火焰图中可以看出，在插入排序的主函数中，尽管有检验数组是否为完成排序和生成随机数组的语句，但是在插入排序中，sort()却占用了几乎99.43%的运行时间，所以在插入排序中，排序操作最为耗时。并且由运行次数可知，占用的时间和代码运行的次数无关。例如，在插入排序中，sort()函数只被调用了一次，然而却占用了大部分时间，而随机函数调用的次数很多，但是运行时间却是很小。
