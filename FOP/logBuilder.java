import java.util.ArrayList;
import java.util.Arrays;
import java.util.random.RandomGeneratorFactory;

public class logBuilder {
    private String dateTime, keyWord,LogName, partition, NodeList, user, account, info, reservationName, nodes, licenses, tres, reservationStartTime, reservationEndTime, maxStartDelay, limit, nodeType, deviceIP, stepId;
    private int JobId, InitPrio, Usec, gpu, uid, signal, cores, exitStatus, terminateSignal, associationNum, seconds;
    private ArrayList cpu;
    private long watts;
    private Boolean cancelled;
    tools t = new tools();
    public logBuilder datetime(String dt) {
        this.dateTime = dt.replaceAll("[^0-9]"," ");
        return this;
    }
    public logBuilder logname(String ln) {
        this.LogName = ln;
        return this;
    }
    public logBuilder partition(String pt) {
        String strPartition = t.strExtractor(pt, "(Partition=|')");
        this.partition = (strPartition == "(null)") ? null : strPartition;
        return this;
    }
    public logBuilder jobid(String id) {
        this.JobId = t.intExtractor(id, "JobId=");
        return this;
    }
    public logBuilder initprio(String ip) {
        this.InitPrio = t.intExtractor(ip, "InitPrio=");
        return this;
    }
    public logBuilder usec(String u) {
        this.Usec = t.intExtractor(u, "usec=");
        return this;
    }
    public logBuilder nodelist(String nl) {
        String strNodeList = t.strExtractor(nl, "NodeList=");
        this.NodeList = (strNodeList == "(null)") ? null : strNodeList;
        return this;
    }
    public logBuilder cpu(String c) {
        String strCPU = t.strExtractor(c, "(#CPUs=|cpu\\[|cpu|\\])"); //#CPUs= and cpu dunno same anot
        ArrayList<Integer> cpu = new ArrayList<Integer>();
        if (strCPU.contains(",") && (strCPU.contains("-"))) {
            for (String C : strCPU.split(","))  {
                if (C.contains("-")) {
                    String range[] = C.split("-");
                    cpu.add(Integer.parseInt(range[0]));
                    for (int i = 1; i <= (Integer.parseInt(range[range.length-1]) - Integer.parseInt(range[0])); i++) {
                        cpu.add(Integer.parseInt(range[0]) + i);
                    }
                } else {
                    cpu.add(Integer.parseInt(C));
                }
            }
        } else if (strCPU.contains(",")) {
            for (String C : strCPU.split(","))  {
                cpu.add(Integer.parseInt(C));
            }
        } else if (strCPU.contains("-")) {
            String range[] = strCPU.split("-");
            cpu.add(Integer.parseInt(range[0]));
            for (int i = 1; i <= (Integer.parseInt(range[range.length-1]) - Integer.parseInt(range[0])); i++) {
                cpu.add(Integer.parseInt(range[0]) + i);
            }
        } else { cpu.add(Integer.parseInt(strCPU)); }
        this.cpu = cpu;
        return this;
    }
    public logBuilder gpu(String g) {
        this.gpu = t.intExtractor(g, "gpu");
        return this;
    }
    public logBuilder user(String u) {
        String strUser = t.strExtractor(u, "user=").replaceAll("\'", "");
        this.user = (strUser == "(null)") ? null : strUser;
        return this;
    }
    public logBuilder account(String a) {
        String strAccount = t.strExtractor(a, "(account=|')");
        this.account = (strAccount == "(null)") ? null : strAccount;
        return this;
    }
    public logBuilder info(String i) {
        this.info = t.strExtractor(i, "returned: ");
        return this;
    }
    public logBuilder uid(String uid) {
        this.uid = t.intExtractor(uid, "(uid |uid=|,|:)");
        return this;
    }
    public logBuilder signal(String sig) {
        this.signal = t.intExtractor(sig, "sig=");
        return this;
    }
    public logBuilder reservationName(String res) {
        this.reservationName = t.strExtractor(res, "(reservation=|:)");
        return this;
    }
    public logBuilder nodes(String node) {
        this.nodes = t.strExtractor(node, "nodes=");
        return this;
    }
    public logBuilder cores(String core) {
        this.cores = t.intExtractor(core, "cores=");
        return this;
    }
    public logBuilder licenses(String li) {
        String strLicense = t.strExtractor(li, "licenses=");
        this.licenses = (strLicense == "(null)") ? null : strLicense;
        return this;
    }
    public logBuilder tres(String tres) {
        this.tres = t.strExtractor(tres, "tres=");
        return this;
    }
    public logBuilder watts(String watts) {
        String strWatt = t.strExtractor(watts, "watts=");
        this.watts = Long.parseLong(strWatt);
        return this;
    }
    public logBuilder ResStartDateTime(String start) {
        this.reservationStartTime = start.replaceAll("[^0-9]"," ");
        return this;
    }
    public logBuilder ResEndDateTime(String end) {
        this.reservationEndTime = end.replaceAll("[^0-9]"," ");
        return this;
    }
    public logBuilder maxStartDelay(String msd) {
        String strMsd = t.strExtractor(msd, "MaxStartDelay=");
        this.maxStartDelay = (strMsd == "") ? null : strMsd;
        return this;
    }
    public logBuilder limit(String limit) {
        this.limit = limit;
        return this;
    }
    public logBuilder exitStatus(String es) {
        this.exitStatus = Integer.parseInt(es);
        return this;
    }
    public logBuilder terminateSig(String ts) {
        this.terminateSignal = Integer.parseInt(ts);
        return this;
    }
    public logBuilder keyWord(String key) {
        this.keyWord = key;
        return this;
    }
    public logBuilder associationNumber(String an) {
        this.associationNum = Integer.parseInt(an);
        return this;
    }
    public logBuilder nodeType(String nt) {
        this.nodeType = nt;
        return this;
    }
    public logBuilder deviceIP(String di) {
        this.deviceIP = di;
        return this;
    }
    public logBuilder stepId(String si) {
        this.stepId = si;
        return this;
    }
    public logBuilder seconds(String s) {
        this.seconds = Integer.parseInt(s);
        return this;
    }
    public logBuilder cancelledByUser(Boolean status) {
        this.cancelled = status;
        return this;
    }
    public logs build() {
        return new logs(dateTime, LogName, partition, JobId, InitPrio, Usec, NodeList, cpu, gpu, user, account, info, uid, signal, reservationName, nodes, licenses, tres, reservationStartTime, reservationEndTime, maxStartDelay, cores, watts, limit, exitStatus, terminateSignal, keyWord, associationNum, nodeType, deviceIP, stepId, seconds, cancelled);
    }
}