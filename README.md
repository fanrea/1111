# 2024090905014-林仪
情景运用
#include<stdio.h>

int main()
{
 int code=0;
    while (1) {
        printf("Show me your code,please.");
            scanf("%d", & code);
            if (code >= 100000&& code <= 999999)
            {
                printf("I am super hacker!");
              break;
            }
        else
                printf("Fake code!");
    }
    return 0;
}
问题
1  java
2  第一行调用函数库，接下来打印Hello word
3  第二行
4  整形，main函数的定义应该使用int类型‌，而不是void，这是因为main函数的返回值需要用来向操作系统报告程序的执行状态
5     #include <stdio.h>

int main() {
    printf("Hello gilmmer!");
    return 0;
}

课后题在1111.c中



