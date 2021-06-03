package com.ani.orm.ormdetails.mapping;

import javax.persistence.*;

@Entity
public class Chip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chId;
    private Boolean isPrg;
    private String compatibility;

    @ManyToOne
    @JoinColumn(name = "brdId", nullable = false, updatable = false)
    private Board board;

    public Long getChId() {
        return chId;
    }

    public void setChId(Long chId) {
        this.chId = chId;
    }

    public Boolean getPrg() {
        return isPrg;
    }

    public void setPrg(Boolean prg) {
        isPrg = prg;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "chId=" + chId +
                ", isPrg=" + isPrg +
                ", compatibility='" + compatibility + '\'' +
                '}';
    }
}
