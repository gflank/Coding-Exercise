import java.util.*;

public class ShortestJob {
	public static class Job {
		int arrivedTime;
		int duration;

		public Job(int time, int dura) {
			arrivedTime = time;
			duration = dura;
		}
	}

	public static double shortest(int[] requestTimes, int[] durations) {
		if (requestTimes.length <= 1 || requestTimes.length != durations.length) {
			return 0;
		}

		// create a min heap for jobs, job with shortest duration would on the top
		PriorityQueue<Job> jobPool = new PriorityQueue<Job>(4, new Comparator<Job>(){
			public int compare(Job j1, Job j2) {
				if (j1.duration == j2.duration) {
					return j1.arrivedTime - j2.arrivedTime;
				}
				return j1.duration - j2.duration;
			}
		});

		int curTime = 0;
		int curRequest = 0;
		int totalWaitTime = 0;
		// keep running except finished all requests and not jobs pending
		while (curRequest < requestTimes.length || !jobPool.isEmpty()) {
			if (!jobPool.isEmpty()) {
				// now select a Job to run
				Job nextJob = jobPool.poll();
				totalWaitTime += curTime - nextJob.arrivedTime;
				curTime += nextJob.duration;
			}
			// if pool is empty and current no request, skip to the next request time
			else {
				if (curTime < requestTimes[curRequest]) {
					curTime = requestTimes[curRequest];
				}
			}

			// put all new arrived requests into heap first
			while (curRequest < requestTimes.length && curTime >= requestTimes[curRequest]) {
				jobPool.offer(new Job(requestTimes[curRequest], durations[curRequest]));
				++curRequest;
			}
		}

		return (double)totalWaitTime / (double)requestTimes.length;
	}

	public static void main(String[] args) {
		// int[] requests = {0, 2, 4, 5};
		// int[] durations = {7, 4, 1, 4};
		// int[] requests = {0, 1, 3, 9};
		// int[] durations = {2, 1, 7, 5};
		// int[] requests = {0, 2, 3, 9};
		// int[] durations = {1, 1, 7, 5};
		int[] requests = {2, 2, 6, 9};
		int[] durations = {1, 2, 7, 5};
		System.out.println(ShortestJob.shortest(requests, durations));
	}
}