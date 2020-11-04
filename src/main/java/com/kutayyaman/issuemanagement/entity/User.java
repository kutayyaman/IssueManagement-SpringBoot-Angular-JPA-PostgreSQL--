package com.kutayyaman.issuemanagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users") //tablo adi direkt olarak user olursa ozaman database tarafinda sorun yapabilir.
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "uname", length = 100, unique = true) //username koyarsak direkt adini ozaman database tarafinda sorun yapabilir.
	private String username;
	
	@Column(name = "pwd", length = 100) //password koyarsa kadini ozaman database tarafinda sorun olabilir.
	private String password; 
	
	@Column(name = "name_surname", length = 200)
	private String nameSurname;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@JoinColumn(name = "assignee_user_id")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Issue> issues;
}












