//package org.portfolio.englishproject.model;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.NoArgsConstructor;
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Table(name = "category")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//}
