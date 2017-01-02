sem_t eastSem, westSem;
mutex_lock_t counterLock;
int eastWaiting := 0, westWaiting := 0, eastActivate := 0, westActivate := 0;
sem_init(&eastSem, 0, 0);
sem_init(&westSem, 0, 0);
mutex_init(&counterLock, NULL);
// string CURR_direction;

cross_bridge(direction)
{
	// west part
	if direction = WEST
	{
		mutex_lock(&counterLock);
		if eastWaiting + eastActivate = 0 and westActivate < 3
		{
			// CURR_direction := "WEST";
			++westActivate;
			sem_signal(&westSem);
		}
		else
			++westWaiting;
		mutex_unlock(&counterLock);
		sem_wait(&westSem);

		 // crossing...

		mutex_lock(&counterLock);
		--westActivate;
		if eastWaiting > 0 and westActivate = 0
		{
			while eastWaiting > 0 and eastActivate < 3
			{
				// CURR_direction := "EAST";
				++eastActivate;
				--eastWaiting;
				sem_signal(&eastSem);
			}
		}
		else if westWaiting > 0 and eastWaiting = 0
		{
				++westActivate;
				--westWaiting;
				sem_signal(&westSem);
		}
		mutex_unlock(&counterLock);		
	}

	// east part
	else
	{
		mutex_lock(&counterLock);
		if westWaiting + westActivate = 0 and eastActivate < 3
		{
			// CURR_direction := "EAST";
			++eastActivate;
			sem_signal(&eastSem);
		}
		else
			++eastWaiting;
		mutex_unlock(&counterLock);
		sem_wait(&eastSem);

		// crossing...

		mutex_lock(&counterLock);
		--eastActivate;
		if westWaiting > 0 and eastActivate = 0
		{
			while westWaiting > 0 and westActivate < 3
			{
				// CURR_direction := "WEST";
				++westActivate;
				--westWaiting;
				sem_signal(&westSem);
			}
		}
		else if eastWaiting > 0 and westWaiting = 0
		{
				++eastActivate;
				--eastWaiting;
				sem_signal(&eastSem);
		}
		mutex_unlock(&counterLock);	
	}
}