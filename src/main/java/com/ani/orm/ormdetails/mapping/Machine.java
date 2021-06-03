package com.ani.orm.ormdetails.mapping;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcId;

    private String mcNm;
    private Boolean isOk;

    @ManyToMany
    @JoinTable(
            name = "vm_processors",
            joinColumns = @JoinColumn(name="mcId"),
            inverseJoinColumns = @JoinColumn(name="prcId")
    )
    private Set<Processor> processors = new HashSet<>();

    public Long getMcId() {
        return mcId;
    }

    public void setMcId(Long mcId) {
        this.mcId = mcId;
    }

    public String getMcNm() {
        return mcNm;
    }

    public void setMcNm(String mcNm) {
        this.mcNm = mcNm;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }


    public Set<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(Set<Processor> processors) {
        this.processors = processors;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "mcId=" + mcId +
                ", mcNm='" + mcNm + '\'' +
                ", isOk=" + isOk +
                '}';
    }
}
