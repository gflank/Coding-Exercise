import java.util.*;

public class RoundRobin {
	public static class Job {
		int arrivedTime;
		int duration;

		public Job(int arrived, int dura) {
			arrivedTime = arrived;
			duration = dura;
		}
	}

	public static double round(int[] arrivals, int[] durations, int max) {
		if (arrivals.length != durations.length || max <= 0) {
			return -1;
		}
		else if (arrivals.length <= 1) {
			return 0;
		}

		Queue<Job> queue = new LinkedList<Job>();
		int totalWaitTime = 0;
		int curArrived = 0;
		int curTime = 0;
		while (curArrived < arrivals.length || !queue.isEmpty()) {
			Job curJob = null;
			// now choose a job to run
			if (!queue.isEmpty()) {
				curJob = queue.poll();
				// record wait time
				totalWaitTime += curTime - curJob.arrivedTime;
				// if remain duration smaller than max
				if (curJob.duration <= max) {
					curTime += curJob.duration;
					// mark curJob as finished
					curJob = null;
				}
				else {
					curTime += max;
					// modify curJob status
					curJob.duration -= max;
					curJob.arrivedTime = curTime;
				}
			}
			// if queue is empty and current no request, skip to the next request time
			else {
				if (curTime < arrivals[curArrived]) {
					curTime = arrivals[curArrived];
				}
			}

			// check if any request arrived before or right at this point
			while (curArrived < arrivals.length && arrivals[curArrived] <= curTime) {
				queue.offer(new Job(arrivals[curArrived], durations[curArrived]));
				++curArrived;
			}
			if (curJob != null) {
				// if curJob unfinished, put it into queue
				queue.offer(curJob);
			}
		}

		return (double)totalWaitTime / (double)arrivals.length;
	}

	public static void main(String[] args) {
		// int[] arrivals = {0, 1, 4};
		// int[] durations = {5, 2, 3}
		// int max = 3;
		int[] arrivals = {0, 1, 3, 9};
		int[] durations = {2, 1, 7, 5};
		int max = 2;
		System.out.println(RoundRobin.round(arrivals, durations, max));
	}
}