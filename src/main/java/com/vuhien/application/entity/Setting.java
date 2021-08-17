package com.vuhien.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by VuHien96 on 17/08/2021 10:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "setting")
public class Setting {
    @Id
    @Column(name = "setting_id")
    private String settingId;
    @Column(name = "setting")
    private String setting;
    @Column(name = "description")
    private String description;
}
