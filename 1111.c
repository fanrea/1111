#include<stdio.h>
int main()
{
	int m, n, i = 0;
	scanf("%d %d", &m, &n);
	int max = (m > n) ? m : n;
	int min = (m > n) ? n : m;
	//得出较大数
	while (min != 0)
	{
		i = min;
		min = max % min;
		max = i;
	}
	//辗转相除
	printf("%d", max);
	return 0;
}
