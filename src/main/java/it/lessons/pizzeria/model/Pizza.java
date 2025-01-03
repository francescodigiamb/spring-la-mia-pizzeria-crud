package it.lessons.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizzas")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "The name can't be null")
	@NotBlank(message = "The name can't be empty")
	@Size(max = 30, message = "The name can't be have max 30 characters")
	private String name;

	@NotNull(message = "The description can't be null")
	@NotBlank(message = "The description can't be empty")
	private String description;

	private String photo;

	@NotNull(message = "The price can't be null")
	@Min(value = 4, message = "The price must be at least 4")
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "Pizza [name=" + name + ", description=" + description + ", photo=" + photo + ", price=" + price + "]";
	}

}
