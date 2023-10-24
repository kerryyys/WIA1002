import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class analysis {
    boolean flag = false;
    ArrayList<logs> log;
    analysis(ArrayList<logs> log){
        this.log = log;
    }

    public ArrayList<Boolean> timeRange(String start, String end, String format) throws ParseException{
        ArrayList<Boolean> timeRange = new ArrayList<Boolean>();
        int startData[] = new int [7]; 
        int endData[] = new int [7];
        int data[] = new int [7];
        String Start[] = start.split("[^\\w\\d]+"); // split by everything except for digit or word
        String End[] = end.split("[^\\w\\d]+");
        for(logs L:log){ 
            String check[] = L.getDateTime(format).split("[^\\w\\d]+"); 
            for(int i = 0;i < Start.length;i++){
                startData[i] = Integer.parseInt(Start[i]);
                endData[i] = Integer.parseInt(End[i]);
                data[i] = Integer.parseInt(check[i]);
            }
            
            if(data[0]>=startData[0]&&data[0]<=endData[0]){ //check if it is in the range
                if(data[1]!=0 && data[0]==endData[0]){
                    if(data[1]>=startData[1]&&data[1]<=endData[1]){
                        if(data[2]!=0 && data[1]==endData[1]){ 
                            if(data[2]>=startData[2]&&data[2]<=endData[2]){
                                if(data[3]!=0 && data[2]==endData[2]){
                                    if(data[3]>=startData[3]&&data[3]<=endData[3]){
                                        if(data[4]!=0 && data[3]==endData[3]){
                                            if(data[4]>=startData[4]&&data[4]<=endData[4]){
                                                if(data[5]!=0 && data[4]==endData[4]){
                                                    if(data[5]>=startData[5]&&data[5]<=endData[5]){
                                                        if(data[6]!=0 && data[5]==endData[5]){
                                                            if(data[6]>=startData[6]&&data[6]<=endData[6]){
                                                                flag = true;
                                                            }else{
                                                                flag = false;
                                                            }
                                                        }else{
                                                            flag = true;
                                                        }
                                                    }else{
                                                        flag = false;
                                                    }
                                                }else{
                                                    flag = true;
                                                }
                                            }else{
                                                flag = false;
                                            }
                                        }else{
                                            flag = true;
                                        }
                                    }else{
                                        flag = false;
                                    }
                                }else{
                                    flag = true;
                                }
                            }else{
                                flag = false;
                            }
                        }else{
                            flag = true;
                        }
                    }else{
                        flag = false;
                    }
                }else{
                    flag = true;
                }
            }else{
                flag = false;
            }
            timeRange.add(flag);
        }
        return timeRange;
    }

    public void getJobStarted(ArrayList<Boolean> timeRange) throws ParseException{
        int count = 0;
        System.out.println("date of jobs created within a time range: ");
        for(int i=0;i<timeRange.size();i++){ // to get job created within a time range
            if(timeRange.get(i)){
                if(log.get(i).getLogName() != null && log.get(i).getLogName().contains("Job scheduled to run")){
                    System.out.println(log.get(i).getDateTime("yyyy/MM/dd/HH/mm/ss/SSS"));
                    count++;
                }
            }
        }
        System.out.println("total job created within the time range is: "+count);
    }

    public void getJobEnded(ArrayList<Boolean> timeRange) throws ParseException{
        int count = 0;
        System.out.println("date of jobs ended within a time range: ");
        for(int i=0;i<timeRange.size();i++){ // to get job ended within a time range
            if(timeRange.get(i)){
                if(log.get(i).getKeyWord().contains("job_complete:") && log.get(i).getLogName().matches("Job done")){
                    System.out.println(log.get(i).getDateTime("yyyy/MM/dd/HH/mm/ss/SSS"));
                    count++;
                }
            }
        }
        System.out.println("total job ended within the time range is: "+count);
    }

    public ArrayList<Integer> partitionNonDuplicateJobID(String filter , String key){
        ArrayList<Integer>jobId = new ArrayList<Integer>();
        flag = true;
        for(logs L:log){
            if(L.getPartition()!=null && L.getJobId()!=null && L.getKeyWord().matches(key)){
                if(L.getPartition().contains(filter)){
                    for(int i=0;i<jobId.size();i++){
                        if(L.getJobId()==jobId.get(i)){
                            flag = false;
                            break;
                        }else{
                            flag = true;
                        }
                    }
                    if(flag){
                        jobId.add(L.getJobId());
                    }
                }
            }
        }
        return jobId;
    }

    public void getEPYC(ArrayList<Integer> epycNonDupJobID){
        System.out.println(epycNonDupJobID);
        System.out.println("the total number of jobs by partition EPYC is: " + epycNonDupJobID.size());
    }

    public void getOPTERON(ArrayList<Integer> opteronNonDupJobID){
        System.out.println(opteronNonDupJobID);
        System.out.println("the total number of jobs by partition OPTERON is: " + opteronNonDupJobID.size());
    }

    public void getGPU(ArrayList<Integer> gpuNonDupJobID){
        System.out.println(gpuNonDupJobID);
        System.out.println("the total number of jobs by partition GPU is: " + gpuNonDupJobID.size());
    }

    public void getInfoBasedOnError(String errorType) throws ParseException{
        int count = 0;
        ArrayList <String> dateTime = new ArrayList<String>();
        ArrayList <Integer> assocNum = new ArrayList<Integer>();
        ArrayList <String> user = new ArrayList<String>();
        for (logs L:log) {
                if (L.getKeyWord().contains("error")) {
                    if(L.getLogName().matches("No access to QoS error") && L.getLogName().matches(errorType)){
                        System.out.println("user "+L.getUser() + " from association "+L.getAssociationNum()+" made an error on "+L.getDateTime("yyyy/MM/dd/HH/mm/ss/SSS"));
                        count++;
                        dateTime.add(L.getDateTime("yyyy/MM/dd/HH/mm/ss/SSS"));
                        assocNum.add(L.getAssociationNum());
                        user.add(L.getUser());
                    }else if(L.getLogName().matches("Security violation") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("User not found error") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("GPU resources deallocation error") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Lookup failure for node") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Invalid node specified") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Socket timed out on send/recv operation") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Association TRES running seconds error") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Different slurm.conf than the slurmctld error") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Epilog error") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Job epilog failed") && L.getLogName().matches(errorType)){
                        count++;
                    }else if(L.getLogName().matches("Nodes not responding") && L.getLogName().matches(errorType)){
                        count++;
                    }else{
                        if(L.getLogName().matches("other errors") && L.getLogName().matches(errorType)){
                            count++;
                        } 
                    }
                }            
        }
        System.out.println("the number of error of type \"" + errorType+"\" is: " + count);
    }

    public void getAverageExcecutionTime() throws ParseException{
        int id;
        int count = 0;
        Date d1,d2;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss/SSS");
        double differenceInMinute = 0;
        for(logs L:log){
            if(L.getLogName() != null && L.getLogName().matches("Job scheduled to run")){
                id = L.getJobId();
                for(logs l:log){
                    if(l.getJobId() == id && l.getKeyWord().matches("_job_complete:") && l.getLogName().matches("Job done")){
                        d1 = sf.parse(L.getDateTime("yyyy/MM/dd/HH/mm/ss/SSS"));
                        d2 = sf.parse(l.getDateTime("yyyy/MM/dd/HH/mm/ss/SSS"));
                        differenceInMinute += (d2.getTime() - d1.getTime())/60000.00;
                        count++;
                    }
                }
            }
        }
        System.out.println(differenceInMinute / count);
    }
}

