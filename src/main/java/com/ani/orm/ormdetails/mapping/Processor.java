package com.ani.orm.ormdetails.mapping;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prcId;
    private Integer type;
    private String make;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brd_id", referencedColumnName = "brdId", updatable = false, nullable = false)
    private Board board;

    @ManyToMany(mappedBy = "processors")
    private Set<Machine> machines = new HashSet<>();

    public Long getPrcId() {
        return prcId;
    }

    public void setPrcId(Long prcId) {
        this.prcId = prcId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Set<Machine> getMachines() {
        return machines;
    }

    public void setMachines(Set<Machine> machines) {
        this.machines = machines;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "prcId=" + prcId +
                ", type=" + type +
                ", make='" + make + '\'' +
                '}';
    }
}
