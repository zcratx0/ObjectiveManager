package me.zcratx.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Objective implements Serializable {
    @JsonProperty("specific")
    String specific;
    @JsonProperty("measurable")
    String measurable;
    @JsonProperty("attainable")
    String attainable;
    @JsonProperty("relevant")
    String relevant;
    @JsonProperty("timeBound")
    String timeBound;
    @JsonProperty("termDuration")
    Type termDuration;

    public Objective(String specific) {
        this.specific = specific;
    }
    public  Objective() {
        super();
    }

    public Objective(java.lang.String specific, java.lang.String measurable, java.lang.String attainable, java.lang.String relevant, java.lang.String timeBound, Type termDuration) {
        this.specific = specific;
        this.measurable = measurable;
        this.attainable = attainable;
        this.relevant = relevant;
        this.timeBound = timeBound;
        this.termDuration = termDuration;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public String getMeasurable() {
        return measurable;
    }

    public void setMeasurable(String measurable) {
        this.measurable = measurable;
    }

    public String getAttainable() {
        return attainable;
    }

    public void setAttainable(String attainable) {
        this.attainable = attainable;
    }

    public String getRelevant() {
        return relevant;
    }

    public void setRelevant(String relevant) {
        this.relevant = relevant;
    }

    public String getTimeBound() {
        return timeBound;
    }

    public void setTimeBound(String timeBound) {
        this.timeBound = timeBound;
    }

    public Type getTermDuration() {
        return termDuration;
    }

    public void setTermDuration(Type termDuration) {
        this.termDuration = termDuration;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "specific='" + specific + '\'' +
                ", measurable='" + measurable + '\'' +
                ", attainable='" + attainable + '\'' +
                ", relevant='" + relevant + '\'' +
                ", timeBound='" + timeBound + '\'' +
                ", termDuration=" + termDuration +
                '}';
    }
}
