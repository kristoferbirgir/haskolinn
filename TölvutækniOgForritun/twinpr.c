#include <stdio.h>
#include <stdlib.h>

int isprime(long k) {
	if (k < 2) return 0;
	if (k == 2) return 1;
	for (int i = 3; i * i <= k; i++) {
		if (k % i == 0) {
			return 0;
		}
	}
	return 1;
}
int main(int argc, char **argv) {
	if (argc < 2) {
	printf("Vantar fjölda\n");
	exit(0);
	}
	int n = atoi(argv[1]);
	int p = 3;
	int i = 0;
	while (i < n) {
		if (isprime(p) && isprime(p + 2)) {
			printf("%d og %d\n", p, p + 2);
			i++;
		}
		p += 2;
	}
	return 0;
}
