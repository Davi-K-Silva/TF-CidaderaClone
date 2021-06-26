package com.grupo2.TFCidaderaClone.aplication.dtos;

public class EstatisticaDTO {
    private double percentRespostas;
    private double percentStatus;
    private double mediaComent;
    private double totalRec;
    
    public EstatisticaDTO(double percentRespostas, double percentStatus, double mediaComent, int totalRec){
        this.percentRespostas = percentRespostas;
        this.percentStatus = percentStatus;
        this.mediaComent = mediaComent;
        this.totalRec = totalRec;
    }

    public double getPercentRespostas() {
        return this.percentRespostas;
    }

    public double getPercentStatus() {
        return this.percentStatus;
    }

    public double getMediaComent() {
        return this.mediaComent;
    }

    public double getTotalRec() {
        return this.totalRec;
    }

}
