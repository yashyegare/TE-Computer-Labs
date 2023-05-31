import java.util.*;

class Job {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id; // this is current class instance variable
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JobScheduling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the no of Job you want to enter: ");
        int n = in.nextInt();
        Job[] jobs = new Job[n];
        System.out.print("Enter the details of the Job: \n");
        for (int i = 0; i < n; i++) {
            System.out.println("Job " + (i + 1) + " :");
            System.out.print("Enter the id of Job: ");
            int id = in.nextInt();
            System.out.print("Enter the deadline of Job: ");
            int deadline = in.nextInt();
            System.out.print("Enter the profit of Job: ");
            int profit = in.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }

        // Sort jobs based on profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Array to store job scheduling slots
        int[] slots = new int[maxDeadline + 1];

        int totalProfit = 0;
        for (Job job : jobs) {

            // Find the latest available slot before the job's deadline
            for (int i = job.deadline; i > 0; i--) {
                if (slots[i] == 0) {
                    slots[i] = job.id; // Schedule the job in the slot
                    totalProfit += job.profit; // Add job's profit to the total profit
                    break;
                }
            }
        }

        System.out.print("Scheduled Jobs: ");
        for (int i = 1; i < slots.length; i++) {
            if (slots[i] != 0) {
                System.out.print(slots[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
