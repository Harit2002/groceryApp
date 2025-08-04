package com.crio.grocery.service.impl;

import com.crio.grocery.entity.Item;
import com.crio.grocery.entity.dto.ItemRequestDTO;
import com.crio.grocery.entity.dto.ItemResponseDTO;
import com.crio.grocery.repository.ItemRepository;
import com.crio.grocery.service.IItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService implements IItemService {

    private final ItemRepository itemRepository;

    private ItemResponseDTO convertToResponseDTO(Item item) {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setCategory(item.getCategory());
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        return dto;
    }

    private Item convertToEntity(ItemRequestDTO dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setCategory(dto.getCategory());
        item.setPrice(dto.getPrice());
        item.setQuantity(dto.getQuantity());
        return item;
    }

    @Override
    public ItemResponseDTO createItem(ItemRequestDTO itemDTO) {
        Item item = convertToEntity(itemDTO);
        return convertToResponseDTO(itemRepository.save(item));
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponseDTO getItemById(Integer id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));
        return convertToResponseDTO(item);
    }

    @Override
    public ItemResponseDTO updateItem(Integer id, ItemRequestDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));

        item.setName(itemDTO.getName());
        item.setCategory(itemDTO.getCategory());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());

        return convertToResponseDTO(itemRepository.save(item));
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }
}
