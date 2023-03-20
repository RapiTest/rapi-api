package io.rapi.api.config;

public class Report {
    private String type = "json";
    private int snapshot = 0;
    private int snapshotQuality = 20;

    public void setSnapshot(int snapshot) {
        if (snapshot >= 0 && snapshot <= 2)
            this.snapshot = snapshot;
        else {
            throw new Error("Unsupport snapshot value " + snapshot);
        }
    }

    public void setSnapshotQuality(int snapshotQuality) {
        if (snapshotQuality >= 0 && snapshotQuality <= 100)
            this.snapshotQuality = snapshotQuality;
        else {
            throw new Error("Unsupport snapshot value " + snapshotQuality);
        }
    }

    public void setType(String type) {
        if (type.equals("json") || type.equals("html") || type.equals("all"))
            this.type = type;
        else {
            throw new Error("Unknown type " + type);
        }
    }

    public int getSnapshot() {
        return snapshot;
    }

    public int getSnapshotQuality() {
        return snapshotQuality;
    }

    public String getType() {
        return type;
    }

}
