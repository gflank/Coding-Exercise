mutex mtx
sem_t w_sem -> 1
sem_t r_sem -> 1
nReader = 0

R()
{
	sem_wait(r_sem)
	lock(mtx)
	nReader++
	if (nReader == 1)
	{
		sem_wait(w_sem)
	}
	unlock(mtx)
	sem_signal(r_sem) // can move upper?

	//...

	lock(mtx)
	nReader--
	if (nReader == 0)
	{
		sem_signal(w_sem)
	}
	unlock(mtx)
}

W()
{
	sem_wait(r_sem)
	sem_wait(w_sem)

	//...

	sem_signal(w_sem)
	sem_signal(r_sem)
}
