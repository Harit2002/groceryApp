package com.crio.grocery.service;

import com.crio.grocery.entity.dto.ItemRequestDTO;
import com.crio.grocery.entity.dto.ItemResponseDTO;
import java.util.List;

public interface IItemService {
    ItemResponseDTO createItem(ItemRequestDTO itemDTO);
    List<ItemResponseDTO> getAllItems();
    ItemResponseDTO getItemById(Integer id);
    ItemResponseDTO updateItem(Integer id, ItemRequestDTO itemDTO);
    void deleteItem(Integer id);
}
