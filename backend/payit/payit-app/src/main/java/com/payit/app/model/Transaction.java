package com.payit.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="bankId")
    private User bankId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="slaveId")
    private User slaveId;
    private Float value;
    private Date endDate;
    private Boolean completed=false;
}
