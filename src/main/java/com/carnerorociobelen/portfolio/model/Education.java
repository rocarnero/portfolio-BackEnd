package com.carnerorociobelen.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String title;
  @Column(columnDefinition="TEXT")
  private String description;
  @Column(columnDefinition="TEXT")
  private String image_url;
  private String init_date;
  private String end_date;
  @ManyToOne
  @JsonBackReference
  private User user;
}
