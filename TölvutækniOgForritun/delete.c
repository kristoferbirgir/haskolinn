/* Eyðir hnúti númer k í tengda listanum sem head bendir á.
 Skilar bendi á fremsta hnút listans */
struct Node* delNode(struct Node* head, int k) {
	struct Node *p, *q;
	int i;

	p = head;
	/* Eyðing á fremsta hnúti er sértilvik */
	if (k == 1) {
		if (head != NULL) {
			head = head->next;
			free(p);
		}
	} else {
		i = 2;
		while (i<k && p->next != NULL) {
			p = p->next;
			i++;
		}
		if (p->next != NULL) {
			q = p->next;
			p->next = q->next;
			free(q);
		}
	}
	return head;
}
