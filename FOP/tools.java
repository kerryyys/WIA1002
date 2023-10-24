import java.io.*;
import java.util.*;
public class tools {
    int total = 0;
    int left = 0;
    int proccessed = 0;
    extractor e = new extractor();
    String tempArr[];
    public ArrayList<logs> read(String URL){
        ArrayList<logs> log = new ArrayList<logs>();
        try{
            Scanner scan = new Scanner(new FileReader(URL));
            while(scan.hasNextLine()) {
                total++;
                tempArr = scan.nextLine().split(" ",3);
                if (switcher(tempArr) != null) { log.add(switcher(tempArr)); proccessed++; }
                else { left++; 
                    // System.out.println(Arrays.toString(tempArr)); 
                }
            }
            scan.close();
            // System.out.println("Total log: " + total);
            // System.out.println("Processed: " + proccessed);
            // System.out.println("Left: " + left);
        }catch(IOException e){
            System.out.println(e.getMessage());;
        }
        return log;
    }
    public String strExtractor(String oriStr, String wordToRemove) {
        String str = oriStr.replaceAll(wordToRemove,"");
        return str;
    }
    public int intExtractor(String oriStr, String wordToRemove) {
        String str = strExtractor(oriStr, wordToRemove);
        int integer = Integer.parseInt(str);
        return integer;
    }
    public logs switcher(String log[]) {
        switch (log[1]) {
            case "_slurm_rpc_submit_batch_job:":
                return e.batchJobExtractor(log);
            case "_slurm_rpc_kill_job:":
                return e.killJobExtractor(log);
            case "sched:":
                return e.schedulerExtractor(log);
            case "_job_create:":
                return e.createdJobExtractor(log);
            case "_job_complete:":
            case "job_complete:":
                return e.completedJobExtractor(log);
            case "error:":
                return e.errorExtractor(log);
            case "sched/backfill:":
                return e.backfillSchedulerExtractor(log);
            case "_slurm_rpc_resv_create":
            case "_slurm_rpc_resv_update":
                return e.reservationLogExtactor(log);
            case "Recovered":
                return e.recoveryExtractor(log);
            case "Time":
                return e.timeLimitExhaustionExtractor(log);
            case "update_node:":
            case "drain_nodes:":
            case "Node":
            case "node":
                return e.nodeLogExtractor(log);
            case "_slurm_rpc_update_job:":
            case "_update_job:":
                return e.updateJobExtractor(log);
            case "Requeuing":
                return e.requeueExtractor(log);
            case "cleanup_completing:":
                return e.cleanupLogExtractor(log);
            default:
                // System.out.println(Arrays.toString(log));
                return null;  
        }
    }
}

