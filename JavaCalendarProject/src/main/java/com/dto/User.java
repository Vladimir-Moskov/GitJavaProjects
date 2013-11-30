package main.java.com.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="ID")
	private long id;
	
	@NotNull
    @Column(name="NAME")
	private String name;
	
	@NotNull
    @Column(name="PASSWORD")
	private String password;
	
	@NotNull
    @Column(name="FIRST_NAME")
	private String firstName;
	
	@NotNull
    @Column(name="LAST_NAME")
	private String lastName;
	
	@NotNull
    @Column(name="EMAIL")
	private String email;
}
/*
 CREATE  TABLE `javadb`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(45) NULL ,
  `PASSWORD` VARCHAR(45) NULL ,
  `FIRST_NAME` VARCHAR(45) NULL ,
  `LAST_NAME` VARCHAR(45) NULL ,
  `EMAIL` VARCHAR(45) NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) );
 * */
 