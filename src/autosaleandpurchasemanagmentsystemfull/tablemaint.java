package autosaleandpurchasemanagmentsystemfull;


public class tablemaint {
    String mtype;
    String part;
    String task;
    String mech;
    String comm;

    public tablemaint(String mtype, String part, String task, String mech, String comm) {
        this.mtype = mtype;
        this.part = part;
        this.task = task;
        this.mech = mech;
        this.comm = comm;
    }

    public void setMech(String mech) {
        this.mech = mech;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getMech() {
        return mech;
    }

    public String getComm() {
        return comm;
    }

    

    public String getMtype() {
        return mtype;
    }

    public String getPart() {
        return part;
    }

    public String getTask() {
        return task;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
    
    

}
