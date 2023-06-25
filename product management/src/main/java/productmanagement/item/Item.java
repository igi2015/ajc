/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package productmanagement.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import productmanagement.model.NamedEntity;

import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "items")
public class Item extends NamedEntity {

	@Column(name = "price")
	@NotEmpty
	private String price;

	@Column(name = "description")
	@NotEmpty
	private String description;

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}








	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "item_categories", joinColumns = @JoinColumn(name = "item_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

	protected Set<Category> getCategoriesInternal() {
		if (this.categories == null) {
			this.categories = new HashSet<>();
		}
		return this.categories;
	}

	protected void setCategoriesInternal(Set<Category> categories) {
		this.categories = categories;
	}

	@XmlElement
	public List<Category> getCategories() {
		List<Category> sortedSpecs = new ArrayList<>(getCategoriesInternal());
		PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedSpecs);
	}

	public int getNrOfCategories() {
		return getCategoriesInternal().size();
	}

	public void addCategory(Category category) {
		getCategoriesInternal().add(category);
	}

}
