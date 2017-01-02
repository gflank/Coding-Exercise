mutex lock

P() {
  lock.acquire();
  if (counter == 0 || waiters > 0) {
    waiters++;
    waitingForV.wait();
  }
  else {
    counter--;
  }
  lock.release();
}

V() {
  lock.acquire();
  if (waiters > 0) {
    waiters--;
    waitingForV.signal();
  }
  else {
    counter++;
  }
  lock.release();
}
