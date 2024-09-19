#define  _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<string.h>
int main()
{   int m, n, i= 0;
	scanf("%d %d", &m, &n);
	int max = (m > n) ? m : n;
	int min = (m > n) ? n : m;
	for (i = min; i > 0; i--)
	{if (max % i == 0&&min%i==0)
			break;
	}
	printf("%d", i);
	return 0;
}
