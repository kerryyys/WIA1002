import java.text.ParseException;
import java.util.ArrayList;
// year: yy
// month: MM
// day: dd
// hour: HH
// minute: mm
// second: ss
// millisecond: SSS
public class Main {
    public static void main(String args[]) throws ParseException {
        tools t = new tools();
        ArrayList<logs> log = t.read("extracted_log");
        analysis a = new analysis(log);
        ArrayList<Boolean> timeRange = a.timeRange("06/20/15/00/00", "06/20/23/00/00", "MM/dd/HH/mm/ss");
        ArrayList<Integer> epycNonDupJobID = a.partitionNonDuplicateJobID("epyc","sched:");
        ArrayList<Integer> opteronNonDupJobID = a.partitionNonDuplicateJobID("opteron","sched:");
        ArrayList<Integer> gpuNonDupJobID = a.partitionNonDuplicateJobID("gpu","sched:");

        // a.getJobStarted(timeRange);
        // a.getJobEnded(timeRange);
        // a.getEPYC(epycNonDupJobID);
        // a.getOPTERON(opteronNonDupJobID);
        // a.getGPU(gpuNonDupJobID);
        // a.getAverageExcecutionTime();
        // a.getInfoBasedOnError("No access to QoS error");
        // a.getInfoBasedOnError("Security violation");
        // a.getInfoBasedOnError("User not found error");
        // a.getInfoBasedOnError("GPU resources deallocation error");
        // a.getInfoBasedOnError("Lookup failure for node");
        // a.getInfoBasedOnError("Invalid node specified");
        // a.getInfoBasedOnError("Socket timed out on send/recv operation");
        // a.getInfoBasedOnError("Association TRES running seconds error");
        // a.getInfoBasedOnError("Different slurm.conf than the slurmctld error");
        // a.getInfoBasedOnError("Epilog error");
        // a.getInfoBasedOnError("Job epilog failed");
        // a.getInfoBasedOnError("Nodes not responding");
        // a.getInfoBasedOnError("other errors");
    } 
}

