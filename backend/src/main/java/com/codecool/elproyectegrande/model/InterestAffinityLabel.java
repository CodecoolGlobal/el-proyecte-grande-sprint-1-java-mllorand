package com.codecool.elproyectegrande.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class InterestAffinityLabel extends AffinityLabelWithPresetValues<InterestPriority>{
}
