import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractor {
    Pattern AssocNumPattern = Pattern.compile("This association (\\d+)\\(|assoc (\\d+)|Assoc=(\\d+)");
    Pattern AccPattern = Pattern.compile("account='([^']*)'");
    Pattern UserPattern = Pattern.compile("user='(.+?)'|User ([0-9]+) ");
    Pattern PartitionPattern = Pattern.compile("partition='(.+?)'");
    Pattern JobPattern = Pattern.compile("job ([0-9]+)|JobId=([0-9]+) ");
    Pattern NodePattern = Pattern.compile("[Nn]odes? ([a-zA-Z0-9]+) |node \"(.+?)\"|Node=([a-zA-Z0-9]+)|");
    Pattern NodeTypePattern = Pattern.compile("type ([a-zA-Z0-9]+) ");
    Pattern UidPattern = Pattern.compile("uid[= ]([0-9]+)");
    Pattern IPPattern = Pattern.compile("(?:[0-9]{1,3}.){3}[0-9]{1,3}:([0-9]{1,5})");
    Pattern StepIdPattern = Pattern.compile("StepId=([a-zA-Z0-9]+)");
    Pattern UsecPattern = Pattern.compile("usec=([a-zA-Z0-9]+)");
    Pattern infoPattern = Pattern.compile("(.+?) for");
    Pattern secondPattern = Pattern.compile("([0-9]+) seconds");

    public logs batchJobExtractor(String log[]) {
        if (log[2].contains("JobId") && log[2].contains("InitPrio") && log[2].contains("usec")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job submission RPC received")
                .jobid(logdetail[0])
                .initprio(logdetail[1])
                .usec(logdetail[2])
                .keyWord(log[1])
                .build();
            return a;
        } else {
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job submissions error")
                .info(log[2])
                .keyWord(log[1])
                .build();
            return a;
        }
    }
    public logs killJobExtractor(String log[]) {
        if (log[2].contains("REQUEST_KILL_JOB")) {
            String logdetail[] = log[2].split(" ",3);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job immediate termination")
                .jobid(logdetail[1])
                .uid(logdetail[2])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("job_str_signal()")) {
            String logdetail[] = log[2].split(" ",5);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job terminated by signal")
                .jobid(logdetail[2])
                .uid(logdetail[1])
                .signal(logdetail[3])
                .info(logdetail[4])
                .keyWord(log[1])
                .build();
            return a;
        }
        return null;
    }
    public logs schedulerExtractor(String log[]) {
        if (log[2].contains("Allocate")) {
            String logdetail[] = log[2].split(" ",5);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job scheduled to run")
                .jobid(logdetail[1])
                .nodelist(logdetail[2])
                .cpu(logdetail[3])
                .partition(logdetail[4])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("_slurm_rpc_allocate_resources")) {
            String logdetail[] = log[2].split(" ",5);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Resources being allocated")
                .jobid(logdetail[1])
                .nodelist(logdetail[2])
                .usec(logdetail[3])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("_hold_job_rec")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Place a hold on job")
                .jobid(logdetail[3])
                .uid(logdetail[6])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("_update_job")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Update information about job")
                .jobid(logdetail[logdetail.length-1])
                .keyWord(log[1])
                .build();
                // not done yet, have to process what's updated, time limit, resource allocation etc.
            return a;
        } else if (log[2].contains("Created reservation")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Scheduler created reservation")
                .reservationName(logdetail[1])
                .user(logdetail[2])
                .nodes(logdetail[3])
                .cores(logdetail[4])
                .licenses(logdetail[5])
                .tres(logdetail[6])
                .watts(logdetail[7])
                .ResStartDateTime(logdetail[8])
                .ResEndDateTime(logdetail[9])
                .maxStartDelay(logdetail[10])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("Updated reservation")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Scheduler updated reservation")
                .reservationName(logdetail[1])
                .user(logdetail[2])
                .nodes(logdetail[3])
                .cores(logdetail[4])
                .licenses(logdetail[5])
                .tres(logdetail[6])
                .watts(logdetail[7])
                .ResStartDateTime(logdetail[8])
                .ResEndDateTime(logdetail[9])
                .maxStartDelay(logdetail[10])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("_release_job_rec")) {
            String logdetail[] = log[2].split(" ",7);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Hold released")
                .jobid(logdetail[4])
                .uid(logdetail[6])
                .keyWord(log[1])
                .build();
            return a;
        }
        return null;
    }
    public logs createdJobExtractor(String log[]) {
        if (log[2].contains("exceeded association")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Exceeded limit error message")
                .uid(logdetail[5])
                .limit(logdetail[6])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("invalid account or partition")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Invalid account or partition error message")
                .uid(logdetail[6])
                .account(logdetail[8])
                .partition(logdetail[11])
                .keyWord(log[1])
                .build();
            return a;
        }
        return null;
    }
    public logs completedJobExtractor(String log[]) {
        if (log[2].contains("OOM failure")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("out of memory failure")
                .jobid(logdetail[0])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("cancelled by node failure")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job cancelled by node failure")
                .jobid(logdetail[0])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("done")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Job done")
                .jobid(logdetail[0])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("WEXITSTATUS")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Exit status of a batch job")
                .jobid(logdetail[0])
                .exitStatus(logdetail[2])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("cancelled by interactive user")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("cancelled by user")
                .jobid(logdetail[0])
                .cancelledByUser(true)
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("WTERMSIG")) {
            String logdetail[] = log[2].split(" ");
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Exit status of a batch job")
                .jobid(logdetail[0])
                .terminateSig(logdetail[2])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("requeue")) {
            String logdetail[] = log[2].split(" ",3);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("Exit status of a requeue job")
                .jobid(logdetail[1])
                .info(logdetail[2])
                .keyWord(log[1])
                .build();
            return a;
        } else if (log[2].contains("invalid")) {
            String logdetail[] = log[2].split(" ",2);
            logs a = new logBuilder()
                .datetime(log[0])
                .logname("invalid job ID")
                .jobid(logdetail[1])
                .info(logdetail[0])
                .keyWord(log[1])
                .build();
            return a;
        }
        return null;
    }
    public logs errorExtractor(String log[]) {
        Matcher AssocNumMatcher = AssocNumPattern.matcher(log[2]);
        Matcher AccMatcher = AccPattern.matcher(log[2]);
        Matcher UserMatcher = UserPattern.matcher(log[2]);
        Matcher PartitionMatcher = PartitionPattern.matcher(log[2]);
        Matcher JobMatcher = JobPattern.matcher(log[2]);
        Matcher NodeMatcher = NodePattern.matcher(log[2]);
        Matcher NodeTypeMatcher = NodeTypePattern.matcher(log[2]);
        Matcher UidMatcher = UidPattern.matcher(log[2]);
        Matcher IPMatcher = IPPattern.matcher(log[2]);
        
        logBuilder LB = new logBuilder()
            .datetime(log[0])
            .keyWord(log[1]);

        // System.out.println(LB.toString());

        if (AssocNumMatcher.find()) { for (int i = 1; i <= 3; i++) { if (AssocNumMatcher.group(i) != null) { LB.associationNumber(AssocNumMatcher.group(i)); }}}
        if (AccMatcher.find()) { LB.account(AccMatcher.group(1)); }
        if (UserMatcher.find()) { LB.user((UserMatcher.group(1) != null) ? UserMatcher.group(1) : UserMatcher.group(2)); }
        if (PartitionMatcher.find()) { LB.partition(PartitionMatcher.group(1)); }
        if (JobMatcher.find()) { LB.jobid((JobMatcher.group(1) != null) ? JobMatcher.group(1) : JobMatcher.group(2)); }
        if (NodeMatcher.find()) { for (int i = 1; i <= 3; i++) { if (NodeMatcher.group(i) != null) { LB.nodes(NodeMatcher.group(i)); }}}
        if (NodeTypeMatcher.find()) { LB.nodeType(NodeTypeMatcher.group(1)); }
        if (UidMatcher.find()) { LB.uid(UidMatcher.group(1)); }
        if (IPMatcher.find()) { LB.deviceIP(IPMatcher.group()); }


        if (log[2].contains("does not have access to qos")) {
            LB.info(log[2].split(" ", 6)[5])
                .logname("No access to QoS error");         
        } else if (log[2].matches("User [0-9]+ not found")) {
            LB.info(log[2])
                .logname("User not found error");
        } else if (log[2].matches("gres/gpu: job [0-9]+ dealloc .+")) {
            LB.info(log[2].split(" ",9)[8])
                .logname("GPU resources deallocation error");
        } else if (log[2].contains("Security violation")) {
            LB.info(log[2].split(" ",2)[1])
                .logname("Security violation");
        } else if (log[2].contains("_find_node_record:")) {
            LB.info(log[2].split(" ", 2)[1])
                .logname("Lookup failure for node");
        } else if (log[2].contains("node_name2bitmap:")) {
            LB.info(log[2].split(" ", 2)[1])
                .logname("Invalid node specified");
        } else if (log[2].contains("slurm_receive_msg")) {
            LB.info(log[2].split(" ", 3)[2])
                .logname("Socket timed out on send/recv operation");
        } else if (log[2].contains("_handle_assoc_tres_run_secs:")) {
            LB.info(log[2].split(" ", 6)[5])
                .logname("Association TRES running seconds error");
        } else if (log[2].contains("different slurm.conf than the slurmctld")) {
            LB.info(log[2].split(" ", 12)[11])
                .logname("Different slurm.conf than the slurmctld error");
        } else if (log[2].contains("job_epilog_complete")) {
            LB.info(log[2].split(",")[1])
                .logname("Epilog error");
        } else if (log[2].contains("_slurm_rpc_epilog_complete")) {
            LB.info("Job epilog failed")
                .logname("Job epilog failed");
        } else if (log[2].contains("not responding")) {
            if (log[2].contains(",") == true) { LB.info(log[2].split(", ")[1]); }
            LB.logname("Nodes not responding");
        } else {
            // System.out.println(Arrays.toString(log));; //not done yet few hundreds line left.
            LB.logname("other errors");
        }
        
        logs a = LB.build();
        return a;
    }
    public logs backfillSchedulerExtractor(String log[]) {
        String logdetail[] = log[2].split(" ");
        logBuilder LB = new logBuilder()
            .datetime(log[0])
            .logname("Backfill Scheduler schedule job to start")
            .jobid(logdetail[2])
            .partition(logdetail[4])
            .keyWord(log[1]);
        if (logdetail[6].contains("cpu")) {
            logs a = LB.cpu(logdetail[6])
                .build();
            return a;
        } else if (logdetail[6].contains("gpu")) {
            logs a = LB.gpu(logdetail[6])
                .build();
            return a;
        }
        return null;
    }
    public logs reservationLogExtactor(String log[]) {
        String logdetail[] = log[2].split(" ",2);
        logBuilder LB = new logBuilder()
            .datetime(log[0])
            .reservationName(logdetail[0])
            .info(logdetail[1])
            .keyWord(log[1]);
        if (log[1].contains("create")) {
            logs a = LB.logname("Create reservation")
                .build();
            return a;
        } else if (log[1].contains("update")) {
            logs a = LB.logname("Update reservation")
                .build();
            return a;
        }
        return null;
    }
    public logs timeLimitExhaustionExtractor(String log[]) {
        Matcher JobMatcher = JobPattern.matcher(log[2]);
        logBuilder LB = new logBuilder()
            .datetime(log[0])
            .keyWord(log[1])
            .logname("Time limit exhausted for job");
        if (JobMatcher.find()) { LB.jobid((JobMatcher.group(1) != null) ? JobMatcher.group(1) : JobMatcher.group(2)); }
        return LB.build();
    }
    public logs recoveryExtractor(String log[]) {
        logBuilder LB = new logBuilder()
            .datetime(log[0])
            .keyWord(log[1])
            .logname("Recovery log");
        if (log[2].contains("JobId")) {
            Matcher JobMatcher = JobPattern.matcher(log[2]);
            Matcher AssocNumMatcher = AssocNumPattern.matcher(log[2]);
            Matcher StepIdMatcher = StepIdPattern.matcher(log[2]);
            if (JobMatcher.find()) { LB.jobid((JobMatcher.group(1) != null) ? JobMatcher.group(1) : JobMatcher.group(2)); }
            if (AssocNumMatcher.find()) { for (int i = 1; i <= 3; i++) { if (AssocNumMatcher.group(i) != null) { LB.nodes(AssocNumMatcher.group(i)); }}}
            if (StepIdMatcher.find()) { LB.stepId(StepIdMatcher.group(1)); }
            LB.info("Job recovered");
        } else {
            LB.info("Recovered" + log[2]);
        }
        return LB.build();
    }
    public logs nodeLogExtractor(String log[]) {
        Matcher NodeMatcher = NodePattern.matcher(log[2]);
        logBuilder LB = new logBuilder();
        if (NodeMatcher.find()) { for (int i = 1; i <= 3; i++) { if (NodeMatcher.group(i) != null) { LB.nodes(NodeMatcher.group(i)); }}}
        LB.datetime(log[0])
            .keyWord(log[1]);
        if (log[1].contains("drain")) {
            LB.logname("Node updates")
                .info(log[2].split(" ",3)[2]);
        } else if (log[2].contains("update")) {
            LB.logname("Node draining")
                .info(log[2].split(" ",3)[2]);
        } else { 
            LB.nodes(log[2].split(" ")[0])
                .info(log[2].split(" ",2)[1]);
         }
        return LB.build();
    }
    public logs updateJobExtractor(String log[]) {
        Matcher JobMatcher = JobPattern.matcher(log[2]);
        Matcher UidMatcher = UidPattern.matcher(log[2]);
        Matcher UsecMatcher = UsecPattern.matcher(log[2]);
        Matcher InfoMatcher = infoPattern.matcher(log[2]);
        logBuilder LB = new logBuilder();
        if (JobMatcher.find()) { LB.jobid((JobMatcher.group(1) != null) ? JobMatcher.group(1) : JobMatcher.group(2)); }
        if (UidMatcher.find()) { LB.uid(UidMatcher.group(1)); }
        if (log[1].contains("_slurm_rpc_update_job:")) {
            if (UsecMatcher.find()) {
                LB.usec(UsecMatcher.group(1));
            } else {
                LB.info(log[2].split(" ",3)[2]);
            }
            LB.logname("Job update by slurm rpc");
        } else {
            if (JobMatcher.find()) {
                LB.info(InfoMatcher.group(1));
            } else {
                LB.info(log[2]);
            }
            LB.logname("Job update log");
        }
        LB.datetime(log[0])
            .keyWord(log[1]);
        return LB.build();
    }
    public logs requeueExtractor(String log[]) {
        Matcher JobMatcher = JobPattern.matcher(log[2]);
        logBuilder LB = new logBuilder();
        if (JobMatcher.find()) { LB.jobid((JobMatcher.group(1) != null) ? JobMatcher.group(1) : JobMatcher.group(2)); }
        LB.datetime(log[0])
            .logname("Requeue job")
            .keyWord(log[1]);
        return LB.build();
    }
    public logs cleanupLogExtractor(String log[]) {
        Matcher JobMatcher = JobPattern.matcher(log[2]);
        Matcher secMatcher = secondPattern.matcher(log[2]);
        logBuilder LB = new logBuilder();
        if (JobMatcher.find()) { LB.jobid((JobMatcher.group(1) != null) ? JobMatcher.group(1) : JobMatcher.group(2)); }
        if (secMatcher.find()) { LB.seconds(secMatcher.group(1)); }
        LB.datetime(log[0])
            .keyWord(log[1])
            .logname("Clean up completing");
        return LB.build();
    }
}
