#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main(int argc, char **argv) {
	int n, k, i;
	int cnt;
	int *a;
	if (argc > 2) {
		n = atoi(argv[1]);
		k = atoi(argv[2]);
	} else {
		printf("Of fá viðföng\n");
		exit(0);
	}
	a = (int *)calloc(n, sizeof(int));
	srand(time(0));
	for (i = 0; i < k*n; i++) {
		a[rand() % n]++;
	}
	cnt = 0;
	for (i = 0; i < n; i++) {
	if (a[i] == 0) cnt++;
	}
	printf("Eftir %d ítranir eru %d hólf ennþá 0, eða %.1f\%\n",
		k*n, cnt, 100.0*cnt/n);
	return 0;
}
