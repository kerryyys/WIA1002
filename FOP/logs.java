import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class logs {
    private final String dateTime, LogName, partition, NodeList, user, account, info, reservationName, nodes, licenses, tres, reservationStartTime, reservationEndTime, maxStartDelay, limit, keyWord, nodeType, deviceIP, stepId;
    private final int JobId, InitPrio, Usec, gpu, uid, signal, cores, exitStatus, terminateSignal, associationNum, seconds;
    private final ArrayList cpu;
    private final long watts;
    private final Boolean cancelled;
    public logs(String DT, String LN, String PT, int J, int IP, int U, String NL, ArrayList C, int G, String User, String A, String I, int UID, int S, String R, String N, String Li, String Tres, String ResST, String ResET, String MSD, int Cores, long W, String Limit, int es, int ts, String key, int an, String nt, String di, String si, int sec, Boolean cancelled) {
        this.dateTime = DT;
        this.LogName = LN;
        this.partition = PT;
        this.JobId = J;
        this.InitPrio = IP;
        this.Usec = U;
        this.NodeList = NL;
        this.cpu = C;
        this.gpu = G;
        this.user = User;
        this.account = A;
        this.info = I;
        this.uid = UID;
        this.signal = S;
        this.reservationName = R;
        this.nodes = N;
        this.licenses = Li;
        this.tres = Tres;
        this.reservationStartTime = ResST;
        this.reservationEndTime = ResET;
        this.maxStartDelay = MSD;
        this.cores = Cores;
        this.watts = W;
        this.limit = Limit;
        this.exitStatus = es;
        this.terminateSignal = ts;
        this.keyWord = key;
        this.associationNum = an;
        this.nodeType = nt;
        this.deviceIP = di;
        this.stepId = si;
        this.seconds = sec;
        this.cancelled = cancelled;
    }

    // getter
    public String getLogName() {
        return this.LogName;
    }
    public String getDateTime(String format) throws ParseException {
        SimpleDateFormat DateFor = new SimpleDateFormat(format);
        SimpleDateFormat inputDate = new SimpleDateFormat(" yyyy MM dd HH mm ss SSS ");
        Date date = inputDate.parse(this.dateTime);
        return DateFor.format(date);
        //  return this.dateTime;
    }
    public String getPartition() {
        return this.partition;
    }
    public Integer getJobId() {
        return this.JobId;
    }
    public int getInitPrio() {
        return this.InitPrio;
    }
    public int getUsec() {
        return this.Usec;
    }
    public String getNodeList() {
        return this.NodeList;
    }
    public ArrayList getCpu() {
        return this.cpu;
    }
    public int getGpu() {
        return this.gpu;
    }
    public String getUser() {
        return this.user;
    }
    public String getAccount() {
        return this.account;
    }
    public String getInfo() {
        return this.info;
    }
    public int getUid() {
        return this.uid;
    }
    public int getSignal() {
        return this.signal;
    }
    public String getReservationName() {
        return this.reservationName;
    }
    public String getNodes() {
        return this.nodes;
    }
    public String getLicenses() {
        return this.licenses;
    }
    public String getTres() {
        return this.tres;
    }
    public String getReservationStartTime() {
        return this.reservationStartTime;
    }
    public String getReservationEndTime() {
        return this.reservationEndTime;
    }
    public String getMaxStartDelay() {
        return this.maxStartDelay;
    }
    public int getCores() {
        return this.cores;
    }
    public long getWatts() {
        return this.watts;
    }
    public String getLimit() {
        return this.limit;
    }
    public int getExitStatus() {
        return this.exitStatus;
    }
    public int getTerminateSignal() {
        return this.terminateSignal;
    }
    public int getAssociationNum() {
        return this.associationNum;
    }
    public String nodeType() {
        return this.nodeType;
    }
    public String getKeyWord() {
        return this.keyWord;
    }
    public String getIP() {
        return this.deviceIP.split(":")[1];
    }
    public String getIPwithPort() {
        return this.deviceIP;
    }
    public String getPortNum() {
        return this.deviceIP.split(":")[1];
    }
    public String getStepId() {
        return this.stepId;
    }
    public int getSeconds() {
        return this.seconds;
    }
    public Boolean getJobCompleteByCancellation() {
        return this.cancelled;
    }
    // toString
    public String toString() {
        return "Log[datetime=" + dateTime + ", keyword=" + keyWord + ", logname=" + LogName + ", partition=" + partition + ", jobid=" + JobId + ", initprio=" + InitPrio + ", usec=" + Usec + ", nodelist=" + NodeList + ", cpu=" + cpu + ", gpu=" + gpu + ", user=" + user + ", account=" + account + ", info=" + info + ", uid=" + uid + ", signal=" + signal + ", reservationname=" + reservationName + ", nodes=" + nodes + ", licenses=" + licenses + ", tres=" + tres + ", reservationstartime=" + reservationStartTime + ", reservationendtime=" + reservationEndTime + ", maxstartdelay=" + maxStartDelay + ", cores=" + cores + ", watts" + watts + ", limit=" + limit + ", exitstatus=" + exitStatus + ", jobCompleteByCancellation?=" + cancelled + ", terminatesignal=" + terminateSignal + ", assocationnumber=" + associationNum + ", nodetype=" + nodeType + ", deviceip=" + deviceIP + ", stepid=" + stepId + ", second=" + seconds + "]";
    }
}
