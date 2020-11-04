package com.kutayyaman.issuemanagement.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "details",length = 4000)
	private String details;
	
	@Column(name = "description",length = 1000)
	private String description;
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "issue_status")
	@Enumerated(EnumType.STRING) //bunu demezsek veritabaninda bu enum'u sayisal karsiligiyla tutardi.
	private IssueStatus issueStatus;
	
	@JoinColumn(name = "assignee_user_id")
	@ManyToOne(optional = true,fetch = FetchType.LAZY) //optinal true dedik yani assignee null olabilir dedik kimseye atanmamis bir issue olabilir yani.
	private User assignee;
	
	@JoinColumn(name = "project_id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Project project;

	@OneToMany(fetch = FetchType.LAZY)
	private List<IssueHistory> issueHistories;
}
