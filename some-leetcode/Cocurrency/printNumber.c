sem_t odd, even
odd.count = 1
even.count = 0

odd()
{
	for (int i = 1; i <= 100; i += 2)
	{
		sem_wait(odd);
		printf("%d\n", i);
		sem_post(even);
	}
}

even()
{
	for (int i = 2; i <= 100; i += 2)
	{
		sem_wait(even);
		printf("%d\n", i);
		sem_post(odd);
	}
}
