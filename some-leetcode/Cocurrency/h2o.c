sem_t h, o
h.s = 0
o.s = 0
hcount = 0, ocount = 0;
lock

h()
{
     lock();
     ++hcount;
     if (hcount >= 2 && ocount >= 1)
     {
          hcount -= 2;
          ocount -= 1;
          makewater();
          signal(h);
          signal(o);
          unlock();
     }
     else
     {
          unlock();
          wait(h);
     }
}

o()
{
     lock();
     ++ocount;
     if (hcount >= 2 && ocount >= 1)
     {
          hcount -= 2;
          ocount -= 1;
          makewater();
          signal(h);
          signal(h);
          unlock();
     }
     else
     {
          unlock();
          wait(o);
     }
}


// simple version
sem_t h, o  -> 0
nH = 0

H()
{
     lock()
     nH++
     if (nh % 2 == 0)
     {
          sem_signal(o)
          unlock()
          sem_wait(h)
     }
     else
     {
          unlock()
          sem_wait(h)
     }
}

O()
{
     wait(o)
     signal(h)
     signal(h)
}
