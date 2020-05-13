package org.disco.pojo;

public class Output {
    private String experimentId = "";
    private String treatmentId = "";
    private String segmentId = "";
    private Integer success = 0;
    private Integer failure = 0;
    public Output(){}
    public Output(Event e) {
        this.experimentId = e.getExperimentId();
        this.segmentId = e.getSegmentId();
        this.treatmentId = e.getTreatmentId();
        this.success = e.getReward() == 1 ? 1 : 0;
        this.failure = e.getReward() == 0 ? 1 : 0;
    }
    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFailure() {
        return failure;
    }

    public void setFailure(Integer failure) {
        this.failure = failure;
    }

    @Override
    public String toString() {
        return "Output{" +
                "experimentId='" + experimentId + '\'' +
                ", treatmentId='" + treatmentId + '\'' +
                ", segmentId='" + segmentId + '\'' +
                ", success=" + success +
                ", failure=" + failure +
                '}';
    }
}
