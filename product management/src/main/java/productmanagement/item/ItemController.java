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

import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
class ItemController {

	private static final String VIEWS_ITEM_CREATE_OR_UPDATE_FORM = "items/createOrUpdateItemForm";
	private final ItemRepository itemRepository;

	public ItemController(ItemRepository management) {
		this.itemRepository = management;
	}

	@GetMapping("/items.html")
	public String showItemList(@RequestParam(defaultValue = "1") int page, Model model) {
		// Here we are returning an object of type 'Items' rather than a collection of Item
		// objects so it is simpler for Object-Xml mapping
		Items items = new Items();
		Page<Item> paginated = findPaginated(page);
		items.getItemList().addAll(paginated.toList());
		return addPaginationModel(page, paginated, model);

	}

	private String addPaginationModel(int page, Page<Item> paginated, Model model) {
		List<Item> listItems = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listItems", listItems);
		return "items/itemList";
	}

	private Page<Item> findPaginated(int page) {
		int pageSize = 25;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return itemRepository.findAll(pageable);
	}

	@GetMapping({ "/items" })
	public @ResponseBody Items showResourcesItemList() {
		// Here we are returning an object of type 'Items' rather than a collection of Item
		// objects so it is simpler for JSon/Object mapping
		Items items = new Items();
		items.getItemList().addAll(this.itemRepository.findAll());
		return items;
	}

	@GetMapping("/items/new")
	public String initCreationForm(Map<String, Object> model) {
		Item item = new Item();
		model.put("item", item);
		return VIEWS_ITEM_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/items/new")
	public String processCreationForm(@Valid Item item, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_ITEM_CREATE_OR_UPDATE_FORM;
		}

		this.itemRepository.save(item);
		return "redirect:/items.html";
	}


	@GetMapping("/items/{itemId}/delete")
	public String processDeleteForm(@PathVariable("itemId") int itemId) {
		Item item = this.itemRepository.findById(itemId);
		if (item != null) {
			this.itemRepository.delete(item);
		}
		return "redirect:/items.html";
	}



}
