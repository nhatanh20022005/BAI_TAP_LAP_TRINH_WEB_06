package vn.iotstar.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "categoryName", columnDefinition = "NVARCHAR(255)")
	private String categoryName;

	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String images;

	@Column
	private Integer status;   // 0 hoặc 1 tùy đề bài

	// --- Category 1 - N Video ---
	@OneToMany(mappedBy = "category")
	private List<Video> videos;

	// --- Category N - N User ---
	@ManyToMany
	@JoinTable(
		name = "User_Category",
		joinColumns = @JoinColumn(name = "categoryId"),
		inverseJoinColumns = @JoinColumn(name = "username")
	)
	private List<User> users;
}
